package com.casestudy.notification.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.notification.domain.NotificationMessageAudit;
import com.casestudy.notification.repository.NotificationRepository;

@Service
@Transactional
public class NotificationMessageService {
	
	@Autowired
	NotificationRepository notificationRepository;
	
	public void saveMessageAudit(NotificationMessageAudit notificationMessageAudit) {		
		notificationRepository.saveMessageAudit(notificationMessageAudit);
	}
	
	public void updateMessageAudit(NotificationMessageAudit notificationMessageAudit) {		
		notificationRepository.updateMessageAudit(notificationMessageAudit);
	}
	
	public NotificationMessageAudit getById(int id) {
		return notificationRepository.getById(id);
	}
	
}
