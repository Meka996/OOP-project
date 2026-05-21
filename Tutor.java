package oopProject;

import java.util.ArrayList;

public class Tutor extends User {
	private String tutorID;
	private int yearsOfExperience;
	private ArrayList<Course> courses;
	private static int tutorCount = 0;


	public Tutor(String email, String password, String name, int age, String phoneNumber) { 
		super(email, password, name, age, phoneNumber);
		tutorCount ++;
		this.tutorID = "" + tutorCount;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getTutorID() {
		return tutorID;
	}

	public void setTInfo(int yearsOfExperience, ArrayList<Course> courses) {
		this.yearsOfExperience = yearsOfExperience;
		this.courses = courses;
	}

	public void addCourse(String courseName) {
		Course c = new Course(courseName);
		c.setTutorName(this.getName()); 
		Program.courses.add(c);         
		System.out.print("Course Added Successfully!");
	}

	public void removeCourse(String courseName) {
		for(Course c : Program.courses) {
			if (c.getName().equalsIgnoreCase(courseName)) {
				Program.courses.remove(c);
				System.out.println("Course removed successfully!");
				return ;
			}
		}
		System.out.print("Course Not Found!");
	}

	public void renameCourse(String oldName, String newName) {

		for (Course c : Program.courses) {
			if (c.getName().equalsIgnoreCase(oldName)) {
				c.setName(newName);
				System.out.println("Course renamed successfully!");
				return;
			}
		}
		System.out.println("Course not found!");
	}

	@Override
	public String toString() {
		return super.toString() + ", Tutor ID: " + tutorID + ", Years Of Experience: " + yearsOfExperience + ", Courses: " + courses;
	}

}