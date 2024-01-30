package at.cserich.schooldemo.service.dtos;

import at.cserich.schooldemo.domain.Student;
import at.cserich.schooldemo.domain.Subject;
import at.cserich.schooldemo.domain.Teacher;
import at.cserich.schooldemo.domain.Test;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public record TestDto(Subject subject, int grade, LocalDateTime testTime, Teacher correctingTeacher, Student student) {

    public TestDto(Test origin){
        this(origin.getSubject(),origin.getGrade(),origin.getTestTime(),origin.getCorrectingTeacher(),origin.getStudent());
        log.info("TestDto of Object - {} created",origin);
    }
}
