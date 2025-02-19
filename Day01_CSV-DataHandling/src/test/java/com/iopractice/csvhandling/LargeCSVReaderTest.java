package com.iopractice.csvhandling;

import com.practice.csvhandling.LargeCSVReader;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class LargeCSVReaderTest {

    String filePath="src\\main\\resources\\output.csv";

    @BeforeEach
    void setUp() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary,Email,Phone\n");
            for (int i = 1; i < 300; i++) {
                writer.write(i + ",TestName" + i + ",IT," + (50000 + i) + ",test" + i + "@email.com,987654321" + (i % 10) + "\n");
            }
        }
    }

    @Test
    void testProcessCSVInChunks() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        LargeCSVReader.processCSVInChunks(filePath, 100);

        String output = outContent.toString();
        assertTrue(output.contains("Processed 100 records so far"));
        assertTrue(output.contains("Processed 200 records so far"));
        assertTrue(output.contains("Total Records Processed: 300"));
    }


}