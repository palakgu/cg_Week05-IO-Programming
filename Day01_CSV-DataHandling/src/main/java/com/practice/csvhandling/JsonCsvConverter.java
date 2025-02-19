package com.practice.csvhandling;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.*;

public class JsonCsvConverter {
    public static void convertJsonToCsv(String jsonFilePath, String csvFilePath) {
        try (Reader reader = new FileReader(jsonFilePath);
             CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {

            JsonArray students = JsonParser.parseReader(reader).getAsJsonArray();
            List<String[]> data = new ArrayList<>();

            data.add(new String[]{"ID", "Name", "Age", "Marks"});

            for (var element : students) {
                JsonObject obj = element.getAsJsonObject();
                data.add(new String[] {
                        obj.get("ID").getAsString(),
                        obj.get("Name").getAsString(),
                        obj.get("Age").getAsString(),
                        obj.get("Marks").getAsString()
                });
            }

            writer.writeAll(data);
            System.out.println("JSON to CSV conversion completed!");

        } catch (IOException e) {
            System.err.println("Error reading the JSON file or writing to the CSV file: " + e.getMessage());
        }
    }

    public static void convertCsvToJson(String csvFilePath, String jsonFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath));
             FileWriter writer = new FileWriter(jsonFilePath)) {

            List<String[]> records;
            try {
                records = reader.readAll();
            } catch (com.opencsv.exceptions.CsvException e) {
                System.err.println("Error reading the CSV file: " + e.getMessage());
                return;
            }

            JsonArray studentsArray = new JsonArray();

            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                JsonObject student = new JsonObject();
                student.addProperty("ID", row[0]);
                student.addProperty("Name", row[1]);
                student.addProperty("Age", row[2]);
                student.addProperty("Marks", row[3]);
                studentsArray.add(student);
            }

            writer.write(new Gson().toJson(studentsArray));
            System.out.println("CSV to JSON conversion completed!");

        } catch (IOException e) {
            System.err.println("Error reading the CSV file or writing to the JSON file: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        String jsonFilePath = "src/main/resources/sample1.json";
        String csvFilePath = "src/main/resources/employees.csv";
        String outputJsonFile = "src/main/resources/output.json";

        convertJsonToCsv(jsonFilePath, csvFilePath);
        convertCsvToJson(csvFilePath, outputJsonFile);
    }
}