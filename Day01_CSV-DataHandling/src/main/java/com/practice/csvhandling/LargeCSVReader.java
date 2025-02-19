package com.practice.csvhandling;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;


public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "src/main/resources/largefile.csv";
        processCSVInChunks(filePath, 100);
    }

    public static void processCSVInChunks(String filePath, int chunkSize) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            int count = 0;
            int batchCount = 0;

            while ((line = reader.readNext()) != null) {
                count++;

                System.out.println(String.join(", ", line));

                if (count % chunkSize == 0) {
                    batchCount++;
                    System.out.println("\nProcessed " + (batchCount * chunkSize) + " records so far...\n");
                }
            }

            System.out.println("Total Records Processed: " + count);

        } catch (IOException | CsvValidationException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}