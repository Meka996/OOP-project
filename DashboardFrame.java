package oopProject;

import java.awt.*;
import javax.swing.*;

public class DashboardFrame extends JFrame {
	private GeneralUser gu;
	
	// ========================================
	// SEGMENT 1: CONSTRUCTOR - Initialize Dashboard
	// ========================================
	public DashboardFrame() {
		gu = (GeneralUser) Program.currentUser;
		setupFrame();
		createHeader();
		createMainContent();
		createFooter();
		setVisible(true);
	}
	
	private void setupFrame() {
		setTitle("Dashboard - " + gu.getName());
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
	}
	
	// ========================================
	// SEGMENT 2: UI LAYOUT - Header, Content, Footer
	// ========================================
	private void createHeader() {
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(70, 130, 180));
		headerPanel.setPreferredSize(new Dimension(600, 80));
		
		JLabel welcomeLabel = new JLabel("Welcome, " + gu.getName() + "!");
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 26));
		welcomeLabel.setForeground(Color.WHITE);
		headerPanel.add(welcomeLabel);
		
		add(headerPanel, BorderLayout.NORTH);
	}
	
	private void createMainContent() {
		JPanel centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(new Color(240, 240, 240));
		addGeneralUserButtons(centerPanel);
		add(centerPanel, BorderLayout.CENTER);
	}
	
	private void createFooter() {
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(240, 240, 240));
		bottomPanel.setPreferredSize(new Dimension(600, 60));
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font("Arial", Font.BOLD, 14));
		logoutButton.setBackground(new Color(220, 80, 80));
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setPreferredSize(new Dimension(120, 35));
		logoutButton.addActionListener(e -> handleLogout());
		
		bottomPanel.add(logoutButton);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	
	// ========================================
	// SEGMENT 3: BUTTON CREATION - For General Users
	// ========================================
	private void addGeneralUserButtons(JPanel panel) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		// Title
		gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
		panel.add(new JLabel("Health Tracking & Courses", SwingConstants.CENTER), gbc);
		gbc.gridwidth = 1;
		
		// Health Buttons (Row 1-2)
		gbc.gridy = 1;
		gbc.gridx = 0; panel.add(makeButton("Log Diet", new Color(100, 180, 100), e -> logDiet()), gbc);
		gbc.gridx = 1; panel.add(makeButton("Log Exercise", new Color(100, 150, 200), e -> logExercise()), gbc);
		
		gbc.gridy = 2;
		gbc.gridx = 0; panel.add(makeButton("Log Sleep", new Color(150, 120, 200), e -> logSleep()), gbc);
		gbc.gridx = 1; panel.add(makeButton("Log Mood", new Color(230, 150, 100), e -> logMood()), gbc);
		
		// Course Buttons (Row 3-4)
		gbc.gridy = 3;
		gbc.gridx = 0; panel.add(makeButton("View All Courses", new Color(70, 130, 180), e -> viewAllCourses()), gbc);
		gbc.gridx = 1; panel.add(makeButton("My Courses", new Color(180, 130, 70), e -> viewMyCourses()), gbc);
		
		gbc.gridy = 4;
		gbc.gridx = 0; panel.add(makeButton("Enroll Course", new Color(100, 180, 150), e -> enrollInCourse()), gbc);
		gbc.gridx = 1; panel.add(makeButton("Unenroll Course", new Color(200, 100, 100), e -> unenrollFromCourse()), gbc);
	}
	
	private JButton makeButton(String text, Color color, java.awt.event.ActionListener action) {
		JButton btn = new JButton(text);
		btn.setFont(new Font("Arial", Font.BOLD, 13));
		btn.setBackground(color);
		btn.setForeground(Color.WHITE);
		btn.setPreferredSize(new Dimension(220, 50));
		btn.addActionListener(action);
		return btn;
	}
	
	// ========================================
	// SEGMENT 5: GENERAL USER FEATURES - Diet (USES Diet CLASS)
	// ========================================
	private void logDiet() {
		String[] goals = {"Bulking", "Cutting"};
		String[] levels = {"Beginner", "Intermediate", "Advanced"};
		
		int goal = JOptionPane.showOptionDialog(this, "Select your goal:", "Diet Goal",
			JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, goals, goals[0]) + 1;
		if (goal == 0) return;
		
		int intensity = JOptionPane.showOptionDialog(this, "Select intensity:", "Diet Intensity",
			JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, levels, levels[0]) + 1;
		if (intensity == 0) return;
		
		String waterStr = JOptionPane.showInputDialog(this, "Daily water intake (liters):");
		if (waterStr == null) return;
		double water = Double.parseDouble(waterStr);
		
		// Create Diet object - it handles all the logic
		Diet diet = new Diet(gu, water, goal, intensity);
		gu.setDiet(diet);
		
		// Use Diet class method to get water info
		showOutput("Water Hydration Info", diet.waterInfo());
		
		// Use Diet class method to show all menus
		StringBuilder allMenus = new StringBuilder();
		for (int i = 1; i <= 4; i++) {
			allMenus.append("════════ MENU ").append(i).append(" ════════\n");
			// Capture the menu output from Diet class
			java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
			java.io.PrintStream ps = new java.io.PrintStream(baos);
			java.io.PrintStream old = System.out;
			System.setOut(ps);
			diet.showDietMenu(goal, intensity, i);
			System.out.flush();
			System.setOut(old);
			allMenus.append(baos.toString()).append("\n");
		}
		showOutput("All Diet Menus - Choose One", allMenus.toString());
		
		String[] menuOptions = {"Menu 1", "Menu 2", "Menu 3", "Menu 4"};
		int choice = JOptionPane.showOptionDialog(this, "Select your menu:", "Choose Menu",
			JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuOptions, menuOptions[0]) + 1;
		
		if (choice > 0) {
			diet.setMenuChoice(choice);
			JOptionPane.showMessageDialog(this, "Menu " + choice + " saved successfully!");
		}
	}
	
	// ========================================
	// SEGMENT 6: GENERAL USER FEATURES - Exercise (USES Exercise CLASS)
	// ========================================
	private void logExercise() {
		String[] types = {"Muscle Gain", "Fat Loss"};
		String[] levels = {"Beginner", "Intermediate", "Advanced"};
		
		int type = JOptionPane.showOptionDialog(this, "Exercise type:", "Exercise Type",
			JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, types, types[0]) + 1;
		if (type == 0) return;
		
		int intensity = JOptionPane.showOptionDialog(this, "Intensity level:", "Exercise Intensity",
			JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, levels, levels[0]) + 1;
		if (intensity == 0) return;
		
		// Create Exercise object - it handles the logic
		Exercise ex = new Exercise(type, intensity);
		gu.setExercise(ex);
		
		// Capture output from Exercise class showTrainingPlan() method
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		java.io.PrintStream ps = new java.io.PrintStream(baos);
		java.io.PrintStream old = System.out;
		System.setOut(ps);
		ex.showTrainingPlan();
		System.out.flush();
		System.setOut(old);
		
		showOutput("Your Exercise Plan", baos.toString());
	}
	
	// ========================================
	// SEGMENT 7: GENERAL USER FEATURES - Sleep (USES Sleep CLASS)
	// ========================================
	private void logSleep() {
		String sleepStr = JOptionPane.showInputDialog(this, "Sleep time (0-24):");
		if (sleepStr == null) return;
		String wakeStr = JOptionPane.showInputDialog(this, "Wake time (0-24):");
		if (wakeStr == null) return;
		
		int sleepTime = Integer.parseInt(sleepStr);
		int wakeTime = Integer.parseInt(wakeStr);
		
		// Create Sleep object
		Sleep sleep = new Sleep(sleepTime, wakeTime);
		gu.setSleep(sleep);
		
		double duration = sleep.sleepDuration();
		
		// Use Sleep class checkSleep method
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		java.io.PrintStream ps = new java.io.PrintStream(baos);
		java.io.PrintStream old = System.out;
		System.setOut(ps);
		sleep.checkSleep(duration);
		System.out.flush();
		System.setOut(old);
		
		String output = "Sleep Summary\n\n" +
			"Sleep Time: " + sleepTime + ":00\n" +
			"Wake Time: " + wakeTime + ":00\n" +
			"Duration: " + String.format("%.1f", duration) + " hours\n\n" +
			baos.toString();
		
		showOutput("Sleep Analysis", output);
	}
	
	// ========================================
	// SEGMENT 8: GENERAL USER FEATURES - Mood (USES Mood CLASS)
	// ========================================
	private void logMood() {
		String stressStr = JOptionPane.showInputDialog(this, "Stress level (1-10):");
		if (stressStr == null) return;
		String motivStr = JOptionPane.showInputDialog(this, "Motivation level (1-10):");
		if (motivStr == null) return;
		String energyStr = JOptionPane.showInputDialog(this, "Energy level (1-10):");
		if (energyStr == null) return;
		
		int stress = Integer.parseInt(stressStr);
		int motiv = Integer.parseInt(motivStr);
		int energy = Integer.parseInt(energyStr);
		
		// Create Mood object - it prints tips automatically in constructor
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		java.io.PrintStream ps = new java.io.PrintStream(baos);
		java.io.PrintStream old = System.out;
		System.setOut(ps);
		
		Mood mood = new Mood(stress, motiv, energy);
		gu.setMood(mood);
		
		System.out.flush();
		System.setOut(old);
		
		StringBuilder output = new StringBuilder("Your Mood Summary\n\n");
		output.append("Stress: ").append(stress).append("/10\n");
		output.append("Motivation: ").append(motiv).append("/10\n");
		output.append("Energy: ").append(energy).append("/10\n\n");
		output.append("━━━━━━━━━━━━━━━━━━━━━━\n\n");
		
		// Add tips from Mood class
		String tips = baos.toString();
		if (!tips.isEmpty()) {
			output.append(tips);
		} else {
			output.append("🌟 Great! You're doing well today!");
		}
		
		showOutput("Mood Analysis & Tips", output.toString());
	}
	
	// ========================================
	// SEGMENT 9: COURSE FEATURES (WITH OUTPUT)
	// ========================================
	private void viewAllCourses() {
		if (Program.courses.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No courses available.");
			return;
		}
		
		StringBuilder sb = new StringBuilder("All Available Courses\n\n");
		for (int i = 0; i < Program.courses.size(); i++) {
			Course c = Program.courses.get(i);
			sb.append((i+1)).append(". ").append(c.getName())
			  .append("\n   Tutor: ").append(c.getTutorName())
			  .append("\n   Attendees: ").append(c.getAttendees()).append("\n\n");
		}
		showOutput("Course Catalog", sb.toString());
	}
	
	private void viewMyCourses() {
		StringBuilder sb = new StringBuilder("My Enrolled Courses\n\n");
		sb.append("Feature in development - check with your tutor!");
		showOutput("My Courses", sb.toString());
	}
	
	private void enrollInCourse() {
		if (Program.courses.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No courses available to enroll.");
			return;
		}
		
		String[] names = Program.courses.stream().map(Course::getName).toArray(String[]::new);
		String selected = (String) JOptionPane.showInputDialog(this, "Select course to enroll:", "Enroll",
			JOptionPane.QUESTION_MESSAGE, null, names, names[0]);
		
		if (selected != null) {
			for (Course c : Program.courses) {
				if (c.getName().equals(selected)) {
					boolean ok = gu.enrollInCourse(c);
					String msg = ok ? 
						"✅ Successfully enrolled in:\n" + c.getName() :
						"⚠️ Already enrolled or enrollment failed.";
					JOptionPane.showMessageDialog(this, msg);
					break;
				}
			}
		}
	}
	
	private void unenrollFromCourse() {
		if (Program.courses.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No courses available.");
			return;
		}
		
		String[] names = Program.courses.stream().map(Course::getName).toArray(String[]::new);
		String selected = (String) JOptionPane.showInputDialog(this, "Select course to unenroll:", "Unenroll",
			JOptionPane.QUESTION_MESSAGE, null, names, names[0]);
		
		if (selected != null) {
			for (Course c : Program.courses) {
				if (c.getName().equals(selected)) {
					boolean ok = gu.unenrollFromCourse(c);
					String msg = ok ? 
						"✅ Successfully unenrolled from:\n" + c.getName() :
						"⚠️ Not enrolled or unenrollment failed.";
					JOptionPane.showMessageDialog(this, msg);
					break;
				}
			}
		}
	}
	
	// ========================================
	// SEGMENT 10: HELPER METHODS
	// ========================================
	private void showOutput(String title, String content) {
		JTextArea textArea = new JTextArea(content);
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(500, 400));
		
		JOptionPane.showMessageDialog(this, scrollPane, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void handleLogout() {
		int confirm = JOptionPane.showConfirmDialog(this, "Logout?", "Confirm", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			Program.currentUser = null;
			dispose();
			new LoginFrame();
		}
	}
}