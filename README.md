Health & Fitness Tracking System

A Java-based desktop application developed using Object-Oriented Programming principles and Java Swing GUI.
The system allows users to track their health activities, manage diets, monitor sleep and mood, enroll in courses, and interact with fitness tutors.

The project demonstrates the implementation of core OOP concepts such as inheritance, abstraction, polymorphism, encapsulation, and interfaces.

Features:

Authentication System
User login and signup
Validation for email, password, age, and phone number
Separate roles for:
General Users
Tutors
Session-based current user handling
General User Features
Log daily diet plans
Track water intake
View customized meal plans
Log exercise routines
Track sleep duration
Analyze mood and receive motivational tips
Enroll and unenroll in courses
View enrolled courses
Tutor Features
Add new courses
Remove courses
Rename existing courses
View all available courses
Manage attendees
Health Tracking Features
Diet tracking with bulking/cutting plans
Exercise plans based on intensity level
Sleep duration analysis
Mood analysis and random wellness tips
Personalized recommendations
GUI Features
Java Swing graphical interface
Dashboard for General Users
Dashboard for Tutors
Login and Signup panels
Interactive buttons and forms
Technologies Used
Java
Java Swing
Object-Oriented Programming (OOP)
File Handling
Collections Framework (ArrayList)
Exception Handling
OOP Concepts Used
Encapsulation

Implemented using private attributes with getters and setters in classes such as:

User
GeneralUser
Tutor
Course
Inheritance
GeneralUser extends User
Tutor extends User
Abstraction
User is an abstract class
Program and AccountManagement use abstraction for shared logic
Polymorphism
Method overriding with toString()
Shared interface implementations
Interface
Trackable interface implemented by:
Diet
Exercise
Sleep
Mood
Project Structure
Core Classes
Program
App
User
GeneralUser
Tutor
Course
GUI Classes
LoginFrame
DashboardFrame
TutorDashboard
Health Tracking Classes
Diet
Exercise
Sleep
Mood
File Handling Classes
FileUtil
TutorFile
Utility / Management Classes
AccountManagement
Trackable
System Functionalities
Diet System
Water intake analysis
Bulking and cutting meal plans
Beginner, intermediate, and advanced levels
Exercise System
Muscle gain plans
Fat loss plans
Training intensity levels
Sleep System
Sleep duration calculation
Sleep quality recommendations
Mood System
Stress analysis
Motivation tracking
Energy level tracking
Random wellness tips generation
Data Storage

The project uses text file storage for:

Users
Tutors

Using:

users.txt
tutors.txt
Future Improvements
Database integration
Password encryption
Online tutor sessions
Progress charts and analytics
Mobile application version
Nutrition calculator
AI-generated fitness recommendations

Authors:
Mohamed Adel Owais
