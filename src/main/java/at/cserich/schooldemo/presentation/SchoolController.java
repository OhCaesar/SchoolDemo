package at.cserich.schooldemo.presentation;

import at.cserich.schooldemo.domain.School;
import at.cserich.schooldemo.service.SchoolService;
import at.cserich.schooldemo.service.dtos.SchoolDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping(path = SchoolController.BASE_URL)
@RequiredArgsConstructor
public class SchoolController extends AbstractRestController {

    private final SchoolService schoolService;
    public static final String BASE_URL = "/api/school";
    public static final String PATH_INDEX = "/";


    @Operation(description = "returning list of all schools")
    @GetMapping(path = {"",PATH_INDEX})
    public HttpEntity<List<SchoolDto>> getSchoolList(){
        log.debug("Trying to return all schools!");
        List<SchoolDto> schoolsDto =wrappedServiceExecution(schoolService::getSchools).stream().map(SchoolDto::new).toList();
        log.info("Successfully returning all schools");
        return ResponseEntity.ok().body(schoolsDto);
    }

    @Operation(description = "Deleting School by token")
    @DeleteMapping(path = PATH_INDEX)
    public void deleteSchoolByToken(@Parameter(description = "") @PathVariable String token){
        log.debug("Trying to delete school with token {}", token);
        wrappedServiceExecution(token,schoolService::removeSchoolByToken);
        log.info("Sucessfully received school deletion in Controller Layer");
    }

    @Operation(description = "Creation of School entity")
    @PostMapping(path = PATH_INDEX)
    public HttpEntity<SchoolDto> createSchool(@Parameter(description = "School entity that should be created") SchoolDto school){
        log.debug("Trying to create school with body {}", school);
        SchoolDto schoolDto = wrappedServiceExecution(school,schoolService::createSchool);
        log.info("Successfully received creation of school Object {} ",schoolDto);
        return ResponseEntity.ok().body(schoolDto);
    }

}
