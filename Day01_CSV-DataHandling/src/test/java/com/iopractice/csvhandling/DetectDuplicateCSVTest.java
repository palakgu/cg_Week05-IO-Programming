package com.iopractice.csvhandling;

import com.practice.csvhandling.DetectDuplicateCSV;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectDuplicateCSVTest {
    @Test
    void detectDup(){
        String filePath = "src/main/resources/largefile.csv";

        int duplicate=0;
        assertEquals(DetectDuplicateCSV.detectDuplicates(filePath).size(),duplicate);
    }

    @Test
    void notFound(){
        String filePath = "src/main/resources/employees.csv";
        assertEquals(DetectDuplicateCSV.detectDuplicates(filePath).size(),0);

    }

}