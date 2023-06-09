package com.example.demo.service;


import com.example.demo.entity.MedicalReport;
import com.example.demo.entity.PatientData;
import com.example.demo.entity.dto.MedicalReportDTO;
import com.example.demo.entity.dto.PatientDataDTO;
import com.example.demo.mapper.DTOEntityMapper;
import com.example.demo.repository.MedicalReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.mapper.DTOEntityMapper.mapDTOToMedicalReport;
import static com.example.demo.mapper.DTOEntityMapper.mapMedicalReportToDTO;

@Service
public class MedicalReportService {
    @Autowired
    private  MedicalReportRepository medicalReportRepository;



    public MedicalReportDTO getMedicalReportById(Long id) {
        Optional<MedicalReport> medicalReport = medicalReportRepository.findById(id);
        return medicalReport.map(DTOEntityMapper::mapMedicalReportToDTO).orElse(null);
    }

    public MedicalReportDTO createMedicalReport(MedicalReportDTO medicalReportDTO) {
        MedicalReport medicalReport = mapDTOToMedicalReport(medicalReportDTO);
        MedicalReport createdMedicalReport = medicalReportRepository.save(medicalReport);
        return mapMedicalReportToDTO(createdMedicalReport);
    }

    public MedicalReportDTO updateMedicalReport(Long id, MedicalReportDTO medicalReportDTO) {
        Optional<MedicalReport> medicalReport = medicalReportRepository.findById(id);
        if (medicalReport.isPresent()) {
            MedicalReport existingMedicalReport = medicalReport.get();

            PatientDataDTO updatedPatientDataDTO = medicalReportDTO.getPatientDataDTO();
            if (updatedPatientDataDTO != null) {
                PatientData existingPatientData = existingMedicalReport.getPatientData();
                if (existingPatientData == null) {
                    existingPatientData = new PatientData();
                    existingMedicalReport.setPatientData(existingPatientData);
                }
                existingPatientData.setNicNumber(updatedPatientDataDTO.getNicNumber());
                existingPatientData.setSickness(updatedPatientDataDTO.getSickness());
                existingPatientData.setPhone(updatedPatientDataDTO.getPhone());
            }


            MedicalReport updatedMedicalReport = medicalReportRepository.save(existingMedicalReport);
            return mapMedicalReportToDTO(updatedMedicalReport);
        } else {
            return null;
        }
    }

    public boolean deleteMedicalReport(Long id) {
        Optional<MedicalReport> medicalReport = medicalReportRepository.findById(id);
        if (medicalReport.isPresent()) {
            medicalReportRepository.delete(medicalReport.get());
            return true;
        } else {
            return false;
        }
    }




}

