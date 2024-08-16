
package com.room_management.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="room_Category_details")
public class Room_category {
	public Room_category() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Room_category [cat_id=" + cat_id + ", cat_name=" + cat_name + ", price=" + price
				+ "]";
	}
	public Room_category(int cat_id, String cat_name, int price, List<Room> rooms) {
		super();
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.price = price;
		this.rooms = rooms;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	@Id
	@Column(name="category_id")
	private int cat_id;
	@Column(name="category_name")
	private String cat_name;
	@Column(name="price")
	private int price;
	@OneToMany(mappedBy = "roomcat",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	
	private List<Room> rooms;
	
	
}
