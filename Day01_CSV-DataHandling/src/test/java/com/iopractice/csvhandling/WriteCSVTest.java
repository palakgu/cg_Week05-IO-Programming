package com.iopractice.csvhandling;

import com.opencsv.CSVWriter;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVTest {
    @Test
    public void csvWriteTest(){
        String filepath ="src//main//resources//output.csv.txt";
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(filepath));
            String[] emp1 = {"104","Palak","23","88"};
            String[] emp2 = {"105", "Samarth","22", "78"};
            writer.writeNext(emp1);
            writer.writeNext(emp2);
            System.out.println(" CSV file Written Succesfully ");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
