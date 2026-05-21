package oopProject;

import java.io.*;
import java.util.ArrayList;

public class TutorFile {

    public static void writeTutorToFile(String fileName, Tutor tutor) {
        try (FileWriter fw = new FileWriter(fileName, true)) {

            String line =
                    tutor.getEmail() + "," +
                    tutor.getPassword() + "," +
                    tutor.getName() + "," +
                    tutor.getAge() + "," +
                    tutor.getPhoneNumber() + "," +
                    tutor.getYearsOfExperience();

            fw.write(line + System.lineSeparator());

        } catch (IOException e) {
            System.out.println("Error saving tutor.");
        }
    }

    public static ArrayList<Tutor> loadTutors(String fileName) {

        ArrayList<Tutor> tutors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String email = data[0];
                String password = data[1];
                String name = data[2];
                int age = Integer.parseInt(data[3]);
                String phoneNumber = data[4];
                int years = Integer.parseInt(data[5]);

                Tutor tutor = new Tutor(email, password, name, age, phoneNumber);
                tutor.setYearsOfExperience(years);

                tutors.add(tutor);
            }

        } catch (IOException e) {
            System.out.println("No saved tutors found.");
        }

        return tutors;
    }
}