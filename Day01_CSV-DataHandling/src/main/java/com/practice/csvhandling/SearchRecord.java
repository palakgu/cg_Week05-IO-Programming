package com.practice.csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
    public static void main(String[] args) {
        String path = "src/main/resources/record.csv";
        String target ="Samarth Palak";
        System.out.println(searchRecord(path,target));
    }
    public static String searchRecord(String path, String Target){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
           String line ;
           while((line = br.readLine())!=null){
               String[] column = line.split(",");
               if(Target.contains(column[0])){
                   sb.append("Name-"+column[0]+" Department-"+column[1]+" Salary-"+column[2]+"\n");
               }
           }
        } catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString().trim();
    }
}
