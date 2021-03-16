package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* @author Alex Ryberg - alexr151
* CIS175 - Spring 2021
* Mar 11, 2021
*/

@Entity
@Table(name="USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private int UserId;
	@Column(name="FIRST_NAME")
	private String fName;
	@Column(name="LAST_NAME")
	private String lName;
	@Column(name="AGE")
	private String age;
	
	
	public User() {
		super();
	}
	
	public User(String fName) {
		super();
		this.fName = fName;
	}
	
	public User(String fName, String lName) {
		super();
		
		this.fName = fName;
		this.lName = lName;
	}
	
	public User(String fName, String lName, String age) {
		super();
		
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}
	
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
