package com.practice.csvhandling;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filepath ="src\\main\\resources\\output.csv";
        try {CSVWriter writer = new CSVWriter(new FileWriter(filepath));
            String[] emp1 = {"104","Palak","23","99"};
            String[] emp2 = {"105", "Samarth","22", "78"};
            writer.writeNext(emp1);
            writer.writeNext(emp2);
            writer.close();
            System.out.println(" CSV file Written Succesfully ");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
