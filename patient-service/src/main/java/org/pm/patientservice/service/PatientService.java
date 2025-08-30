package org.pm.patientservice.service;

import org.pm.patientservice.dto.PatientResponseDTO;
import org.pm.patientservice.mapper.PatientMapper;
import org.pm.patientservice.model.Patient;
import org.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patientList = patientRepository.findAll();

        return patientList.stream()
                .map(PatientMapper::toDTO).toList();
    }
}
