package com.practice.csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountCSV {public static void main(String[] args) {
    String filepath = "src\\main\\resources\\input.csv";
    System.out.println(" Line in the file : "+readcsvFile(filepath));

}
    public static  int readcsvFile(String filepath){
        int count =0;
        try(BufferedReader reader=new BufferedReader(new FileReader(filepath))) {


            String line;
            while ((line=reader.readLine())!=null){
                count++;

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
