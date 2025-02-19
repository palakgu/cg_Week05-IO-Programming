package com.iopractice.csvhandling;

import com.practice.csvhandling.FilterRecords;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilterRecordsTest {
    @Test
    public void filterTest(){
        String path = "src/main/resources/input.csv";
        String res = "ID-109  Name-palak  Age-23  Marks-87";
        Assertions.assertEquals(FilterRecords.filterRecord(path),res);
    }
}
