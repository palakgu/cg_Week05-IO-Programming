package com.iopractice.csvhandling;

import com.practice.csvhandling.JsonCsvConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

class JsonCsvConverterTest {

    String jsonFile = "src/main/resources/sample1.json";
    String csvFile = "src/main/resources/employees.csv";
    String outputJsonFile = "src/main/resources/output.json";

    @Test
    void testJsonToCsvConversion() {
        JsonCsvConverter.convertJsonToCsv(jsonFile, csvFile);
        File csvOutput = new File(csvFile);
        assertTrue(csvOutput.exists());
    }

    @Test
    void testCsvToJsonConversion() {
        JsonCsvConverter.convertCsvToJson(csvFile, outputJsonFile);
        File jsonOutput = new File(outputJsonFile);
        assertTrue(jsonOutput.exists());
    }
}