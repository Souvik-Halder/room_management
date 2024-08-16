package com.room_management.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.room_management.entity.Room;

public class RoomDao {
	private SessionFactory factory;
	
	public RoomDao(SessionFactory factory) {
		this.factory=factory;
	}
	
	public boolean saveRoom(Room room) {
		boolean f=false;
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		System.out.println(room+"bhjk");
		int i=0;
		if(i>0) {
			f=true;
		}
		t.commit();
		session.close();
		return f;
	}
}
