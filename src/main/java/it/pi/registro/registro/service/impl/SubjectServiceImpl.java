package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.dto.request.SubjectCreateRequestDTO;
import it.pi.registro.registro.dto.response.SubjectResponse;
import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.repository.SubjectRepository;
import it.pi.registro.registro.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Subject createSubject(SubjectCreateRequestDTO subjectCreateRequestDTO) {
        return subjectRepository.save(new Subject(subjectCreateRequestDTO.getSubjectName(), subjectCreateRequestDTO.getSubjectDescription()));
    }

    @Override
    public Subject getSubjectById(Long subjectId) {
        return null;
    }

    @Override
    public List<SubjectResponse> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        List<SubjectResponse> subjectResponses = new ArrayList<SubjectResponse>();
        subjects.forEach(subject -> {
            subjectResponses.add(new SubjectResponse(subject.getDescription(), subject.getName()));
        });
        return subjectResponses;
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return null;
    }

    @Override
    public void deleteSubject(Long subjectId) {

    }
}
