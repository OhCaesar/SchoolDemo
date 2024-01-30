package at.cserich.schooldemo.service;

import at.cserich.schooldemo.domain.School;
import at.cserich.schooldemo.persistence.School.SchoolRepository;
import at.cserich.schooldemo.service.dtos.SchoolDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor

@Service
@Transactional(readOnly = true)
@Slf4j
public class SchoolService {

    private final SchoolRepository schoolRepository;

    //token

    //temp date

    public List<School> getSchools(){
        List<School> schools= schoolRepository.findAll();
        return schools;
    }

    public Optional<School> getSchoolByName(String schoolName){
        log.info("Try to get school with name {}",schoolName);
        Optional<School> schoolEntity = schoolRepository.findSchoolByName(schoolName);
        schoolEntity.ifPresentOrElse(entity -> log.info("Found School {} with name {}",schoolEntity,schoolName),
                () -> log.error("Found no school with name {}", schoolName));
        return schoolEntity;
    }


    public Optional<SchoolDto> getSchool(String token){
        Optional<School> school = schoolRepository.findSchoolByToken(token);

        school.ifPresentOrElse(entity -> log.info("Found School {} with token {}",school,token),
                () -> log.error("Found no school with token {}",token));
        return school.map(SchoolDto::new);
    }

    @Transactional(readOnly = false)
    public SchoolDto createSchool(SchoolDto data){
        log.debug("Trying to create new school from dto {}",data);

        Objects.requireNonNull(data,"Incoming data has to have a valid value!");

        School school = School.builder()
                .name(data.name())
                .schoolAddress(data.address())
                .build();
        log.trace("Mapped dto - value into School Model Object");

        log.info("Created school {}",school);

        return new SchoolDto(schoolRepository.save(school));
    }

    @Transactional(readOnly = false)
    public SchoolDto updateSchool(String token, SchoolDto schoolDto){
        log.debug("Trying to update entity with token {} and new value {}",token,schoolDto);

        Objects.requireNonNull(token,"Token cannot be null!");
        Objects.requireNonNull(schoolDto,"Value cannot be updated with null");

        log.trace("trying to find entity with token {}",token);
        Optional<School> schoolEntity = schoolRepository.findSchoolByToken(token);

        if(schoolEntity.isEmpty()){
            log.warn("School with token {} cannot be found!",token);
            throw new EntityNotFoundException("School - Entity cannot be found!");
        }
        School school = schoolEntity.get();

        if(schoolDto.name()!= null) school.setName(schoolDto.name());
        if(schoolDto.students()!= null) school.setStudents(schoolDto.students());
        if(schoolDto.address()!= null) school.setSchoolAddress(schoolDto.address());

        log.info("Successfully updated school - entity {}, {}", token,schoolDto);
        return new SchoolDto(schoolRepository.save(school));

    }

    @Transactional
    public void removeSchoolByToken(String token){
        log.debug("Trying to remove School with token {} from repository context",token);
        Objects.requireNonNull(token,"token cannot be null");
        if(token.isEmpty()){
            log.warn("Empty token is not valid while trying to delete school");
            throw new EntityNotFoundException("");
        }
        log.trace("Trying to get current item with token {}" , token);
        Optional<School> school = schoolRepository.findSchoolByToken(token);
        if(!school.isPresent()){
            log.warn("School with token {} could not be found",token);
            throw new EntityNotFoundException("");
        }

        schoolRepository.delete(school.get());
        log.info("Successfully deleted school with token {} ",token);

    }


}
