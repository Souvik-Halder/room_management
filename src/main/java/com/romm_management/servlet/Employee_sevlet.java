package com.romm_management.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.room_management.dao.EmployeeDao;
import com.room_management.entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Employee_sevlet extends HttpServlet {
	
	private SessionFactory factory;
	
	public void init() {
		factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int emp_id=Integer.parseInt(request.getParameter("emp_id"));
		String emp_name=request.getParameter("emp_name");
		String address=request.getParameter("address");
		String phone_no=request.getParameter("phone_no");
		String designation=request.getParameter("designation");
		int salary=Integer.parseInt(request.getParameter("salary"));
		  String dateString = request.getParameter("jdate");
		  System.out.println(dateString);
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Date Jdate=null;
	try {
		 Jdate=formatter.parse(dateString);
		 System.out.println(Jdate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	Employee emp=new Employee(emp_id, emp_name, address, emp_id, Jdate, salary, designation);
	System.out.println(emp);
	EmployeeDao empdaoobj=new EmployeeDao(factory);
	boolean check=empdaoobj.saveEmployee(emp);
	PrintWriter out = response.getWriter();
	if(check) out.println("Data saved successfully");
	
	}

}
