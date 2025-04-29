package nivel2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Properties;

public class DirectoryTool {
    private static String directoryPath;
    private static String outputPath;

    public static void checkAndExecuteConfiguration() {
        try {
            Properties config = loadConfiguration();
            directoryPath = normalizePath(config.getProperty("directory.path"));
            outputPath = normalizePath(config.getProperty("output.file.path"));
            validateConfiguration(directoryPath, outputPath);
            alphabeticListingToFile();
            directoryTreeToFile();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

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
        validateDirectory(directoryPath);
        String[] files = alphabeticListing(directoryPath);

        try (FileWriter writer = new FileWriter(outputPath)) {
            System.out.println("Generando listado alfabético y guardándolo en un fichero...");
            for (String file : files) {
                writer.write(file + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new IOException("Error al escribir el documento de salida", e);
        }

    }

    public static void directoryTreeToFile() throws IOException {
        validateDirectory(directoryPath);
        File directory = new File(directoryPath);

        try (FileWriter writer = new FileWriter(outputPath)) {
            System.out.println("Generando árbol de directorios y guardándolo en un fichero...");
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

    private static void validateDirectory(String directoryPath) {
        if (directoryPath == null || directoryPath.isBlank()) {
            throw new IllegalArgumentException("La ruta del directorio no puede estar vacía");
        }
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("La ruta proporcionada no es un directorio: " + directoryPath);
        }
        if (!directory.exists()) {
            throw new IllegalArgumentException("El directorio no existe: " + directoryPath);
        }
    }

    private static String normalizePath(String path) {
        if (path == null) {
            return null;
        }
        return path.trim().replace("/", File.separator).replace("\\", File.separator);
    }

    private static Properties loadConfiguration() throws IOException {
        Properties config = new Properties();
        try (InputStream input = DirectoryTool.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("No se pudo encontrar el archivo config.properties en el classpath");
            }
            config.load(input);
        }
        return config;
    }

    private static void validateConfiguration(String directoryPath, String outputPath) {
        if (directoryPath == null || directoryPath.isEmpty()) {
            throw new IllegalArgumentException("El directorio a leer no está configurado en config.properties");
        }
        if (outputPath == null || outputPath.isEmpty()) {
            throw new IllegalArgumentException("La ruta del archivo de salida no está configurada en config.properties");
        }
    }
}