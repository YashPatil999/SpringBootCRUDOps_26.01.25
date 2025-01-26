package com.yp.SpringCRUDOps.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yp.SpringCRUDOps.entity.Event;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class EventRepository {

	@Autowired
	SessionFactory sf;

	public String InsertData(Event e) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(e);
		tr.commit();
		ss.close();
		return "Data Inserted Successfully";
	}

	public String DeleteData(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Event e = ss.get(Event.class, id);
		ss.remove(e);
		tr.commit();
		ss.close();
		return "Data Deleted Successfully";
	}

	public String UpdateData(Event e, int id)
	{
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Event event = ss.get(Event.class, id);
		event.setEventName(e.getEventName());
		event.setEventDate(e.getEventDate());
		event.setNoOfPeoples(e.getNoOfPeoples());
		event.setTotalAmount(e.getTotalAmount());
		ss.merge(event);
		tr.commit();
		ss.close();
		return"Data Updated Successfully";
	}
	
	public Event GetSelectedData(int id)
	{
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		Event e = ss.get(Event.class, id);
		tr.commit();
		ss.close();
		return e;
	}
	
	public List<Event> GetAllData()
	{
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		CriteriaBuilder hcb = ss.getCriteriaBuilder();
		CriteriaQuery<Object> cq = hcb.createQuery();
		Root<Event> root = cq.from(Event.class);
		cq.select(root);
		
		Query query = ss.createQuery(cq);
		List<Event> list = query.getResultList();
		
		Iterator<Event> iterator = list.iterator();
		
		 while (iterator.hasNext()) {
	            Event item = iterator.next();
	            System.out.println(item);
	        }
		 return list;
	}

}
