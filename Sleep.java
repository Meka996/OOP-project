package oopProject;

public class Sleep implements Trackable{
	private double sleepTime;
	private double wakeTime;
	private double duration;

	public Sleep(double sleepTime, double wakeTime) {
		this.sleepTime = sleepTime;
		this.wakeTime = wakeTime;
	}

	public double getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(double sleepTime) {
		this.sleepTime = sleepTime;
	}

	public double getWakeTime() {
		return wakeTime;
	}

	public void setWakeTime(double wakeTime) {
		this.wakeTime = wakeTime;
	}

	public double sleepDuration() {
		if(wakeTime > sleepTime)
			duration = wakeTime - sleepTime;
		else
			duration = (24 - sleepTime) + wakeTime;
		return duration;
	}

	public void checkSleep(double duration) {
		if(duration >= 7)
			System.out.println("Well done getting enough sleep!");
		else
			System.out.println("Short sleep duration. Go to bed early and have some rest.");
	}

	@Override
	public String toString() {
		return "Sleep Time: " + sleepTime + ", Wake Time: " + wakeTime + ", Sleep Duration: " + sleepDuration();
	}

	@Override
	public String getSummary() {
		return toString();
	}
}