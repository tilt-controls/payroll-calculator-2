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
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writingFile));
            bufferedWriter.write("ID|NAME|GROSS PAY\n");
            String line = bufferedReader.readLine();


            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                String employeeID = tokens[0];
                String name = tokens[1];
                Double hoursWorked = Double.parseDouble(tokens[2]);
                Double payRate = Double.parseDouble(tokens[3]);
                Employee employee1 = new Employee(employeeID, name, hoursWorked, payRate);
                String text = employee1.toCSV();

                bufferedWriter.write(text);

            }
            System.out.println("\nFile complete!");
            bufferedWriter.close();
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
