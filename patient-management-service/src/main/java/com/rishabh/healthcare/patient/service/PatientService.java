package com.rishabh.healthcare.patient.service;

import com.rishabh.healthcare.patient.repository.PatientRepository;
import com.rishabh.healthcare.patient.exception.PatientNotFoundException;
import com.rishabh.healthcare.patient.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public Patient createPatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	public Patient getPatientById(Long id) {
		return patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
	}
	
	public Patient updatePatient(Long id, Patient patient) {
		if (!patientRepository.existsById(id)) {
			throw new PatientNotFoundException("Patient not found");
		}
		patient.setId(id);
		return patientRepository.save(patient);
	}
	
	public void deletePatient(Long id) {
		if (!patientRepository.existsById(id)) {
			throw new PatientNotFoundException("Patient not found");
		}
		patientRepository.deleteById(id);
	}
}