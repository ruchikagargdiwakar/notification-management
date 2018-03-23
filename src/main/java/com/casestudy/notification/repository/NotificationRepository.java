package com.casestudy.notification.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.casestudy.notification.domain.NotificationMessageAudit;

@Repository
public class NotificationRepository {
	
	@Autowired
	EntityManager em;
	
	public void saveMessageAudit(NotificationMessageAudit notificationMessageAudit) {	
		System.out.println("Persisting audit info");
		em.persist(notificationMessageAudit);
	}
	
	public void updateMessageAudit(NotificationMessageAudit notificationMessageAudit) {
		System.out.println("Updating the delivered time");
		em.merge(notificationMessageAudit);
	}
	
	public NotificationMessageAudit getById(int id) {
		return em.find(NotificationMessageAudit.class, id);
	}
	
}
