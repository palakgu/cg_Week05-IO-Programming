package com.practice.csvhandling;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ValidateCSVData {

    public static void main(String[] args) {
        String inPath = "src\\main\\resources\\employees.csv";
        System.out.println(validateCSVData(inPath));
    }

    public static String validateCSVData(String inPath) {
        StringBuilder sb=new StringBuilder();
        String emailRegext = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegext = "^[0-9]{10}$";

        Pattern emailPattern = Pattern.compile(emailRegext);
        Pattern phonePattern = Pattern.compile(phoneRegext);

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] col = line.split(",");

                if (!emailPattern.matcher(col[4]).matches()) {
                    sb.append("Invalid Email: " + col[4] + " in row: " + line+"\n");
                }

                if (!phonePattern.matcher(col[5]).matches()) {
                    sb.append("Invalid Phone Number: " + col[5] + " in row: " + line+"\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sb.toString().trim();
    }
}