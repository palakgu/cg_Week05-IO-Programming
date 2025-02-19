package com.ioprogramming.jsonfilehandling.javaobjectintojson;

class Car {
    private String brands;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brands = brand;
        this.model = model;
        this.year = year;
    }

    public  String getBrand() {
        return brands;
    }

    public  String getModel() {
        return model;
    }

    public  int getYear() {
        return year;
    }


}