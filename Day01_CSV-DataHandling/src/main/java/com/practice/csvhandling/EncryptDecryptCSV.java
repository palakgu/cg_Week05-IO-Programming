package com.practice.csvhandling;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {

    private static final String ALGORITHM = "AES";
    private static SecretKey secretKey;

    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
            keyGen.init(128);
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            throw new RuntimeException("Error initializing encryption key", e);
        }
    }

    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }

    public static void writeEncryptedCSV(String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            String[] header = {"ID", "Name", "Salary", "Email"};
            String[] data1 = {"1", "Abhishek", encrypt("60000"), encrypt("Abhi@example.com")};
            String[] data2 = {"2", "Muskan", encrypt("75000"), encrypt("Muskan@example.com")};

            writer.writeNext(header);
            writer.writeNext(data1);
            writer.writeNext(data2);

            System.out.println("Encrypted CSV written successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readDecryptedCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (!nextLine[0].equals("ID")) {
                    nextLine[2] = decrypt(nextLine[2]);
                    nextLine[3] = decrypt(nextLine[3]);
                }
                System.out.println(String.join(", ", nextLine));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/resources/encrypted_data.csv";
        writeEncryptedCSV(filePath);
        System.out.println("\nDecrypted CSV Output:");
        readDecryptedCSV(filePath);
    }
}