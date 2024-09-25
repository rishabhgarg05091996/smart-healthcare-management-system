package com.rishabh.healthcare.appointment.service;

import com.rishabh.healthcare.appointment.model.Appointment;
import com.rishabh.healthcare.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private static final String APPOINTMENT_TOPIC = "appointments";
	
	public Appointment createAppointment(Appointment appointment) {
		Appointment savedAppointment = appointmentRepository.save(appointment);
		kafkaTemplate.send(APPOINTMENT_TOPIC, "New appointment created: " + savedAppointment);
		return savedAppointment;
	}
	
	public List<Appointment> getAppointmentsByPatientId(Long patientId) {
		return appointmentRepository.findByPatientId(patientId);
	}
}