package com.practice.csvhandling;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndPrintCSV {
    public static void main(String[] args) {
        String filepath = "src\\main\\resources\\csvfile.csv";
        System.out.println(readcsvFile(filepath));

    }
    public static  String readcsvFile(String filepath){
        StringBuilder sb=new StringBuilder();

        try(BufferedReader reader=new BufferedReader(new FileReader(filepath))) {

            String line;
            while ((line=reader.readLine())!=null){
                String[] columns = line.split(",");
                sb.append("ID-"+columns[0]+"  Name-"+columns[1]+"  Age-"+columns[2]+"  Marks-"+columns[3]+"\n");

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
