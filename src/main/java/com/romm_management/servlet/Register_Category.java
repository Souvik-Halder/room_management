package com.romm_management.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.room_management.dao.Room_Category_Dao;
import com.room_management.entity.Room;
import com.room_management.entity.Room_category;


public class Register_Category extends HttpServlet {
	private SessionFactory sessionfactory;
	public void init() {
		 sessionfactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		 
	}
	
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			init();
			int category_id=Integer.parseInt(request.getParameter("category_id"));
			int category_price=Integer.parseInt(request.getParameter("category_price"));
			String category_name=request.getParameter("category_name");
			
			Room_category roomcat=new Room_category(category_id, category_name, category_price, null);
			System.out.println(roomcat);
			Room_Category_Dao roomcatdao=new Room_Category_Dao(sessionfactory);
			
			boolean check=roomcatdao.saveRoomCategory(roomcat);
			PrintWriter out =response.getWriter();
			if(check) out.println("Data saved successfully");
		

	}

}
