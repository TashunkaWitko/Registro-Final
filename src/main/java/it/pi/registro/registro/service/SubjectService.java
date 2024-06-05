package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.SubjectCreateRequestDTO;
import it.pi.registro.registro.dto.response.SubjectResponse;
import it.pi.registro.registro.entity.Subject;

import java.util.List;

public interface SubjectService {
    Subject createSubject(SubjectCreateRequestDTO subjectCreateRequestDTO);

    Subject getSubjectById(Long subjectId);

    List<SubjectResponse> getAllSubjects();

    Subject updateSubject(Subject subject);

    void deleteSubject(Long subjectId);
}
