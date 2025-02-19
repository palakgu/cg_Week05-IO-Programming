package com.iopractice.csvhandling;

import com.practice.csvhandling.SearchRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchRecordTest {
    @Test
    public void searchRecord(){
        String path = "src/main/resources/record.csv";
        String target = "Samarth Palak";
        String res = "Name-Palak Department-Engineering Salary-60000\n" +
                "Name-Samarth Department-Civil Salary-80000";
        Assertions.assertEquals(SearchRecord.searchRecord(path,target),res);
    }

}
