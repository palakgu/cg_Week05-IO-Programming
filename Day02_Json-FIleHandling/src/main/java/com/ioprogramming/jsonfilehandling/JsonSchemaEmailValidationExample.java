package com.ioprogramming.jsonfilehandling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class JsonSchemaEmailValidationExample {

    public static void main(String[] args) {
        try {
            // Load JSON schema
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(new File("src/main/resources/schema1.json").toURI().toString());

            // Load JSON file
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(new File("src/main/resources/read.json"));

            // Validate JSON against schema
            ProcessingReport report = schema.validate(jsonNode);

            // Output validation result
            if (report.isSuccess()) {
                System.out.println("JSON is valid.");
            } else {
                System.out.println("JSON is invalid. Issues:");
                report.forEach(processingMessage -> System.out.println(processingMessage));
            }
        } catch (IOException | ProcessingException e) {
            e.printStackTrace();
        }
    }
}
