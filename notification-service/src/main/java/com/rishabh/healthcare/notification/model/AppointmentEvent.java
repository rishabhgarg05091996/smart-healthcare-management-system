package com.rishabh.healthcare.notification.model;

import lombok.Data;

@Data
public class AppointmentEvent {
	private Long appointmentId;
	private Long patientId;
	private Long doctorId;
	private String appointmentTime;
}