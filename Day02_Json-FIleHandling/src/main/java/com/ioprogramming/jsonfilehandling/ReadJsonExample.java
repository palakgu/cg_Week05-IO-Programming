package com.ioprogramming.jsonfilehandling;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonExample {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/example1.json"));

            // Iterate over the JSON nodes
            printJsonNodes(rootNode, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printJsonNodes(JsonNode node, String parentKey) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                String fieldName = field.getKey();
                JsonNode fieldValue = field.getValue();
                printJsonNodes(fieldValue, parentKey.isEmpty() ? fieldName : parentKey + "." + fieldName);
            }
        } else if (node.isArray()) {
            int index = 0;
            for (JsonNode arrayItem : node) {
                printJsonNodes(arrayItem, parentKey + "[" + index + "]");
                index++;
            }
        } else {
            System.out.println(parentKey + ": " + node.asText());
        }
    }
}