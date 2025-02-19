package com.practice.csvhandling;

import java.io.*;
import java.util.*;

public class MergeTwoCSVFiles {
    public static void main(String[] args) {
        String students1Path = "src/main/resources/student1.csv";
        String students2Path = "src/main/resources/student2.csv";
        String outputPath = "src/main/resources/merged_students.csv";

        System.out.println(mergeCSVFiles(students1Path, students2Path, outputPath));
    }

    public static String mergeCSVFiles(String students1Path, String students2Path, String outputPath) {
        StringBuilder sb=new StringBuilder();
        Map<String, String[]> students1Data = new HashMap<>();
        Map<String, String[]> students2Data = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(students1Path))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] columns = line.split(",");
                students1Data.put(columns[0], columns);
            }
        } catch (IOException e) {
            System.out.println("Error reading students1.csv: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(students2Path))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] columns = line.split(",");
                students2Data.put(columns[0], columns);
            }
        } catch (IOException e) {
            System.out.println("Error reading students2.csv: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write("ID,Name,Age,Marks,Grade\n");
            sb.append("ID,Name,Age,Marks,Grade\n");

            for (String id : students1Data.keySet()) {
                String[] student1 = students1Data.get(id);
                String[] student2 = students2Data.get(id);

                if (student2 != null) {
                    writer.write(student1[0] + "," + student1[1] + "," + student1[2] + "," + student2[1] + "," + student2[2] + "\n");
                    sb.append(student1[0] + "," + student1[1] + "," + student1[2] + "," + student2[1] + "," + student2[2] + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing to merged_students.csv: " + e.getMessage());
        }
        return sb.toString();
    }
}