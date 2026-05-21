package oopProject;
import java.util.*;

public abstract class AccountManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<User> users = Program.users;
		int choice;

		System.out.println("=== Welcome to Our App! ===");

		while(true) {
			System.out.println("\nSelect an option:\n1] Log in\n2] Sign up for a new account\n3] Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				String email = null;
				System.out.print("Enter your Email: ");
				try {
				email = sc.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("Invalid email format! Try again: ");
					email = sc.nextLine();
				}

				System.out.print("Enter your Password: ");
				String password = null;
				try {
					password = sc.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.print("Password too short! Try again: ");
					password = sc.nextLine();
				}
				
				User loggedIn = null;

				for (User u : users) {
					if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
						loggedIn = u;
						break;
					}
				}
				if (loggedIn == null) {
					System.out.println("Invalid email or password!");
				} else {
					System.out.println("Login successful!");
					Program.currentUser = loggedIn;
					Program.start();  
				}
				break;


			case 2:
				String email2 = null;
				System.out.print("Enter your Email: ");
				try {
				email2 = sc.nextLine();
				}
				catch (InputMismatchException e) {
					System.out.println("Invalid email format! Try again: ");
					email2 = sc.nextLine();
				}

				System.out.print("Enter your Password: ");
				String password2 = null;
				try {
					password2 = sc.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.print("Password too short! Try again: ");
					password2 = sc.nextLine();
				}

				System.out.print("What should we call you?: ");
				String name;
				try {
					name = sc.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.print("Invalid input! Try again: ");
					name = sc.nextLine();
				}


				System.out.print("How old are you?: ");
				int age;
				try {
					age = sc.nextInt();
					sc.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.print("Invalid age! Try again: ");
					age = sc.nextInt();
					sc.nextLine();
				}

				String phone;
				boolean hasLetter;
				do {
		            System.out.print("Enter your phone number: ");
		            phone = sc.nextLine();
		            hasLetter = false;

		            for (int i = 0; i < phone.length(); i++) {
		                char c = phone.charAt(i);
		                if (Character.isAlphabetic(c)) {
		                    hasLetter = true;
		                    break;
		                }
		            }

		            if (hasLetter) {
		                System.out.println("Phone number cannot contain alphabetic characters! Try again.");
		            }

		        } while (hasLetter);
				

				System.out.println("Would you like to:\n1] Track health\n2] Become a tutor");
				int choice2 = sc.nextInt();
				sc.nextLine();

				switch(choice2) {
				case 1:
					User gu1 = new GeneralUser(email2, password2, name, age, phone);
					users.add(gu1);

					System.out.print("Enter your weight in Kgs: ");
					double weight = sc.nextDouble();
					sc.nextLine();
					while(weight < 0 || weight > 500) {
						System.out.print("Invalid weight! Try again: ");
						weight = sc.nextInt();
						sc.nextLine();
					}

					System.out.print("Enter your height in meters: ");
					double height = sc.nextDouble();
					sc.nextLine();
					while(height < 0 || height > 3) {
						System.out.print("Invalid height! Try again: ");
						weight = sc.nextInt();
						sc.nextLine();
					}
					
					String bp;
					do {
			            System.out.print("Enter your blood pressure: ");
			            bp = sc.nextLine();
			            hasLetter = false;

			            for (int i = 0; i < bp.length(); i++) {
			                char c = bp.charAt(i);
			                if (Character.isAlphabetic(c)) {
			                    hasLetter = true;
			                    break;
			                }
			            }

			            if (hasLetter) {
			                System.out.println("Blood pressure should be written in the format (AB/XY)! Try again.");
			            }

			        } while (hasLetter);

					System.out.println("Enter your heart rate: ");
					int hr = sc.nextInt();
					sc.nextLine();
					while(hr < 0 || hr > 600) {
						System.out.print("Invalid heart rate! Try again: ");
						hr = sc.nextInt();
						sc.nextLine();
					}
					System.out.println("Account Created Successfully!");

					GeneralUser gu = (GeneralUser)users.get(users.size()-1);
					gu.setGUInfo(weight, height, bp, hr);

					break;

				case 2:
					Tutor t1 = new Tutor(email2, password2, name, age, phone);
					users.add(t1);
					TutorFile.writeTutorToFile("tutors.txt", t1);


					System.out.print("How many years of experience have you got?: ");
					int years = sc.nextInt();
					sc.nextLine();
					while(years < 0 || years > 100) {
						System.out.print("Invalid number of years! Try again: ");
						years = sc.nextInt();
						sc.nextLine();
					}

					System.out.print("How many courses do you teach?: ");
					int n = sc.nextInt();
					sc.nextLine();
					while(n < 0 || n > 100) {
						System.out.print("Invalid number! Try again: ");
						n = sc.nextInt();
						sc.nextLine();
					}

					ArrayList<Course> courses = new ArrayList<>();

					System.out.print("What are their titles?: ");
					for(int j = 0; j < n; j ++) {
						String title = sc.nextLine();
						Course c = new Course(title);
						courses.add(c);
					}

					Tutor t = (Tutor)users.get(users.size()-1);
					t.setTInfo(years, courses);

					break;

				default:
					System.out.println("Invalid choice!");
				}
				break;

			case 3:
				System.out.println("Exiting... Goodbye!");
				return;

			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}