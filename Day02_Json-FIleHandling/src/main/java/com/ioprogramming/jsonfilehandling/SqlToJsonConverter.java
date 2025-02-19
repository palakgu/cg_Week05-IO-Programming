package com.ioprogramming.jsonfilehandling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlToJsonConverter {

    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode arrayNode = objectMapper.createArrayNode();

            // Read SQL file
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/file1.sql"));
            String line;
            Pattern pattern = Pattern.compile("\\((\\d+),\\s*'([^']+)',\\s*(\\d+),\\s*'([^']+)'\\)");

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    ObjectNode userNode = objectMapper.createObjectNode();
                    userNode.put("id", Integer.parseInt(matcher.group(1)));
                    userNode.put("name", matcher.group(2));
                    userNode.put("age", Integer.parseInt(matcher.group(3)));
                    userNode.put("email", matcher.group(4));
                    arrayNode.add(userNode);
                }
            }
            reader.close();

            // Convert the JSON array to a string and write it to a file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/report.json"), arrayNode);

            System.out.println("JSON report generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
