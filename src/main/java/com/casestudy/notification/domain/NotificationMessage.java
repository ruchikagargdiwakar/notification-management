package com.casestudy.notification.domain;

import java.util.ArrayList;
import java.util.List;

public class NotificationMessage {
	
	
	//private int id;
	private String to;
	private String from;
	private String content;
	private List<String> deliveryMedium = new ArrayList<String>();
	
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getDeliveryMedium() {
		return deliveryMedium;
	}
	public void setDeliveryMedium(List<String> deliveryMedium) {
		this.deliveryMedium = deliveryMedium;
	}
	
	@Override
	public String toString() {
		/*return "NotificationMessage [id=" + id + ", to=" + to + ", from=" + from + ", content=" + content
				+ ", deliveryMedium=" + deliveryMedium + "]";*/
		return "NotificationMessage [to=" + to + ", from=" + from + ", content=" + content
				+ ", deliveryMedium=" + deliveryMedium + "]";
	}	

}
