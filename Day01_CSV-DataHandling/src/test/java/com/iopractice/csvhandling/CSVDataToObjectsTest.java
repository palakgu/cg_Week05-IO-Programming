package com.iopractice.csvhandling;

import com.practice.csvhandling.convertcsvdatatoobjects.ConvertCSVToObjects;
import com.practice.csvhandling.convertcsvdatatoobjects.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
class CSVDataToObjectsTest {
    private String testFilePath;

    @BeforeEach
    public void setup() {
        testFilePath = "src/main/resources/employees.csv";
    }

    @Test
    public void testConvertCSVToEmployees() {
        List<Employee> employees = ConvertCSVToObjects.convertCSVToEmployees(testFilePath);

        assertNotNull(employees);
        assertFalse(employees.isEmpty());
        assertEquals(5, employees.size());

        Employee firstEmployee = employees.get(0);
        assertEquals("1", firstEmployee.getId());
        assertEquals("John Doe", firstEmployee.getName());
        assertEquals("Engineering", firstEmployee.getDepartment());
        assertEquals("85000", firstEmployee.getSalary());

        Employee lastEmployee = employees.get(3);
        assertEquals("4", lastEmployee.getId());
        assertEquals("Alice Brown", lastEmployee.getName());
        assertEquals("68000", lastEmployee.getSalary());

    }

}
