package com.casestudy.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.notification.domain.NotificationMessage;
import com.casestudy.notification.domain.NotificationMessageAudit;
import com.casestudy.notification.service.NotificationMessageService;
import com.casestudy.notification.service.NotificationTransmiterService;

@RestController
public class NotificationController {
	
	@Autowired
	NotificationTransmiterService notificationTransmiterService;
	
	@Autowired
	NotificationMessageService notificationMessageService;
	
	@PostMapping("/notify")
	public void sendMessage(@RequestBody NotificationMessage notificationMessage) {
		//add message to queue using transmitter service method
		notificationTransmiterService.addMessageToQueue(notificationMessage);
		
		//persist message with other details in db
		NotificationMessageAudit notificationMessageAudit = new NotificationMessageAudit();
		notificationMessageAudit.setNotificationMessage(notificationMessage.toString());		
		notificationMessageService.saveMessageAudit(notificationMessageAudit);
		notificationMessageAudit = null;		
	}

}
