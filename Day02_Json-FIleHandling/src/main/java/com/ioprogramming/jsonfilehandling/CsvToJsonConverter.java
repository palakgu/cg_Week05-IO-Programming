package com.ioprogramming.jsonfilehandling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {

    public static void main(String[] args) {
        try {
            // Create CsvMapper instance
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();

            // Read CSV file
            List<Object> csvData = csvMapper.readerFor(Map.class).with(csvSchema).readValues(new File("src/main/resources/csvfile.csv")).readAll();

            // Convert CSV data to JSON
            ObjectMapper jsonMapper = new ObjectMapper();
            JsonNode jsonNode = jsonMapper.valueToTree(csvData);

            // Output the JSON
            String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
