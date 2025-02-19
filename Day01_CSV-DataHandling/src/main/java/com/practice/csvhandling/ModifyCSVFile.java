package com.practice.csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.*;

public class ModifyCSVFile {
    public static void main(String[] args) {
        String inPath = "src\\main\\resources\\employees.csv";
        String outPath = "src\\main\\resources\\output.csv";
        System.out.println(modifyCSVFile(inPath, outPath));
    }

    public static String modifyCSVFile(String inPath, String outPath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String col[] = line.split(",");

                if (col[2].equals("IT")) {
                    int salary = Integer.parseInt(col[3]);
                    String modify = col[0] + "," + col[1] + "," + col[2] + "," + (salary + (salary / 100) * 10) + "," + col[4] + "," + col[5] + "\n";
                    sb.append(modify);
                    writer.write(modify);
                } else {
                    writer.write(line + "\n");
                    sb.append(line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }
}