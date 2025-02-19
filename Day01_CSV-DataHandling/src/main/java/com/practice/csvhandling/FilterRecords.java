package com.practice.csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;

public class FilterRecords {
    public static void main(String[] args) {
        String filepath = "src/main/resources/input.csv";
        System.out.println(filterRecord(filepath));
    }
    public static String filterRecord(String filepath){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            while((line= br.readLine())!=null){
                String[] columns = line.split(",");
                if(Integer.parseInt(columns[3])>80){
                    sb.append("ID-" + columns[0] + "  Name-" + columns[1] + "  Age-" + columns[2] + "  Marks-" + columns[3] + "\n");
                }
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return sb.toString().trim();
    }
}
