package com.rishabh.healthcare.patient.service;

import com.rishabh.healthcare.patient.exception.PatientNotFoundException;
import com.rishabh.healthcare.patient.model.Patient;
import com.rishabh.healthcare.patient.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PatientServiceTest {
	
	@Autowired
	private PatientService patientService;
	
	@MockBean
	private PatientRepository patientRepository;
	
	@Test
	public void createPatientTest() {
		Patient patient = new Patient();
		patient.setName("John Doe");
		
		Mockito.when(patientRepository.save(Mockito.any(Patient.class))).thenReturn(patient);
		
		assertEquals(patient, patientService.createPatient(patient));
	}
	
	@Test
	public void getPatientByIdTest() {
		Patient patient = new Patient();
		patient.setId(1L);
		patient.setName("John Doe");
		
		Mockito.when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));
		
		assertEquals(patient, patientService.getPatientById(1L));
	}
	
	@Test
	public void getPatientByIdNotFoundTest() {
		Mockito.when(patientRepository.findById(1L)).thenReturn(Optional.empty());
		
		assertThrows(PatientNotFoundException.class, () -> patientService.getPatientById(1L));
	}
	
	@Test
	public void updatePatientTest() {
		Patient patient = new Patient();
		patient.setId(1L);
		patient.setName("John Doe");
		
		Mockito.when(patientRepository.existsById(1L)).thenReturn(true);
		Mockito.when(patientRepository.save(Mockito.any(Patient.class))).thenReturn(patient);
		
		assertEquals(patient, patientService.updatePatient(1L, patient));
	}
	
	@Test
	public void deletePatientTest() {
		Mockito.when(patientRepository.existsById(1L)).thenReturn(true);
		Mockito.doNothing().when(patientRepository).deleteById(1L);
		
		patientService.deletePatient(1L);
		
		Mockito.verify(patientRepository, Mockito.times(1)).deleteById(1L);
	}
}
