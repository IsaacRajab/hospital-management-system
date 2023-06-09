package com.example.demo.mapper;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.MedicalReport;
import com.example.demo.entity.PatientData;
import com.example.demo.entity.Prescription;
import com.example.demo.entity.dto.DoctorDTO;
import com.example.demo.entity.dto.MedicalReportDTO;
import com.example.demo.entity.dto.PatientDataDTO;
import com.example.demo.entity.dto.PrescriptionDTO;

public class DTOEntityMapper {                                          // this class i use it to map from dto to entity and opist
   public static PatientDataDTO mapPatientDataToDTO(PatientData patientData) {
        PatientDataDTO patientDataDTO = new PatientDataDTO();
        patientDataDTO.setNicNumber(patientData.getNicNumber());
        patientDataDTO.setSickness(patientData.getSickness());
        patientDataDTO.setPhone(patientData.getPhone());
        return patientDataDTO;
    }



    public static PatientData mapDTOToPatientData(PatientDataDTO patientDataDTO) {
        PatientData patientData = new PatientData();
        patientData.setNicNumber(patientDataDTO.getNicNumber());
        patientData.setSickness(patientDataDTO.getSickness());
        patientData.setPhone(patientDataDTO.getPhone());
        return patientData;
    }
    public static MedicalReportDTO mapMedicalReportToDTO(MedicalReport medicalReport) {
        MedicalReportDTO medicalReportDTO = new MedicalReportDTO();
        medicalReportDTO.setId(medicalReport.getId());
        medicalReportDTO.setPatientDataDTO(DTOEntityMapper.mapPatientDataToDTO(medicalReport.getPatientData()));
        // Map other properties as needed
        return medicalReportDTO;
    }

    public static MedicalReport mapDTOToMedicalReport(MedicalReportDTO medicalReportDTO) {
        MedicalReport medicalReport = new MedicalReport();
        medicalReport.setPatientData(DTOEntityMapper.mapDTOToPatientData(medicalReportDTO.getPatientDataDTO()));
        // Map other properties as needed
        return medicalReport;
    }
    public static Prescription mapDTOToPrescription(PrescriptionDTO prescriptionDTO) {
        Prescription prescription = new Prescription();
        prescription.setSerialNumber(prescriptionDTO.getSerialNumber());
        prescription.setPatientData(DTOEntityMapper.mapDTOToPatientData(prescriptionDTO.getPatientData()));
        // Map other properties as needed
        return prescription;
    }

    public static PrescriptionDTO mapPrescriptionToDTO(Prescription prescription) {
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setSerialNumber(prescription.getSerialNumber());
        prescriptionDTO.setPatientData(DTOEntityMapper.mapPatientDataToDTO(prescription.getPatientData()));
        // Map other properties as needed
        return prescriptionDTO;
    }
    public static DoctorDTO mapDoctorToDoctorDTO(Doctor doctor) {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setName(doctor.getName());
        doctorDTO.setSpecialization(doctor.getSpecialization());
        doctorDTO.setRank(doctor.getRank());
        doctorDTO.setSalary(doctor.getSalary());
        return doctorDTO;
    }

    public static Doctor mapDoctorDTOToDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setRank(doctorDTO.getRank());
        doctor.setSalary(doctorDTO.getSalary());
        return doctor;
    }
}
