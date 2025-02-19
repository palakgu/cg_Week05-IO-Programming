package com.iopractice.csvhandling;

import com.practice.csvhandling.ModifyCSVFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifyCSVFileTest {
    @Test
    void modifyFile(){
        String inPath = "src\\main\\resources\\employees.csv";
        String outPath = "src\\main\\resources\\output.csv";
        String ans="";

        assertEquals(ModifyCSVFile.modifyCSVFile(inPath,outPath),ans);

    }

}