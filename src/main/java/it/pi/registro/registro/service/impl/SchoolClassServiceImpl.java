package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.dto.request.SubjectCreateRequestDTO;
import it.pi.registro.registro.dto.response.SchoolClassResponse;
import it.pi.registro.registro.dto.response.SubjectResponse;
import it.pi.registro.registro.entity.SchoolClass;
import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.repository.SchoolClassRepository;
import it.pi.registro.registro.repository.SubjectRepository;
import it.pi.registro.registro.service.SchoolClassService;
import it.pi.registro.registro.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SchoolClassServiceImpl implements SchoolClassService {

    @Autowired
    SchoolClassRepository schoolClassRepository;


    @Override
    public List<SchoolClassResponse> getAllSchoolClasses() {
        List<SchoolClass> schoolClasses = schoolClassRepository.findAll();
        List<SchoolClassResponse> schoolClassResponses = new ArrayList<>();
        schoolClasses.forEach(schoolClass -> {
            schoolClassResponses.add(new SchoolClassResponse(schoolClass.getName(), schoolClass.isActive()));
        });
        return schoolClassResponses;
    }
}
