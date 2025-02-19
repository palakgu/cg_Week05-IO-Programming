package com.practice.csvhandling;

import java.util.*;
import java.io.*;

public class SortCSVRecords {
    public static void main(String[] args) {
        String inPath = "src\\main\\resources\\employees.csv";
        System.out.println(sortCSVFile(inPath));
    }

    public static String sortCSVFile(String inPath) {
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer,List<String>>map=new TreeMap<>(Comparator.reverseOrder());
        try (BufferedReader reader = new BufferedReader(new FileReader(inPath))) {
            String line;
            int first=0;
            while ((line = reader.readLine()) != null) {
                if (first==0){
                    first=1;
                    continue;
                }
                String col[] = line.split(",");
                Integer salary = Integer.parseInt(col[3]);
                map.computeIfAbsent(salary,k -> new ArrayList<>()).add(line);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        int count = 0;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            for (String record : entry.getValue()) {
                if (count == 5) break;
                sb.append(record).append("\n");
                count++;
            }
            if (count == 5) break;
        }
        return sb.toString();
    }
}