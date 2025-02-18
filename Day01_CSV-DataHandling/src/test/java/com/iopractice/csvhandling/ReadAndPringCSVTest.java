package com.iopractice.csvhandling;

import com.practice.csvhandling.ReadAndPrintCSV;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReadAndPringCSVTest {
    @Test
    public void csvTest(){
        String filepath = "csvfile.txt";
        String res = ReadAndPrintCSV.readcsvFile(filepath);
        Assertions.assertEquals(ReadAndPrintCSV.readcsvFile(filepath),res);
    }
}
