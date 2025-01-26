package com.yp.SpringCRUDOps.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventId;
	private String eventName;
	private String eventDate;
	private int noOfPeoples;
	private int totalAmount;

	public Event() {

	}

	public Event(int eventId, String eventName, String eventDate, int noOfPeoples, int totalAmount) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.noOfPeoples = noOfPeoples;
		this.totalAmount = totalAmount;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public int getNoOfPeoples() {
		return noOfPeoples;
	}

	public void setNoOfPeoples(int noOfPeoples) {
		this.noOfPeoples = noOfPeoples;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventDate=" + eventDate + ", noOfPeoples="
				+ noOfPeoples + ", totalAmount=" + totalAmount + "]";
	}

}
