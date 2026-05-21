package oopProject;

import java.util.Random;

public class Mood implements Trackable {
	
	private int stressLevel;
	private int motivationLevel;
	private int energyLevel;
	private int choice;
	
	Random rand = new Random();
	
	private String[] stressTips = {"Practice deep breathing", "Break tasks into small steps", "Take a short walk", "Limit information overload", "Use a quick grounding exercise"};
	private String[] motivationTips = {"Begin tiny to overcome inertia", "Visualize the outcome, not the task", "Reward yourself after finishing a milestone", "Work in short bursts", "Remind yourself why the task matters"};
	private String[] energyTips = {"Drink a glass of water", "Stand up and stretch", "Eat a quick energy-steadying snack", "Get brief sunlight exposure", "Do 10–20 seconds of fast movement"};
	
	public Mood(int stressLevel, int motviationLevel, int energyLevel) {
		this.stressLevel = stressLevel;
		this.motivationLevel = motviationLevel;
		this.energyLevel = energyLevel;
		
		printTip();
	}
	
	public void printTip() {
		if(stressLevel > 5) {
			choice = rand.nextInt(stressTips.length);
			System.out.println("Stress Tip: " + stressTips[choice]);
		}
		
		if(motivationLevel < 5) {
			choice = rand.nextInt(motivationTips.length);
			System.out.println("Motivation Tip: " + motivationTips[choice]);
		}
		
		if(energyLevel < 5) {
			choice = rand.nextInt(energyTips.length);
			System.out.println("Energy Tip: " + energyTips[choice]);
		}
		
	}
	
	public int getStressLevel() {
		return stressLevel;
	}
	
	public void setStressLevel(int stressLevel) {
		this.stressLevel = stressLevel;
	}
	
	public int getMotviationLevel() {
		return motivationLevel;
	}
	
	public void setMotviationLevel(int motviationLevel) {
		this.motivationLevel = motviationLevel;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	@Override
	public String toString() {
		return "Stress Level: " + stressLevel + ", Motivation Level:" + motivationLevel + ", Energy Level: "
				+ energyLevel;
	}

	@Override
	public String getSummary() {
		return toString();
	}
	
}