package oopProject;

import java.util.ArrayList;

public abstract class User {
	private String userID;
	private String name;
	private int age;
	private String phoneNumber;
	private String email;
	private String password;
	private static int userCount = 0;


	public User(String email, String password, String name, int age, String phoneNumber) {
		userCount ++;
		this.userID = "" + userCount;
		this.email = email;
		this.password = password;
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserID() {
		return userID;
	}

	@Override
	public String toString() {
	    return "User ID: " + userID + ", Name: " + name + ", Age: " + age + ", Phone: " + phoneNumber + ", Email: " + email;
	}
	public String toFileString() {
	    return email + "," + password + "," + name + "," + age + "," + phoneNumber;
	}
}