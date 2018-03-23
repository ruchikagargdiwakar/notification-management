package com.casestudy.notification.helper;

import com.casestudy.notification.domain.NotificationMessage;

public abstract class DeliveryMedium {
	
	abstract public void sendNotification(NotificationMessage notificationMessage);

}
