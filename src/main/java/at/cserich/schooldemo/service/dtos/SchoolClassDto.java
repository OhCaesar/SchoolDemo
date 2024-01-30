package at.cserich.schooldemo.service.dtos;

import at.cserich.schooldemo.domain.SchoolClass;
import at.cserich.schooldemo.domain.Student;
import at.cserich.schooldemo.domain.Teacher;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
@Slf4j
public record SchoolClassDto(String classDefinition, Teacher classTeacher, Teacher substituteClassTeacher, Student studentsRepresentative, ArrayList<Student> students) {
        public SchoolClassDto(SchoolClass schoolClass){
                this(schoolClass.getClassDefinition(),schoolClass.getClassTeacher(),schoolClass.getSubstituteClassTeacher(),schoolClass.getStudentsRepresentative(),schoolClass.getStudents());
                log.info("SchoolClassDto with origin - {} created " , schoolClass);
        }

}
