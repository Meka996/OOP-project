package oopProject;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {

    
    public static void writeToFile(String fileName, String data) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(data + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static ArrayList<User> loadUsers(String fileName) {
        ArrayList<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String email = data[0];
                String password = data[1];
                String name = data[2];
                int age;
                try {
                    age = Integer.parseInt(data[3].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age format: " + data[3]);
                    continue;
                }

                String phone = data[4];

                User u = new GeneralUser(email, password, name, age, phone);
                users.add(u);
            }

        } catch (IOException e) {
            System.out.println("No saved users found.");
        }

        return users;
    }
}