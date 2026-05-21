package oopProject;

public class Exercise implements Trackable{

	private int exType;       
	private int exIntensity;  

	public Exercise(int exType, int exIntensity) {
		this.exType = exType;
		this.exIntensity = exIntensity;
	}

	public int getExType() {
		return exType;
	}

	public void setExType(int exType) {
		this.exType = exType;
	}

	public int getExIntensity() {
		return exIntensity;
	}

	public void setExIntensity(int exIntensity) {
		this.exIntensity = exIntensity;
	}

	public void showTrainingPlan() {

		if (exType == 1 && exIntensity == 1) {
			System.out.println("""
					    MUSCLE GAIN – BEGINNER
					    ---------------------------------
					    Day 1: Full Body
					        - Squat 3x10
					        - Bench Press 3x10
					        - Lat Pulldown 3x12

					    Day 2: Rest or Light Cardio

					    Day 3: Full Body
					        - Deadlift 3x8
					        - Shoulder Press 3x10
					        - Seated Row 3x12
					""");
		}

		else if (exType == 1 && exIntensity == 2) {
			System.out.println("""
					    MUSCLE GAIN – INTERMEDIATE
					    ---------------------------------
					    Day 1: Push
					        - Bench Press 4x8
					        - Shoulder Press 4x10
					        - Tricep dips 3x12

					    Day 2: Pull
					        - Deadlift 4x5
					        - Barbell Row 4x8
					        - Bicep curls 3x12

					    Day 3: Legs
					        - Squats 4x8
					        - Lunges 3x12
					        - Calf Raises 3x15
					""");
		}

		else if (exType == 1 && exIntensity == 3) {
			System.out.println("""
					    MUSCLE GAIN – ADVANCED
					    ---------------------------------
					    Day 1: Chest + Triceps
					        - Bench Press 5x5
					        - Incline Dumbbell Press 4x8
					        - Skull Crushers 3x12

					    Day 2: Back + Biceps
					        - Deadlift 5x5
					        - Pull-ups 4x10
					        - Barbell curls 4x8
					""");
		}

		else if (exType == 2 && exIntensity == 1) {
			System.out.println("""
					    FAT LOSS – BEGINNER
					    ---------------------------------
					    Day 1:
					        - Fast walking 30 min
					        - Light full body 2x12

					    Day 2:
					        - Cardio 20 min
					        - Abs 3x15
					""");
		}

		else if (exType == 2 && exIntensity == 2) {
			System.out.println("""
					    FAT LOSS – INTERMEDIATE
					    ---------------------------------
					    Day 1:
					        - HIIT 15 min
					        - Push workout 3x12

					    Day 2:
					        - HIIT 15 min
					        - Pull workout 3x12

					    Day 3:
					        - Light cardio 30 min + Abs
					""");
		}

		else if (exType == 2 && exIntensity == 3) {
			System.out.println("""
					    FAT LOSS – ADVANCED
					    ---------------------------------
					    Day 1:
					        - HIIT 20 min + Chest workout

					    Day 2:
					        - HIIT 20 min + Back workout

					    Day 3:
					        - Legs + Abs
					""");
		}
	}

	@Override
	public String toString() {
		return "Exercise Type: " + exType + ", Exercise Intensity: " + exIntensity;
	}

	@Override
	public String getSummary() {
		return toString();
	}
}