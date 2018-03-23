package com.casestudy.notification.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.casestudy.notification.domain.NotificationMessage;
import com.casestudy.notification.repository.NotificationRepository;

@Service
@Transactional
public class NotificationTransmiterService {
	
	private static final Logger logger = LoggerFactory.getLogger(NotificationTransmiterService.class);
	
	@Autowired 
	private JmsTemplate jmsTemplate;
	
	@Autowired
	NotificationRepository notificationRepository;
	
	public void addMessageToQueue(NotificationMessage notificationMessage) {
		logger.info("Adding message to queue....");
	    // Post message to the message queue named "OrderTransactionQueue"
	    jmsTemplate.convertAndSend("MessageProcessingQueue", notificationMessage);	    
	    
	}
}
