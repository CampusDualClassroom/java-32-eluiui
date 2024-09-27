package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exercise32 {

    public static void main(String[] args) {
        String inputString = generateStringToSave(null);
        printToFile(inputString);
    }

    public static String generateStringToSave(String string) {
        if (string == null) {
            return generateUserInputToSave();
        }
        return string;
    }

    private static String generateUserInputToSave() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while (!(string = Utils.string()).isEmpty()) {
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        Path path = Paths.get("src/main/resources/data.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            writer.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
