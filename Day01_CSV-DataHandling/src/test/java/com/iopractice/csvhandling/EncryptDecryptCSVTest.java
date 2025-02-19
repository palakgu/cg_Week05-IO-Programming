package com.iopractice.csvhandling;

import com.practice.csvhandling.EncryptDecryptCSV;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EncryptDecryptCSVTest {

    @Test
    public void testEncryptDecryptCSV() throws Exception {
        String filePath = "src/main/resources/encrypted_data.csv";

        EncryptDecryptCSV.writeEncryptedCSV(filePath);

        assertTrue(Files.exists(Paths.get(filePath)));

        String encryptedContent = new String(Files.readAllBytes(Paths.get(filePath)));
        assertFalse(encryptedContent.trim().isEmpty());

    }
}