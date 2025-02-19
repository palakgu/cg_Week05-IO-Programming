package com.iopractice.csvhandling;

import static org.junit.jupiter.api.Assertions.*;

import com.practice.csvhandling.GenerateEmployeeCSV;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class GenerateEmployeeCSVTest {

    @Test
    void testCSVFileCreation() {
        // Call the main method to generate the CSV file
        GenerateEmployeeCSV.main(null);

        // Verify the CSV file exists and is not empty
        try (BufferedReader br = new BufferedReader(new FileReader("employee_report.csv"))) {
            String header = br.readLine();
            assertNotNull(header, "Header should not be null");

            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            assertEquals(5, lines.size(), "There should be 5 employee records");
        } catch (IOException e) {
            fail("Exception occurred while reading the CSV file: " + e.getMessage());
        }
    }

    @Test
    void testCSVContent() {
        // Call the main method to generate the CSV file
        GenerateEmployeeCSV.main(null);

        // Verify the content of the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader("employee_report.csv"))) {
            // Read the header
            String header = br.readLine();
            assertNotNull(header, "Header should not be null");
            assertEquals("Employee ID,Name,Department,Salary,", header, "Header should match the expected value");

            // Read the employee records
            String firstRecord = br.readLine();
            assertNotNull(firstRecord, "First record should not be null");
            assertEquals("1,John Doe,Engineering,85000.0,", firstRecord, "First record should match the expected value");

            String secondRecord = br.readLine();
            assertNotNull(secondRecord, "Second record should not be null");
            assertEquals("2,Jane Smith,Marketing,75000.0,", secondRecord, "Second record should match the expected value");
        } catch (IOException e) {
            fail("Exception occurred while reading the CSV file: " + e.getMessage());
        }
    }
}
