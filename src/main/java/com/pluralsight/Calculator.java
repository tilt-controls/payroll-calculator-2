package com.pluralsight;
import java.util.*;
import java.io.*;
import java.util.regex.Pattern;


public class Calculator {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("employees.csv"));
            String line = bufferedReader.readLine();
            System.out.println(line);

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                String employeeID = tokens[0];
                String name = tokens[1];
                Double hoursWorked = Double.parseDouble(tokens[2]);
                Double payRate = Double.parseDouble(tokens[3]);
                Employee employeeData = new Employee(employeeID, name, hoursWorked, payRate);
                System.out.printf("%s|%s|%.2f|%.2f\n", employeeID, name, hoursWorked, payRate);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
