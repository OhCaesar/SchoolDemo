package at.cserich.schooldemo.service.dtos;

import at.cserich.schooldemo.domain.Subject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record SubjectDto(String subjectName) {

    public SubjectDto(Subject origin){
        this(origin.getSubjectName());
        log.info("SubjectDto of Object - {} created", origin);
    }
}
