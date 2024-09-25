package com.rishabh.healthcare.notification.service;

import com.rishabh.healthcare.notification.model.AppointmentEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NotificationServiceTest {
	
	private final NotificationService notificationService = Mockito.mock(NotificationService.class);
	
	@Test
	void testSendNotification() {
		AppointmentEvent event = new AppointmentEvent();
		event.setAppointmentId(1L);
		event.setPatientId(100L);
		event.setDoctorId(200L);
		event.setAppointmentTime("2024-09-01 10:00");
		
		notificationService.sendNotification(event);
		
		Mockito.verify(notificationService, Mockito.times(1)).sendNotification(event);
	}
}