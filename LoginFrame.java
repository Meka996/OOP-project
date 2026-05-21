package oopProject;
import java.awt.*;
import javax.swing.*;

public class LoginFrame extends JFrame {
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private JPanel loginPanel;
	private JPanel signupPanel;

	public LoginFrame() {
		setTitle("LOGIN DASHBOARD");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);

		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		cardPanel.setBounds(0, 0, 500, 500);

		loginPanel = createLoginPanel();
		signupPanel = createSignupPanel();

		cardPanel.add(loginPanel, "Login");
		cardPanel.add(signupPanel, "Signup");
		add(cardPanel);
		cardLayout.show(cardPanel, "Login");

		setVisible(true);
	}

	private JPanel createSignupPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 240, 240));

		JLabel titleLabel = new JLabel("CREATE NEW ACCOUNT", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		titleLabel.setBounds(0, 10, 500, 30);
		panel.add(titleLabel);
		
		// Email
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		emailLabel.setBounds(50, 60, 80, 20);
		panel.add(emailLabel);

		JTextField emailField = new JTextField();
		emailField.setBounds(150, 60, 300, 25);
		panel.add(emailField);

		// Password
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		passwordLabel.setBounds(50, 100, 80, 20);
		panel.add(passwordLabel);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(150, 100, 300, 25);
		panel.add(passwordField);

		// Name
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		nameLabel.setBounds(50, 140, 80, 20);
		panel.add(nameLabel);

		JTextField nameField = new JTextField();
		nameField.setBounds(150, 140, 300, 25);
		panel.add(nameField);

		// Age
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		ageLabel.setBounds(50, 180, 80, 20);
		panel.add(ageLabel);

		JTextField ageField = new JTextField();
		ageField.setBounds(150, 180, 300, 25);
		panel.add(ageField);

		// Phone
		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		phoneLabel.setBounds(50, 220, 80, 20);
		panel.add(phoneLabel);

		JTextField phoneField = new JTextField();
		phoneField.setBounds(150, 220, 300, 25);
		panel.add(phoneField);
		
		// User Type Selection
		JLabel typeLabel = new JLabel("I want to:");
		typeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		typeLabel.setBounds(50, 260, 400, 20);
		panel.add(typeLabel);
		
		JRadioButton generalUserRadio = new JRadioButton("Track my health (General User)");
		generalUserRadio.setBounds(150, 285, 300, 25);
		generalUserRadio.setBackground(new Color(240, 240, 240));
		generalUserRadio.setSelected(true);
		panel.add(generalUserRadio);
		
		JRadioButton tutorRadio = new JRadioButton("Become a tutor");
		tutorRadio.setBounds(150, 315, 300, 25);
		tutorRadio.setBackground(new Color(240, 240, 240));
		panel.add(tutorRadio);
		
		ButtonGroup userTypeGroup = new ButtonGroup();
		userTypeGroup.add(generalUserRadio);
		userTypeGroup.add(tutorRadio);

		// Sign Up Button
		JButton signupButton = new JButton("Sign Up");
		signupButton.setBounds(100, 370, 120, 40);
		signupButton.setBackground(new Color(100, 200, 100));
		signupButton.setForeground(Color.WHITE);
		signupButton.setFont(new Font("Arial", Font.BOLD, 14));
		signupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		signupButton.addActionListener(e -> {
			String email = emailField.getText().trim();
			String password = new String(passwordField.getPassword());
			String name = nameField.getText().trim();
			String ageStr = ageField.getText().trim();
			String phone = phoneField.getText().trim();

			// Validation from AccountManagement
			if (email.isEmpty() || password.isEmpty() || name.isEmpty() || 
					ageStr.isEmpty() || phone.isEmpty()) {
				JOptionPane.showMessageDialog(panel, 
						"All fields are required!", 
						"Input Error", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// Email validation (from AccountManagement)
			String emailRegex = "^[^@\\s]{1,8}@[a-zA-Z]{1,7}\\.com$";
			if (!email.matches(emailRegex)) {
				JOptionPane.showMessageDialog(panel, 
						"Invalid email format! Must be format: name@domain.com\n(Max 8 chars before @, max 7 chars domain)", 
						"Input Error", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// Password validation (from AccountManagement)
			if (password.length() < 10) {
				JOptionPane.showMessageDialog(panel, 
						"Password must be at least 10 characters!", 
						"Input Error", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// Name validation (from AccountManagement)
			if (name.matches(".*\\d.*")) {
				JOptionPane.showMessageDialog(panel, 
						"Name cannot contain numbers!", 
						"Input Error", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			// Age validation
			int age;
			try {
				age = Integer.parseInt(ageStr);
				if (age < 0 || age > 100) {
					JOptionPane.showMessageDialog(panel, 
							"Please enter a valid age (0-100)!", 
							"Input Error", 
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(panel, 
						"Age must be a number!", 
						"Input Error", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// Phone validation (from AccountManagement)
			boolean hasLetter = false;
			for (int i = 0; i < phone.length(); i++) {
				if (Character.isAlphabetic(phone.charAt(i))) {
					hasLetter = true;
					break;
				}
			}
			if (hasLetter) {
				JOptionPane.showMessageDialog(panel, 
						"Phone number cannot contain letters!", 
						"Input Error", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// Check if email already exists
			for (User u : Program.users) {
				if (u.getEmail().equals(email)) {
					JOptionPane.showMessageDialog(panel, 
							"Email already registered!", 
							"Registration Error", 
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			}

			// Create user based on selection
			if (tutorRadio.isSelected()) {
				// Create Tutor
				Tutor newTutor = new Tutor(email, password, name, age, phone);
				
				// Ask for tutor-specific info
				String yearsStr = JOptionPane.showInputDialog(panel, "How many years of experience?");
				if (yearsStr == null) return;
				
				try {
					int years = Integer.parseInt(yearsStr);
					if (years < 0 || years > 100) {
						JOptionPane.showMessageDialog(panel, "Invalid years!");
						return;
					}
					newTutor.setYearsOfExperience(years);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panel, "Years must be a number!");
					return;
				}
				
				Program.users.add(newTutor);
				TutorFile.writeTutorToFile("tutors.txt", newTutor);

				
				JOptionPane.showMessageDialog(panel, 
						"Tutor account created successfully!\nYou can now login.", 
						"Success", 
						JOptionPane.INFORMATION_MESSAGE);
				
			} else {
				// Create General User
				GeneralUser newUser = new GeneralUser(email, password, name, age, phone);
				
				// Ask for health info
				String weightStr = JOptionPane.showInputDialog(panel, "Enter your weight (kg):");
				if (weightStr == null) return;
				
				String heightStr = JOptionPane.showInputDialog(panel, "Enter your height (meters):");
				if (heightStr == null) return;
				
				String bp = JOptionPane.showInputDialog(panel, "Enter your blood pressure (e.g., 120/80):");
				if (bp == null) return;
				
				String hrStr = JOptionPane.showInputDialog(panel, "Enter your heart rate:");
				if (hrStr == null) return;
				
				try {
					double weight = Double.parseDouble(weightStr);
					double height = Double.parseDouble(heightStr);
					int hr = Integer.parseInt(hrStr);
					
					if (weight < 0 || weight > 500) {
						JOptionPane.showMessageDialog(panel, "Invalid weight!");
						return;
					}
					if (height < 0 || height > 3) {
						JOptionPane.showMessageDialog(panel, "Invalid height!");
						return;
					}
					if (hr < 0 || hr > 600) {
						JOptionPane.showMessageDialog(panel, "Invalid heart rate!");
						return;
					}
					
					// Validate blood pressure format
					boolean bpHasLetter = false;
					for (int i = 0; i < bp.length(); i++) {
						if (Character.isAlphabetic(bp.charAt(i))) {
							bpHasLetter = true;
							break;
						}
					}
					if (bpHasLetter) {
						JOptionPane.showMessageDialog(panel, "Blood pressure should be in format: 120/80");
						return;
					}
					
					newUser.setGUInfo(weight, height, bp, hr);
					Program.users.add(newUser);

					FileUtil.writeToFile("users.txt",email + "," +password + "," +name + "," +age + "," +phone);
					

					JOptionPane.showMessageDialog(panel, "Account created successfully!\nYou can now login.", "Success", 
					JOptionPane.INFORMATION_MESSAGE);

					
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panel, "Please enter valid numbers!");
					return;
				}
			}

			// Clear fields and go to login
			emailField.setText("");
			passwordField.setText("");
			nameField.setText("");
			ageField.setText("");
			phoneField.setText("");
			generalUserRadio.setSelected(true);
			cardLayout.show(cardPanel, "Login");
		});
		panel.add(signupButton);

		// Back to Login Button
		JButton backButton = new JButton("Back to Login");
		backButton.setBounds(270, 370, 170, 40);
		backButton.setBackground(new Color(200, 100, 100));
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Arial", Font.BOLD, 14));
		backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		backButton.addActionListener(e -> {
			emailField.setText("");
			passwordField.setText("");
			nameField.setText("");
			ageField.setText("");
			phoneField.setText("");
			generalUserRadio.setSelected(true);
			cardLayout.show(cardPanel, "Login");
		});
		panel.add(backButton);

		return panel;
	}

	private JPanel createLoginPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 240, 240));

		JLabel titleLabel = new JLabel("LOGIN DASHBOARD", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		titleLabel.setBounds(0, 20, 500, 40);
		panel.add(titleLabel);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		emailLabel.setBounds(80, 100, 80, 25);
		panel.add(emailLabel);

		JTextField emailField = new JTextField();
		emailField.setBounds(170, 100, 250, 30);
		emailField.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(emailField);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		passwordLabel.setBounds(80, 150, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(170, 150, 250, 30);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(passwordField);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(120, 220, 100, 40);
		loginButton.setBackground(new Color(100, 150, 200));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("Arial", Font.BOLD, 14));
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		loginButton.addActionListener(e -> {
			String email = emailField.getText().trim();
			String password = new String(passwordField.getPassword());

			if (email.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(panel, 
						"Email and Password cannot be empty!", 
						"Input Error", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// Email validation (from AccountManagement)
			String emailRegex = "^[^@\\s]{1,8}@[a-zA-Z]{1,7}\\.com$";
			if (!email.matches(emailRegex)) {
				JOptionPane.showMessageDialog(panel, 
						"Invalid email format!", 
						"Input Error", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// Password validation (from AccountManagement)
			if (password.length() < 10) {
				JOptionPane.showMessageDialog(panel, 
						"Password too short! Must be at least 10 characters.", 
						"Input Error", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			User loggedIn = null;
			for (User u : Program.users) {
				if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
					loggedIn = u;
					break;
				}
			}

			if (loggedIn == null) {
				JOptionPane.showMessageDialog(panel, 
						"Invalid email or password!", 
						"Login Failed", 
						JOptionPane.ERROR_MESSAGE);
				passwordField.setText("");
			} else {
				JOptionPane.showMessageDialog(panel, 
						"Login successful! Welcome " + loggedIn.getName(), 
						"Success", 
						JOptionPane.INFORMATION_MESSAGE);
				Program.currentUser = loggedIn;
				
				// Open correct dashboard
				if (loggedIn instanceof GeneralUser) {
					new DashboardFrame();
				} else if (loggedIn instanceof Tutor) {
					new TutorDashboard();
				}
				
				LoginFrame.this.dispose();
			}
		});
		panel.add(loginButton);

		// Sign Up Link Button
		JButton signupLinkButton = new JButton("Sign Up");
		signupLinkButton.setBounds(270, 220, 100, 40);
		signupLinkButton.setBackground(new Color(100, 200, 100));
		signupLinkButton.setForeground(Color.WHITE);
		signupLinkButton.setFont(new Font("Arial", Font.BOLD, 14));
		signupLinkButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		signupLinkButton.addActionListener(e -> {
			emailField.setText("");
			passwordField.setText("");
			cardLayout.show(cardPanel, "Signup");
		});
		panel.add(signupLinkButton);

		return panel;
	}
}