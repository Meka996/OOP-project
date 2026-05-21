package oopProject;

import java.awt.*;
import javax.swing.*;

public class TutorDashboard extends JFrame {
	private Tutor tutor;
	
	public TutorDashboard() {
		tutor = (Tutor) Program.currentUser;
		
		setTitle("Tutor Dashboard - " + tutor.getName());
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		// Header
		JPanel header = new JPanel();
		header.setBackground(new Color(70, 130, 180));
		header.setPreferredSize(new Dimension(500, 80));
		JLabel title = new JLabel("Tutor Panel - " + tutor.getName());
		title.setFont(new Font("Arial", Font.BOLD, 24));
		title.setForeground(Color.WHITE);
		header.add(title);
		add(header, BorderLayout.NORTH);
		
		// Buttons
		JPanel center = new JPanel(new GridBagLayout());
		center.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 15, 15, 15);
		gbc.gridx = 0;
		
		JButton btn1 = new JButton("Add Course");
		btn1.setPreferredSize(new Dimension(300, 50));
		btn1.setBackground(new Color(100, 180, 100));
		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("Arial", Font.BOLD, 14));
		btn1.addActionListener(e -> addCourse());
		gbc.gridy = 0;
		center.add(btn1, gbc);
		
		JButton btn2 = new JButton("Remove Course");
		btn2.setPreferredSize(new Dimension(300, 50));
		btn2.setBackground(new Color(200, 100, 100));
		btn2.setForeground(Color.WHITE);
		btn2.setFont(new Font("Arial", Font.BOLD, 14));
		btn2.addActionListener(e -> removeCourse());
		gbc.gridy = 1;
		center.add(btn2, gbc);
		
		JButton btn3 = new JButton("Rename Course");
		btn3.setPreferredSize(new Dimension(300, 50));
		btn3.setBackground(new Color(100, 150, 200));
		btn3.setForeground(Color.WHITE);
		btn3.setFont(new Font("Arial", Font.BOLD, 14));
		btn3.addActionListener(e -> renameCourse());
		gbc.gridy = 2;
		center.add(btn3, gbc);
		
		JButton btn4 = new JButton("View All Courses");
		btn4.setPreferredSize(new Dimension(300, 50));
		btn4.setBackground(new Color(150, 120, 200));
		btn4.setForeground(Color.WHITE);
		btn4.setFont(new Font("Arial", Font.BOLD, 14));
		btn4.addActionListener(e -> viewCourses());
		gbc.gridy = 3;
		center.add(btn4, gbc);
		
		add(center, BorderLayout.CENTER);
		
		// Footer
		JPanel footer = new JPanel();
		footer.setBackground(new Color(240, 240, 240));
		footer.setPreferredSize(new Dimension(500, 60));
		JButton logout = new JButton("Logout");
		logout.setFont(new Font("Arial", Font.BOLD, 14));
		logout.setBackground(new Color(220, 80, 80));
		logout.setForeground(Color.WHITE);
		logout.setPreferredSize(new Dimension(120, 35));
		logout.addActionListener(e -> {
			Program.currentUser = null;
			dispose();
			new LoginFrame();
		});
		footer.add(logout);
		add(footer, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	//course methods------------------------------------------
	private void addCourse() {
		String name = JOptionPane.showInputDialog(this, "Enter course name:");
		if (name != null && !name.trim().isEmpty()) {
			tutor.addCourse(name.trim());
			JOptionPane.showMessageDialog(this, "Course added: " + name);
		}
	}
	
	private void removeCourse() {
		if (Program.courses.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No courses available.");
			return;
		}
		String name = JOptionPane.showInputDialog(this, "Enter course name to remove:");
		if (name != null) {
			tutor.removeCourse(name.trim());
		}
	}
	
	private void renameCourse() {
		if (Program.courses.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No courses available.");
			return;
		}
		String oldName = JOptionPane.showInputDialog(this, "Enter current course name:");
		if (oldName != null) {
			String newName = JOptionPane.showInputDialog(this, "Enter new course name:");
			if (newName != null) {
				tutor.renameCourse(oldName.trim(), newName.trim());
			}
		}
	}
	
	private void viewCourses() {
		if (Program.courses.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No courses available.");
			return;
		}
		// course list
		StringBuilder sb = new StringBuilder("All Courses:\n\n");
		for (int i = 0; i < Program.courses.size(); i++) {
			Course c = Program.courses.get(i);
			sb.append((i + 1)).append(". ").append(c.getName()).append("\n");
		}
		//  scrollable
		JTextArea area = new JTextArea(sb.toString());
		area.setEditable(false);
		JScrollPane scroll = new JScrollPane(area);
		scroll.setPreferredSize(new Dimension(400, 300));
		JOptionPane.showMessageDialog(this, scroll, "Course List", JOptionPane.INFORMATION_MESSAGE);
	}
}