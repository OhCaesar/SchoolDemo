package at.cserich.schooldemo.service.dtos;

import at.cserich.schooldemo.domain.Address;
import at.cserich.schooldemo.domain.Student;
import at.cserich.schooldemo.domain.Subject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public record StudentDto(String firstname, String lastname, Address address, ArrayList<Subject> subjects) {
    public StudentDto(Student origin){
        this(origin.getFirstName(), origin.getLastName(), origin.getAddress(),origin.getSubjects());
        log.info("StudentDto for Object - {} created ",origin);
    }

}
