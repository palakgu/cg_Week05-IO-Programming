package com.practice.csvhandling;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "src/main/resources/largefile.csv";
        List<String>dup=detectDuplicates(filePath);
        if (dup.isEmpty()) {
            System.out.println("No duplicate records found.");
        } else {
            System.out.println("Duplicate Records Found:");
            for (String record : dup) {
                System.out.println(record);
            }
        }
    }

    public static List<String> detectDuplicates(String filePath) {
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }


                String id = line[0];

                if (!uniqueIds.add(id)) {
                    duplicateRecords.add(String.join(", ", line));

                }
            }

        } catch (IOException | CsvValidationException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


        return duplicateRecords;
    }
}