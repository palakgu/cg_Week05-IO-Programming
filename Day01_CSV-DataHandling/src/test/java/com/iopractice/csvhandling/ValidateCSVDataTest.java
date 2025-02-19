package com.iopractice.csvhandling;

import com.practice.csvhandling.ValidateCSVData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateCSVDataTest {
    @Test
    void validateData(){
        String ans= "Invalid Phone Number: +1-234-567-8901 in row: 1,John Doe,Engineering,85000,john.doe@gmail.com,+1-234-567-8901\n" +
                "Invalid Phone Number: +1-234-567-8902 in row: 2,Jane Smith,Marketing,75000,jane.smith@gmail.com,+1-234-567-8902\n" +
                "Invalid Phone Number: +1-234-567-8903 in row: 3,Bob Johnson,Sales,70000,bob.johnson@gmail.com,+1-234-567-8903\n" +
                "Invalid Phone Number: +1-234-567-8904 in row: 4,Alice Brown,HR,68000,alice.brown@gmail.com,+1-234-567-8904\n" +
                "Invalid Phone Number: +1-234-567-8905 in row: 5,Michael Davis,Finance,90000,michael.davis@gmail.com,+1-234-567-8905";

        String inPath = "src\\main\\resources\\employees.csv";
        assertEquals(ValidateCSVData.validateCSVData(inPath),ans);
    }

}