package com.room_management.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.room_management.entity.Employee;

public class EmployeeDao {
	private SessionFactory factory;
	public EmployeeDao(SessionFactory factory) {
		this.factory=factory;
	}
	public boolean saveEmployee(Employee emp) {
		boolean f=false;
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		int i=(int)session.save(emp);
		if(i>0) {
			f=true;
		}
		t.commit();
		session.close();
		return f;
	}
}
