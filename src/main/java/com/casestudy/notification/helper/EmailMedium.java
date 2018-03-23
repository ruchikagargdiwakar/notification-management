package com.casestudy.notification.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.casestudy.notification.domain.NotificationMessage;

public class EmailMedium extends DeliveryMedium {

	private static final Logger logger = LoggerFactory.getLogger(EmailMedium.class);
	
	@Override
	public void sendNotification(NotificationMessage notificationMessage) {
		logger.info("To:"+notificationMessage.getTo());
		logger.info("From:"+notificationMessage.getFrom());
		logger.info("content:"+notificationMessage.getContent());
		logger.info("Notification mailed");
	}

}
