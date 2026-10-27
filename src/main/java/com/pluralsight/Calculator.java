package com.pluralsight;
import java.util.*;
import java.io.*;
import java.util.regex.Pattern;


public class Calculator {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of file to process: ");
            String existingFile = scanner.nextLine();

            System.out.println("Enter name of the payroll file to create: ");
            String writingFile = scanner.nextLine();


            BufferedReader bufferedReader = new BufferedReader(new FileReader(existingFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(writingFile));
            String line = bufferedReader.readLine();

            System.out.println("ID - Name - Gross Pay");

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                String employeeID = tokens[0];
                String name = tokens[1];
                Double hoursWorked = Double.parseDouble(tokens[2]);
                Double payRate = Double.parseDouble(tokens[3]);
                Employee employee1 = new Employee(employeeID, name, hoursWorked, payRate);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
