package com.casestudy.notification.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

@Component
@Entity
public class NotificationMessageAudit {
	
	@Id
	@GeneratedValue
	private int id;
	
	@UpdateTimestamp
	private Timestamp receivedOn;
	
	@CreationTimestamp
	private Timestamp deliveredOn;
	
	private String notificationMessage;

	@Lob
	public String getNotificationMessage() {
		return notificationMessage;
	}

	@Lob
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	public int getId() {
		return id;
	}	
	
}
