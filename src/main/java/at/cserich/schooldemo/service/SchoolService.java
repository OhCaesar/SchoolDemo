package at.cserich.schooldemo.service;

import at.cserich.schooldemo.domain.School;
import at.cserich.schooldemo.persistence.School.SchoolRepository;
import at.cserich.schooldemo.service.dtos.SchoolDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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


    public Optional<School> getSchool(String token){
        Optional<School> school = schoolRepository.findSchoolByToken(token);

        school.ifPresentOrElse(entity -> log.info("Found School {} with token {}",school,token),
                () -> log.error("Found no school with token {}",token));
        return school;
    }

    public Optional<School> updateSchool(String token, SchoolDto schoolDto){
        return null;

    }
}
