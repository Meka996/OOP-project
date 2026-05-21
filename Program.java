package oopProject;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Program {

	public static ArrayList<User> users;

    static {
        users = new ArrayList<>();

        users.addAll(FileUtil.loadUsers("users.txt"));

        users.addAll(TutorFile.loadTutors("tutors.txt"));
    }
	public static User currentUser = null;
	public static ArrayList<Course> courses = new ArrayList<>();
	

	public static void start() {
		Scanner sc = new Scanner(System.in);
		User current = Program.currentUser;
		
		if (current == null) {
			System.out.println("No user is logged in!");
			return;
		}

		System.out.println("\n=== Welcome Back " + current.getName() + "! ===");

		if (current instanceof GeneralUser gu) {
			System.out.println("\nYou can now track your health!");

			while (true) {
				System.out.println("\nWhat would you like to do?");
				System.out.println("1) Log Diet");
				System.out.println("2) Log Exercise");
				System.out.println("3) Log Sleep");
				System.out.println("4) Log Mood");
				System.out.println("5) Courses: View all");
				System.out.println("6) Courses: Enroll");
				System.out.println("7) Courses: Unenroll");
				System.out.println("8) Courses: My courses");
				System.out.println("9) Logout");

				System.out.print("Choose: ");
				int ch = sc.nextInt();
				sc.nextLine();

				switch (ch) {
				case 1: System.out.println("\n=== DIET LOGGING ===");
				System.out.println("\nDo you want to BULK or CUT?");
				System.out.println("1) Bulking");
				System.out.println("2) Cutting");                        
				int dtGoal = sc.nextInt();
				sc.nextLine();
				while(dtGoal != 1 && dtGoal != 2) {
					System.out.print("Invalid choice! Please enter 1 or 2: ");
					dtGoal = sc.nextInt();
					sc.nextLine();
				}

				System.out.println("\nSelect your training level:");
				System.out.println("1) Beginner");
				System.out.println("2) Intermediate");
				System.out.println("3) Advanced");
				int dtIntensity = sc.nextInt();
				sc.nextLine();
				while(dtIntensity != 1 && dtIntensity != 2 && dtIntensity != 3) {
					System.out.print("Invalid choice! Please enter 1, 2 or 3: ");
					dtIntensity = sc.nextInt();
					sc.nextLine();
				}

				System.out.print("Enter your daily water intake (liters): ");
				double waterIntake = sc.nextDouble();
				sc.nextLine();
				while(waterIntake < 0) {
					System.out.print("Invalid input! Try again: ");
					waterIntake = sc.nextDouble();
					sc.nextLine();
				}

				Diet d = new Diet(gu,waterIntake,dtGoal,dtIntensity);
				gu.setDiet(d);
				System.out.println(d.waterInfo());
				
				d.showDietOptions(dtGoal, dtIntensity);
				System.out.print("Choose menu number: ");
				int menu = sc.nextInt();
				sc.nextLine();
				d.setMenuChoice(menu);

				System.out.println("\nYou chose ");
				d.setMenuChoice(menu);
				d.showDietMenu(dtGoal, dtIntensity, menu);

				break;
				
				case 2: System.out.println("\\n=== EXERCISE LOGGING ===");

				System.out.println("\n1) Fat-loss\n2) Muscle-gain?");
				int exType = sc.nextInt();
				sc.nextLine();
				while(exType != 1 && exType != 2) {
					System.out.print("Invalid choice! Please enter 1 or 2: ");
					exType = sc.nextInt();
					sc.nextLine();
				}
				
				System.out.println("\nSelect intensity level:\n1) Beginner\n2) Intermediate\n3) Advanced");
				int exIntensity = sc.nextInt();
				sc.nextLine();
				while(exIntensity != 1 && exIntensity != 2 && exIntensity != 3) {
					System.out.print("Invalid choice! Please enter 1, 2 or 3: ");
					exIntensity = sc.nextInt();
					sc.nextLine();
				}
				Exercise ex = new Exercise(exType, exIntensity);
				gu.setExercise(ex);

				System.out.println("\nYour exercise plan:");
				ex.showTrainingPlan();
				break;
				
				case 3: System.out.println("\\n=== SLEEP LOGGING ===");
					System.out.print("When do you sleep?: ");
					int sleepTime= sc.nextInt();
					sc.nextLine();
					while(sleepTime < 0 || sleepTime > 24) {
						System.out.print("Invalid sleep time! Please enter a nummber between 0 and 24: ");
						sleepTime= sc.nextInt();
						sc.nextLine();
					}
					System.out.print("When do you wake up?: ");
					int wakeTime= sc.nextInt();
					sc.nextLine();
					while(wakeTime < 0 || wakeTime > 24) {
						System.out.print("Invalid wake-up time! Please enter a nummber between 0 and 24: ");
						wakeTime= sc.nextInt();
						sc.nextLine();
					}
					
					Sleep s = new Sleep(sleepTime, wakeTime);
					double duration = s.sleepDuration();
					s.checkSleep(duration);
					gu.setSleep(s);
					break;
					
				case 4: System.out.println("\\n=== MOOD LOGGING ===");
					System.out.println("On a scale from 1 - 10,");
					System.out.print("How stressed did you feel today?: ");
					int stressLvl = sc.nextInt();
					while(stressLvl < 0 || stressLvl > 10) {
						System.out.print("Invalid input! Please enter a number from 1 - 10: ");
						stressLvl = sc.nextInt();
					}
					System.out.print("How motivated were you feeling?: ");
					int motivationLvl = sc.nextInt();
					while(motivationLvl < 0 || motivationLvl > 10) {
						System.out.print("Invalid input! Please enter a number from 1 - 10: ");
						motivationLvl = sc.nextInt();
					}
					System.out.print("How energetic have you felt?: ");
					int energyLvl = sc.nextInt();
					while(energyLvl < 0 || energyLvl > 10) {
						System.out.print("Invalid input! Please enter a number from 1 - 10: ");
						energyLvl = sc.nextInt();
					}
					sc.nextLine();
					
					Mood m = new Mood(stressLvl, motivationLvl, energyLvl);
					gu.setMood(m);
					break;

				case 5: {  
					System.out.println("\n=== All Courses ===");
					if (Program.courses.isEmpty()) {
						System.out.println("No courses available.");
					} else {
						for (int idx = 0; idx < Program.courses.size(); idx++) {
							Course c = Program.courses.get(idx);
							System.out.println((idx + 1) + ") " + c.getName() +
									" | Tutor: " + c.getTutorName() +
									" | Attendees: " + c.getAttendees());
						}
					}
					break;
				}

				case 6: { 
					if (Program.courses.isEmpty()) {
						System.out.println("No courses to enroll in.");
						break;
					}
					System.out.print("Enter course number to enroll: ");
					int num = sc.nextInt();
					sc.nextLine();
					int idx = num - 1;
					if (idx < 0 || idx >= Program.courses.size()) {
						System.out.println("Invalid number!");
						break;
					}
					Course target = Program.courses.get(idx);
					boolean ok = gu.enrollInCourse(target);
					System.out.println(ok ? "Enrolled successfully!"
							: "You are already enrolled or an error occurred.");
					break;
				}

				case 7: { 
					if (Program.courses.isEmpty()) {
						System.out.println("No courses available.");
						break;
					}
					System.out.print("Enter course number to unenroll: ");
					int num = sc.nextInt();
					sc.nextLine();
					int idx = num - 1;
					if (idx < 0 || idx >= Program.courses.size()) {
						System.out.println("Invalid number!");
						break;
					}
					Course target = Program.courses.get(idx);
					boolean ok = gu.unenrollFromCourse(target);
					System.out.println(ok ? "Unenrolled successfully!"
							: "You are not enrolled in this course or an error occurred.");
					break;
				}

				case 8: { 
					System.out.println("\n=== My Courses ===");
					gu.showMyCourses();
					break;
				}

				case 9: { 
					System.out.println("Logging out...");
					return;
				}

				default : System.out.println("Invalid choice!");
				}
			}
		}

		else  if (current instanceof Tutor t) {
			System.out.println("\nYou can now manage your tutor courses!");

			while (true) {
				System.out.println("\n1) Add Course");
				System.out.println("2) Remove Course");
				System.out.println("3) Rename Course");
				System.out.println("4) View Courses");
				System.out.println("5) Logout");

				System.out.print("Choose: ");
				int ch = sc.nextInt();
				sc.nextLine();

				switch (ch) {
				case 1:
					System.out.print("Enter course name: ");
					String name = sc.nextLine();
					t.addCourse(name);
					break;

				case 2:
					System.out.print("Enter course name to remove: ");
					String remove = sc.nextLine();
					t.removeCourse(remove);
					break;

				case 3:
					System.out.print("Old course name: ");
					String oldName = sc.nextLine();
					System.out.print("New course name: ");
					String newName = sc.nextLine();
					t.renameCourse(oldName, newName);
					break;

				case 4:
					System.out.println("\nCourses:");
					for (Course c : Program.courses) {
						System.out.println("- " + c.getName());
					}
					break;

				case 5:
					System.out.println("Logging out...");
					return;

				default:
					System.out.println("Invalid choice!");
				}
			}
		}
	}
}