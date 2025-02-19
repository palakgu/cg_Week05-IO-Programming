package com.iopractice.csvhandling;

import com.practice.csvhandling.SortCSVRecords;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortCSVRecordsTest {
    @Test
    void sortFile(){
        String ans="5,Michael Davis,Finance,90000,michael.davis@gmail.com,+1-234-567-8905\n"+
        "1,John Doe,Engineering,85000,john.doe@gmail.com,+1-234-567-8901\n"+
        "2,Jane Smith,Marketing,75000,jane.smith@gmail.com,+1-234-567-8902\n"+
        "3,Bob Johnson,Sales,70000,bob.johnson@gmail.com,+1-234-567-8903\n"+
        "4,Alice Brown,HR,68000,alice.brown@gmail.com,+1-234-567-8904\n";

        String inPath = "src\\main\\resources\\employees.csv";

        assertEquals(SortCSVRecords.sortCSVFile(inPath),ans);

    }

}
