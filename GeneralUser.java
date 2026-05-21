package oopProject;

import java.util.ArrayList;

public class GeneralUser extends User {
	private double weight;
	private double height;
	private String bloodPressure;
	private int heartRate;
	private Diet diet;
	private Sleep sleep;
	private Exercise exercise;
	private Mood mood;
	private ArrayList<Course> enrolledCourses = new ArrayList<>();

	public GeneralUser(String email, String password, String name, int age, String phoneNumber) {
		super(email, password, name, age, phoneNumber);
	}
	
	public void setGUInfo(double weight, double height, String bloodPressure, int heartRate) {
		this.weight = weight;
		this.height = height;
		this.bloodPressure = bloodPressure;
		this.heartRate = heartRate;

	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public int getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
	
	public Diet getDiet() {
		return diet;
	}

	public void setDiet(Diet diet) {
		this.diet = diet;
	}

	public Sleep getSleep() {
		return sleep;
	}

	public void setSleep(Sleep sleep) {
		this.sleep = sleep;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public Mood getMood() {
		return mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}

	public boolean enrollInCourse(Course course) {
		if (course == null) return false;


		boolean courseSide = course.enroll(this);
		if (!courseSide) return false;


		if (!enrolledCourses.contains(course)) {
			enrolledCourses.add(course);
		}
		return true;
	}

	public boolean unenrollFromCourse(Course course) {
		if (course == null) return false;

		boolean courseSide = course.unenroll(this);
		boolean userSide = enrolledCourses.remove(course);
		return courseSide && userSide;
	}

	public void showMyCourses() {
		if (enrolledCourses.isEmpty()) {
			System.out.println("You haven't enrolled in any course yet.");
		} else {
			for (Course c : enrolledCourses) {
				System.out.println("- " + c.getName() + " (Tutor: " + c.getTutorName() + ")");
			}
		}
	}

	@Override
	public String toString() {
		return super.toString() + " ,Weight: " + weight + ", Height: " + height + ", Blood Pressure: " + bloodPressure
				+ ", Heart Rate: " + heartRate;
	}

}