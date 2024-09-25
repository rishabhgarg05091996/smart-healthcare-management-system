package com.rishabh.healthcare.patient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import com.rishabh.healthcare.patient.model.Patient;

import com.rishabh.healthcare.patient.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	@Autowired
	private PatientService patientService;
	
	@PostMapping
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
		return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
		Patient patient = patientService.getPatientById(id);
		logger.info("Fetched Patient: {}", patient);
		return ResponseEntity.ok(patient);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
		return ResponseEntity.ok(patientService.updatePatient(id, patient));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
		patientService.deletePatient(id);
		return ResponseEntity.noContent().build();
	}
}