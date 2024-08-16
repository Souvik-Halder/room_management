package com.romm_management.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.room_management.dao.RoomDao;
import com.room_management.dao.Room_Category_Dao;
import com.room_management.entity.Room;
import com.room_management.entity.Room_category;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Register_Room extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;

	
	public void init() {
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init();
		int room_no = Integer.parseInt(request.getParameter("room_no"));

		int room_cat_id = Integer.parseInt(request.getParameter("room_id"));

		Room_Category_Dao roomcatdao = new Room_Category_Dao();
		Room_category roomcatobj = roomcatdao.getCategoryById(room_cat_id);

		RoomDao roomdao = new RoomDao(factory);
		Room room = new Room(room_no, false, roomcatobj);
		System.out.println(room);

		roomdao.saveRoom(room);

		List<Room> rllist = new ArrayList<Room>();
		rllist.add(room);

		boolean check = roomcatdao.saveRoomListToCategory(rllist, room_cat_id);
		PrintWriter out = response.getWriter();
		if (check)
			out.println("Data saved successfully");

	}

}
