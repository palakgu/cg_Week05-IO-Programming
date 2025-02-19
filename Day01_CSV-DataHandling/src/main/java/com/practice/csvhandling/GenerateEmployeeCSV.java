package com.practice.csvhandling;

import java.io.*;
import java.sql.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Employee {
    int employeeId;
    String name;
    String department;
    double salary;

    public Employee(int employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class GenerateEmployeeCSV {
    public static void main(String[] args) {
        // Simulating a database with a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "Engineering", 85000));
        employees.add(new Employee(2, "Jane Smith", "Marketing", 75000));
        employees.add(new Employee(3, "Bob Johnson", "Sales", 70000));
        employees.add(new Employee(4, "Alice Brown", "HR", 68000));
        employees.add(new Employee(5, "Michael Davis", "Finance", 90000));

        // Define the CSV file header
        String[] header = {"Employee ID", "Name", "Department", "Salary"};

        // Writing to the CSV file
        try (FileWriter fileWriter = new FileWriter("employee_report.csv")) {
            // Write the header
            for (String column : header) {
                fileWriter.append(column).append(",");
            }
            fileWriter.append("\n");

            // Write employee records
            for (Employee employee : employees) {
                fileWriter.append(String.valueOf(employee.employeeId)).append(",");
                fileWriter.append(employee.name).append(",");
                fileWriter.append(employee.department).append(",");
                fileWriter.append(String.valueOf(employee.salary)).append(",");
                fileWriter.append("\n");
            }

            System.out.println("employee_report.csv has been created with the employee data.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
