package ex3ex4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class DirectoryTool {

    public static String[] AlphabeticListing(String directoryPath) {
        Scanner input = new Scanner(System.in);
        while (directoryPath == null || directoryPath.isBlank() || !isValidFile(directoryPath)) {
            System.out.println("Introduce el directorio path: ");
            directoryPath = input.nextLine().trim();
            directoryPath = directoryPath.replace("/", File.separator).replace("\\", File.separator);
        }
        input.close();
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            throw new IllegalArgumentException("El directorio no existe: " + directoryPath);
        }
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("La ruta proporcionada no es un directorio: " + directoryPath);
        }
        String[] files = directory.list();
        if (files == null) {
            return new String[0];
        }
        Arrays.sort(files);
        return files;
    }

    public static void AlphabeticListingToFile(String directoryPath, String outputPath) throws IOException {
        String[] files = AlphabeticListing(directoryPath);
        try (FileWriter writer = new FileWriter(outputPath)) {
            for (String file : files) {
                writer.write(file + System.lineSeparator());
            }
        }
    }

    public static void DirectoryTreeToFile(String directoryPath, String outputPath) throws IOException {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            throw new IllegalArgumentException("El directorio no existe: " + directoryPath);
        }
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("La ruta proporcionada no es un directorio: " + directoryPath);
        }

        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write("Árbol del directorio para: " + directory.getAbsolutePath() + System.lineSeparator());
            listDirectoryToFile(directory, 0, writer);
        }
    }

    private static void listDirectoryToFile(File directory, int level, FileWriter writer) throws IOException {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        Arrays.sort(files);

        for (File file : files) {
            String indent = "    ".repeat(level); // Indentación para simular el nivel
            String type = file.isDirectory() ? "D" : "F";
            String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified());

            writer.write(indent + "[" + type + "] " + file.getName() + " (Última modificación: " + lastModified + ")" + System.lineSeparator());

            if (file.isDirectory()) {
                listDirectoryToFile(file, level + 1, writer); // Llamada recursiva para subdirectorios
            }
        }
    }
    private static boolean isValidFile(String path){
        Path filePath = Paths.get(path);
        return Files.exists(filePath);
    }
}