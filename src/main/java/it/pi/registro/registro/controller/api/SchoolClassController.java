package it.pi.registro.registro.controller.api;

import it.pi.registro.registro.dto.request.SubjectCreateRequestDTO;
import it.pi.registro.registro.dto.response.SchoolClassResponse;
import it.pi.registro.registro.dto.response.SubjectResponse;
import it.pi.registro.registro.entity.SchoolClass;
import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.service.SchoolClassService;
import it.pi.registro.registro.service.SubjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/classroom")
public class SchoolClassController {

    private SchoolClassService schoolClassService;

    /**
     * Create simple subject
     */
//    @PostMapping
//    public ResponseEntity<Subject> createSubject(@Valid @RequestBody SubjectCreateRequestDTO subjectCreateRequestDTO){
//        return new ResponseEntity<>(subjectService.createSubject(subjectCreateRequestDTO), HttpStatus.CREATED);
//    }

    @GetMapping
    public ResponseEntity<List<SchoolClassResponse>> getAllSubjects(){
        return new ResponseEntity<>(schoolClassService.getAllSchoolClasses(), HttpStatus.OK);

    }

}
