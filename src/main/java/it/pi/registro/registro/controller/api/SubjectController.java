package it.pi.registro.registro.controller.api;

import it.pi.registro.registro.dto.request.SubjectCreateRequestDTO;
import it.pi.registro.registro.dto.response.SubjectResponse;
import it.pi.registro.registro.dto.response.UserDataResponseDTO;
import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.service.SubjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/subjects")
public class SubjectController {

    private SubjectService subjectService;

    /**
     * Create simple subject
     */
    @PostMapping
    public ResponseEntity<Subject> createSubject(@Valid @RequestBody SubjectCreateRequestDTO subjectCreateRequestDTO){
        return new ResponseEntity<>(subjectService.createSubject(subjectCreateRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SubjectResponse>> getAllSubjects(){
        return new ResponseEntity<>(subjectService.getAllSubjects(), HttpStatus.OK);

    }

}
