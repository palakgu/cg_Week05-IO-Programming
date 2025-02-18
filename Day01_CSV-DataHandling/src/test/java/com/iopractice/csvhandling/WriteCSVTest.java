package com.iopractice.csvhandling;

import com.opencsv.CSVWriter;
import com.practice.csvhandling.ReadAndPrintCSV;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVTest {
    @Test
    public void csvTest(){
        String filepath ="src\\main\\resources\\output.csv";
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(filepath));
            String[] emp1 = {"104","Palak","23","97"};
            String[] emp2 = {"105", "Samarth","22", "78"};
            writer.writeNext(emp1);
            writer.writeNext(emp2);
            writer.close();
            System.out.println(" CSV file Written Succesfully ");
        } catch(IOException e){
            e.printStackTrace();
        }
        String ans="ID-\"104\"  Name-\"Palak\"  Age-\"23\"  Marks-\"97\"\nID-\"105\"  Name-\"Samarth\"  Age-\"22\"  Marks-\"78\"\n";

        Assertions.assertEquals(ReadAndPrintCSV.readcsvFile("src\\main\\resources\\output.csv"),ans);
    }
}
