package com.iopractice.csvhandling;

import com.practice.csvhandling.ReadAndCountCSV;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReadAndCountCSVTest {
    @Test
    public void readTest(){
        String filepath = "src\\main\\resources\\input.csv";
        int count =2;
        Assertions.assertEquals(ReadAndCountCSV.readcsvFile(filepath),count);
    }
}
