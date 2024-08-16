package com.room_management.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.room_management.entity.Room;
import com.room_management.entity.Room_category;

public class Room_Category_Dao {
	private SessionFactory factory;
	
	public Room_Category_Dao() {
		super();
		factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	}
	
	public boolean saveRoomListToCategory(List<Room> rlist,int id) {
		boolean f=false;
		System.out.println(id);
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
		
		Room_category room_cat=(Room_category) session.get(Room_category.class, id);
		System.out.println(room_cat);
		room_cat.setRooms(rlist);
	
		session.update(room_cat);
		f=true;
		
		
		tr.commit();
		
		session.close();
		return f;
		
	}
	
	public Room_Category_Dao(SessionFactory factory) {
		this.factory = factory;
	}
	public boolean saveRoomCategory(Room_category roomcat) {
		boolean f=false;
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		int i=(int) session.save(roomcat);
		if(i>0) {
			f=true;
		}
		t.commit();
		session.close();
		return f;
	}
	public List<Room_category> getAllCategory(){
		Session session=factory.openSession();
		List<Room_category> categories=session.createQuery("from Room_category",Room_category.class).list();
		System.out.println(categories);
		return categories;
	}
	public Room_category getCategoryById(int id) {
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
		
		Room_category room_cat=(Room_category) session.get(Room_category.class, id);
		
		
		tr.commit();
		
		session.close();
		
		return room_cat;
	}
}
