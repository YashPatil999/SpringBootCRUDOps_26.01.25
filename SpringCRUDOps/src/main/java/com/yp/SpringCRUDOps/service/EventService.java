package com.yp.SpringCRUDOps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yp.SpringCRUDOps.entity.Event;
import com.yp.SpringCRUDOps.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	EventRepository er;
	
	public String InsertData(Event e)
	{
		return er.InsertData(e);
	}
	
	public String DeleteData(int id)
	{
		return er.DeleteData(id);
	}
	
	public String UpdateData(Event e, int id)
	{
		return er.UpdateData(e, id);
	}
	
	public Event GetSelectedData(int id)
	{
		return er.GetSelectedData(id);
	}
	
	public List<Event> GetAllData()
	{
		return er.GetAllData();
	}
}
