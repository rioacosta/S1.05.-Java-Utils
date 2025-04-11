package ex1ex2;

import java.io.File;
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


    public static void DirectoryTree(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            throw new IllegalArgumentException("El directorio no existe: " + directoryPath);
        }
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("La ruta proporcionada no es un directorio: " + directoryPath);
        }
        System.out.println("Árbol del directorio para: " + directory.getAbsolutePath());
        listDirectory(directory, 0);
    }


    public static void listDirectory(File directory, int level) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        Arrays.sort(files);

        for (File file : files) {
            String indent = "    ".repeat(level); // Indentación para simular el nivel
            String type = file.isDirectory() ? "D" : "F";
            String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified());

            System.out.println(indent + "[" + type + "] " + file.getName() + " (Última modificación: " + lastModified + ")");

            if (file.isDirectory()) {
                listDirectory(file, level + 1); // Llamada recursiva para subdirectorios
            }
        }
    }
    private static boolean isValidFile(String path){
        Path filePath = Paths.get(path);
        return Files.exists(filePath);
    }
}