package com.rishabh.healthcare.notification.consumer;

import com.rishabh.healthcare.notification.model.AppointmentEvent;
import com.rishabh.healthcare.notification.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentEventConsumer {
	
	private final NotificationService notificationService;
	
	public AppointmentEventConsumer(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	@KafkaListener(topics = "appointments", groupId = "notification-service-group")
	public void consume(AppointmentEvent event, Acknowledgment ack) {
		notificationService.sendNotification(event);
		ack.acknowledge();
	}
}