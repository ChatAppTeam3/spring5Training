package com.cmm.employee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table( name = "employee_attendance" , uniqueConstraints = {
		@UniqueConstraint(columnNames = "id")})
public class EmployeeAttendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int id;
	
	@ManyToOne
	@JoinColumn(name="employee_id", nullable=false)
	private Employee employee;
	
	@Column(name = "date")
	public String date;
	
	@Column(name = "day")
	public String day;
	
	@Column(name = "in_time")
	public Time in_time;
	
	@Column(name = "out_time")
	public Time out_time;
	
	@Column(name = "in_time_reason")
	public String in_time_reason;
	
	@Column(name = "out_time_reason")
	public String out_time_reason;
	
	@Column(name = "created_date")
	public Timestamp created_date;
	
	@Column(name = "updated_date")
	public Timestamp updated_date;
}
