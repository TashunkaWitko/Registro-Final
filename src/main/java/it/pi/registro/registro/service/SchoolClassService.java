package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.SubjectCreateRequestDTO;
import it.pi.registro.registro.dto.response.SchoolClassResponse;
import it.pi.registro.registro.dto.response.SubjectResponse;
import it.pi.registro.registro.entity.SchoolClass;
import it.pi.registro.registro.entity.Subject;

import java.util.List;

public interface SchoolClassService {

    List<SchoolClassResponse> getAllSchoolClasses();
}
