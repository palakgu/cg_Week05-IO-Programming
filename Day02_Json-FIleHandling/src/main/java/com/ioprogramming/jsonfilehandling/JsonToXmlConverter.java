package com.ioprogramming.jsonfilehandling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {

    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance for JSON
            ObjectMapper jsonMapper = new ObjectMapper();

            // Read JSON file
            JsonNode jsonNode = jsonMapper.readTree(new File("src/main/resources/person.json"));

            // Create XmlMapper instance for XML
            XmlMapper xmlMapper = new XmlMapper();

            // Convert JSON to XML
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

            // Output the XML
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
