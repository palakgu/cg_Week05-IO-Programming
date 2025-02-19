package com.iopractice.csvhandling;

import com.practice.csvhandling.MergeTwoCSVFiles;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoCSVFilesTest {

    String students1Path = "src/main/resources/student1.csv";
    String students2Path = "src/main/resources/student2.csv";
    String outputPath = "src/main/resources/merged_students.csv";

    @Test
    void testMergeCSVFiles() throws IOException {
        MergeTwoCSVFiles.mergeCSVFiles(students1Path, students2Path, outputPath);

        List<String> expectedOutput = Arrays.asList(
                "ID,Name,Age,Marks,Grade",
                        "1,Arjun Sharma,Mathematics,Ravi Verma,Mathematics" ,
                        "2,Priya Mehta,Physics,Anjali Singh,Physics" ,
                        "3,Rahul Kumar,Chemistry,Amit Kumar,Chemistry" ,
                        "4,Ananya Singh,Biology,Neha Sharma,Biology" ,
                        "5,Kavya Patel,Computer Science,Manish Patel,Computer Science"
        );
        List<String> actualOutput = Files.readAllLines(Paths.get(outputPath));

        assertEquals(expectedOutput, actualOutput);
    }
}