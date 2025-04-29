package ex1ex2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class DirectoryTool {
    private final static Scanner INPUT = new Scanner(System.in);
    private static String directoryPath;

    public static String[] alphabeticListing() {
        System.out.println("Introduce el directorio path: ");
        directoryPath = INPUT.nextLine();
        directoryPath = normalizePath(directoryPath);
        validateDirectory(directoryPath);
        File directory = new File(directoryPath);
        String[] files = directory.list();
        if (files == null) {
            return new String[0];
        }
        System.out.println("Listado alfabético del directorio:");
        Arrays.sort(files);
        for (String file : files) {
            System.out.println(file);
        }
        return files;
    }

    public static void directoryTree() {
        System.out.println("Introduce el directorio path: ");
        directoryPath = INPUT.nextLine();
        directoryPath = normalizePath(directoryPath);
        validateDirectory(directoryPath);
        File directory = new File(directoryPath);
        System.out.println("Árbol del directorio para: " + directory.getAbsolutePath());
        listAndTagDirectory(directory, 0);
    }


    public static void listAndTagDirectory(File directory, int level) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        Arrays.sort(files);

        for (File file : files) {
            String indent = "    ".repeat(level);
            String type = file.isDirectory() ? "D" : "F";
            String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified());

            System.out.println(indent + "[" + type + "] " + file.getName() + " (Última modificación: " + lastModified + ")");

            if (file.isDirectory()) {
                listAndTagDirectory(file, level + 1);
            }
        }
    }

    private static void validateDirectory(String directoryPath) {
        if (directoryPath == null || directoryPath.isBlank()) {
            throw new IllegalArgumentException("La ruta del directorio no puede estar vacia");
        }
    File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("La ruta proporcionada no es un directorio: " + directoryPath);
        }
        if (!directory.exists()) {
            throw new IllegalArgumentException("El directorio no existe" + directoryPath);
        }

        }
    private static String normalizePath(String path) {
        if (path == null) {
            return null;
        }
        return path.trim().replace("/", File.separator).replace("\\", File.separator);
    }
}