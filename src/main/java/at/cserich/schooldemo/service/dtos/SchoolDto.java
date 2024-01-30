package at.cserich.schooldemo.service.dtos;

import at.cserich.schooldemo.domain.Address;
import at.cserich.schooldemo.domain.School;
import at.cserich.schooldemo.domain.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public record SchoolDto(String name, Address address, ArrayList<Student> students) {

    public SchoolDto(School school){
        this(school.getName(),school.getSchoolAddress(),school.getStudents());
        log.info("SchoolDto for Object - {}",school);
    }
}
