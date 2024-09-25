package com.rishabh.healthcare.appointment.service;

import com.rishabh.healthcare.appointment.model.Appointment;
import com.rishabh.healthcare.appointment.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AppointmentServiceTest {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@MockBean
	private AppointmentRepository appointmentRepository;
	
	@MockBean
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Test
	public void createAppointmentTest() {
		Appointment appointment = new Appointment();
		appointment.setId(1L);
		appointment.setDescription("Test Appointment");
		
		Mockito.when(appointmentRepository.save(Mockito.any(Appointment.class))).thenReturn(appointment);
		
		Appointment result = appointmentService.createAppointment(appointment);
		
		assertEquals(appointment.getId(), result.getId());
		Mockito.verify(kafkaTemplate).send(Mockito.anyString(), Mockito.anyString());
	}
	
	@Test
	public void getAppointmentsByPatientIdTest() {
		Appointment appointment = new Appointment();
		appointment.setId(1L);
		appointment.setPatientId(1L);
		
		Mockito.when(appointmentRepository.findByPatientId(1L)).thenReturn(List.of(appointment));
		
		List<Appointment> result = appointmentService.getAppointmentsByPatientId(1L);
		
		assertEquals(1, result.size());
		assertEquals(1L, result.get(0).getPatientId());
	}
}