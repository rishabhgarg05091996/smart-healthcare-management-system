package com.rishabh.healthcare.notification.service;

import com.rishabh.healthcare.notification.model.AppointmentEvent;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
	public void sendNotification(AppointmentEvent event) {
		// Here, you would implement the actual logic to send notifications.
		// For simplicity, we'll just print out the event.
		System.out.println("Sending notification for appointment: " + event);
	}
}