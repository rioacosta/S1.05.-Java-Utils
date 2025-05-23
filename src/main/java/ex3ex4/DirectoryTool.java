package ex3ex4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class DirectoryTool {
    private final static Scanner INPUT = new Scanner(System.in);
    private static String directoryPath;
    private static String outputPath;

    public static String[] alphabeticListing(String directoryPath) {
        directoryPath = normalizePath(directoryPath);
        validateDirectory(directoryPath);
        File directory = new File(directoryPath);
        String[] files = directory.list();
        if (files == null) {
            return new String[0];
        }
        Arrays.sort(files);
        for (String file : files) {
            System.out.println(file);
        }
        return files;
    }

    public static void alphabeticListingToFile() throws IOException {
        System.out.println("Introduce el directorio: ");
        directoryPath = INPUT.nextLine();
        System.out.println("Introduce la ruta y nombre para guardar el fichero de salida (ejemplo: output.txt): ");
        outputPath = INPUT.nextLine();
        directoryPath = normalizePath(directoryPath);
        validateDirectory(directoryPath);
        String[] files = alphabeticListing(directoryPath);

        try (FileWriter writer = new FileWriter(outputPath)) {
            for (String file : files) {
                writer.write(file + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new IOException("Error al escribir el documento de salida", e);
        }

    }

    public static void directoryTreeToFile() throws IOException {
        System.out.println("Introduce el directorio: ");
        directoryPath = INPUT.nextLine();
        System.out.println("Introduce la ruta y nombre para guardar el archivo de salida (ejemplo: output.txt): ");
        outputPath = INPUT.nextLine();
        directoryPath = normalizePath(directoryPath);
        validateDirectory(directoryPath);
        File directory = new File(directoryPath);

        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write("Árbol del directorio para: " + directory.getAbsolutePath() + System.lineSeparator());
            listDirectoryToFile(directory, 0, writer);
        } catch (IOException e) {
            throw new IOException("Error al convertir el directorio", e);
        }
    }


    private static void listDirectoryToFile(File directory, int level, FileWriter writer) throws IOException {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        Arrays.sort(files);

        for (File file : files) {
            String indent = "    ".repeat(level);
            String type = file.isDirectory() ? "D" : "F";
            String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified());

            writer.write(indent + "[" + type + "] " + file.getName() + " (Última modificación: " + lastModified + ")" + System.lineSeparator());

            if (file.isDirectory()) {
                listDirectoryToFile(file, level + 1, writer);
            }
        }
    }

    static void readFileAndPrint() {
        System.out.println("Introduce la ruta del archivo TXT que deseas leer: ");
        String filePath = INPUT.nextLine();
        normalizePath(filePath);
        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            System.out.println("El archivo no existe o no es un archivo válido.");
            return;
        }
        try {
            System.out.println("Contenido del archivo " + filePath + ":");
            Files.lines(file.toPath(), StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
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