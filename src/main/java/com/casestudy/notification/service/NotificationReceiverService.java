package com.casestudy.notification.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.casestudy.notification.domain.NotificationMessage;
import com.casestudy.notification.domain.NotificationMessageAudit;
import com.casestudy.notification.helper.DeliveryMedium;
import com.casestudy.notification.helper.EmailMedium;
import com.casestudy.notification.helper.SlackMedium;

@Service
@Transactional
public class NotificationReceiverService {
	
	DeliveryMedium deliveryMedium;
	
	private int noOfMessagesDelivered = 0;
	
	@Autowired
	NotificationMessageService notificationMessageService;
	
	private static final Logger logger = LoggerFactory.getLogger(NotificationReceiverService.class);
	
	@JmsListener(destination = "MessageProcessingQueue")
	/**
	 * It marks a method to be the target of a JMS messagelistener on the specified destination. 
	 * In our case the destination is "MessageProcessingQueue".
	 * This class is responsible to listen messsage from the inbound queue and process the same.
	 * @param notificationMessage
	 */
	public void receiveMessage(NotificationMessage notificationMessage) {
		System.out.println("Received <" + notificationMessage.toString() + ">");
				
		//send message
		List<String> deliveryMediumList = notificationMessage.getDeliveryMedium();
		
		for(String deliveryMediumType:deliveryMediumList) {
			System.out.println("deliveryMediumType-->"+deliveryMediumType);			
			if("email".equalsIgnoreCase(deliveryMediumType)) {
				deliveryMedium = new EmailMedium();
			}else if("slack".equalsIgnoreCase(deliveryMediumType)) {
				deliveryMedium = new SlackMedium();
			}else {
				logger.warn("Provide medium type(s)");
				break;
			}
			deliveryMedium.sendNotification(notificationMessage);
			
		}	
		
		noOfMessagesDelivered++;
		System.out.println("noOfMessagesDelivered::"+ noOfMessagesDelivered);
		
		NotificationMessageAudit notificationMessageAudit = notificationMessageService.getById(noOfMessagesDelivered);
		while(notificationMessageAudit == null) {
			notificationMessageAudit = notificationMessageService.getById(noOfMessagesDelivered);
		}
		
		notificationMessageAudit.setNotificationMessage(notificationMessage.toString());
		notificationMessageService.updateMessageAudit(notificationMessageAudit);
		
	}
}
