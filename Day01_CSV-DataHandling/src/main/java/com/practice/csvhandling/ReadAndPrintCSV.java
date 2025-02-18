package com.practice.csvhandling;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReadAndPrintCSV {
    public static void main(String[] args) {
        String filepath = "csvfile.txt";
        System.out.println(readcsvFile(filepath));

    }
    public static  String readcsvFile(String filepath){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));

            String line ;
            while((line=br.readLine())!=null){
                sb.append(line).append("\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
