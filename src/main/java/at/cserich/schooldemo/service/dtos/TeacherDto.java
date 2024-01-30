package at.cserich.schooldemo.service.dtos;

import at.cserich.schooldemo.domain.Address;
import at.cserich.schooldemo.domain.Subject;
import at.cserich.schooldemo.domain.Teacher;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public record TeacherDto(String firstname, String lastname, Address address) {
    public TeacherDto(Teacher origin){
        this(origin.getFirstName(),origin.getLastName(),origin.getAddress());
        log.info("TeacherDto of Object - {} created",origin);
    }
}
