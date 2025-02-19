package com.practice.csvhandling.convertcsvdatatoobjects;

import java.io.*;
import java.util.*;

public class ConvertCSVToObjects {
    public static void main(String[] args) {
        String inPath = "src\\main\\resources\\employees.csv";
        List<Employee> employees = convertCSVToEmployees(inPath);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    public static List<Employee> convertCSVToEmployees(String inPath) {
        List<Employee> employeeList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] col = line.split(",");


                Employee employee = new Employee(col[0], col[1], col[2], col[3], col[4], col[5]);
                employeeList.add(employee);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return employeeList;
    }
}