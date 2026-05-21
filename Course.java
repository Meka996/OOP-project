package oopProject;

import java.util.ArrayList;

public class Course {

	private String courseID;
	private String tutorName;
	private String name;
	private int totalDuration;
	private int attendees;
	private int numberOfSessions;
	public static ArrayList<Course> courses = new ArrayList<>();
	private ArrayList<GeneralUser> participants = new ArrayList<>();


	public Course(String name) {
		this.name = name;
	}

	public Course(String courseID, String tutorName, String name, int totalDuration, int attendees, int numberOfSessions) {
		this.courseID = courseID;
		this.tutorName = tutorName;
		this.name = name;
		this.totalDuration = totalDuration;
		this.attendees = attendees;
		this.numberOfSessions = numberOfSessions;
	}

	public String getCourseID() {
		return courseID;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(int totalDuration) {
		this.totalDuration = totalDuration;
	}

	public int getAttendees() {
		return attendees;
	}

	public int getNumberOfSessions() {
		return numberOfSessions;
	}

	public void setNumberOfSessions(int numberOfSessions) {
		this.numberOfSessions = numberOfSessions;
	}
	
	public void addAttendee() {
		attendees++;
	}

	public void addSession(int extraMinutes) {
		numberOfSessions++;
		totalDuration += extraMinutes;
	}

	public boolean enroll(GeneralUser user) {
		if (user == null) return false;
		if (participants.contains(user)) return false;  
		participants.add(user);
		attendees = participants.size();               
		return true;
	}

	public boolean unenroll(GeneralUser user) {
		if (user == null) return false;
		boolean removed = participants.remove(user);
		if (removed) {
			attendees = participants.size();
		}
		return removed;
	}

	public void printParticipants() {
		if (participants.isEmpty()) {
			System.out.println("No participants enrolled.");
		} else {
			for (int i = 0; i < participants.size(); i++) {
				System.out.println((i + 1) + ") " + participants.get(i).getName());
			}
		}
	}

	@Override
	public String toString() {
		return "Course ID: " + courseID + ", Tutor Name: " + tutorName + ", Name: " + name + ", Total Duration:"
				+ totalDuration + ", Attendees=" + attendees + ", Number of Sessions=" + numberOfSessions;
	}

}