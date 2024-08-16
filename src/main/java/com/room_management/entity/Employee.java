package com.room_management.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="hotel_employee_details")
public class Employee {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int emp_id;
	private String emp_name;
	private String emp_address;
	public Employee(int emp_id, String emp_name, String emp_address, int phn_no, Date jdate, int salary,
			String designation) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_address = emp_address;
		this.phn_no = phn_no;
		Jdate = jdate;
		this.salary = salary;
		this.designation = designation;
	}
	private int phn_no;
	public int getPhn_no() {
		return phn_no;
	}
	public void setPhn_no(int phn_no) {
		this.phn_no = phn_no;
	}
	@Temporal(TemporalType.DATE)
	private Date Jdate;
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_address=" + emp_address + ", phn_no="
				+ phn_no + ", Jdate=" + Jdate + ", salary=" + salary + ", designation=" + designation + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public Date getJdate() {
		return Jdate;
	}
	public void setJdate(Date jdate) {
		Jdate = jdate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	private int salary;
	private String designation;
}
