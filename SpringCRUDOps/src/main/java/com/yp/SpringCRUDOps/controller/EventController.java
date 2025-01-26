package com.yp.SpringCRUDOps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yp.SpringCRUDOps.entity.Event;
import com.yp.SpringCRUDOps.service.EventService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/Event")
public class EventController {

	@Autowired
	EventService es;
	
	@PostMapping("/insertData")
	public String InsertData(@RequestBody Event e)
	{
		return es.InsertData(e);
	}
	
	@DeleteMapping("/deleteData/{Id}")
	public String DeleteData(@PathVariable("Id") int id)
	{
		return es.DeleteData(id);
	}
	
	@PutMapping("/updateData/{Id}")
	public String UpdateData(@RequestBody Event e, @PathVariable("Id") int id)
	{
		return es.UpdateData(e, id);
	}
	
	@GetMapping("/getSelectedData/{Id}")
	public Event GetSelectedData(@PathVariable("Id") int id)
	{
		return es.GetSelectedData(id);
	}
	
	@GetMapping("/getAllData")
	public List<Event> GetAllData() {
		return es.GetAllData();
	}
	
}
