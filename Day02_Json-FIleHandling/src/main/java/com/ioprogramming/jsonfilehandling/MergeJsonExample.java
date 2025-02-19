package com.ioprogramming.jsonfilehandling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeJsonExample {

    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the first JSON file
            JsonNode jsonNode1 = objectMapper.readTree(new File("src/main/resources/user1.json"));

            // Read the second JSON file
            JsonNode jsonNode2 = objectMapper.readTree(new File("src/main/resources/user2.json"));

            // Merge the two JSON nodes
            JsonNode mergedJsonNode = jsonNode1.deepCopy();
            mergedJsonNode = ((ObjectNode) mergedJsonNode).setAll((ObjectNode) jsonNode2);

            // Output the merged JSON object
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJsonNode));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
