package com.ioprogramming.jsonfilehandling;

import org.json.JSONArray;
import org.json.JSONObject;

public class Create_JsonObject {
    public static void main(String[] args) {
        JSONArray subject = new JSONArray();
        subject.put("Java");
        subject.put("Chemistry");
        subject.put("English");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name","Palak");
        jsonObject.put("Age", "23");
        jsonObject.put("Subject",subject);
        System.out.println(jsonObject.toString(4));

    }
}
