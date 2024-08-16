package com.room_management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="room_info")
public class Room {
	@Id
	private int room_no;
	private boolean status;
	@ManyToOne
	@JoinColumn(name="room_cat_id")
	private Room_category roomcat;
	public Room(int room_no, boolean status,Room_category roomcat) {
		super();
		this.room_no = room_no;
		this.status = status;
		this.roomcat=roomcat;
	}
	public Room() {
		super();
	}
	public Room_category getRoomcat() {
		return roomcat;
	}
	public void setRoomcat(Room_category roomcat) {
		this.roomcat = roomcat;
	}
	public int getRoom_no() {
		return room_no;
	}
	@Override
	public String toString() {
		return "Room [room_no=" + room_no + ", status=" + status + "]"+roomcat+"]";
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
