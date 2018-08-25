package com.integrations.maksekeskus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RestBodyHelper {

    public static String fileToString(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }

}
