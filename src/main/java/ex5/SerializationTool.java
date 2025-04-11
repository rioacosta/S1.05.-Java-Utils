package ex5;

import java.io.*;
import java.util.List;

public class SerializationTool {

    public static void serializeObjects(List<User> users, String filePath) throws IOException {
        filePath = normalizePath(filePath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(users);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<User> deserializeObjects(String filePath) throws IOException, ClassNotFoundException {
        filePath = normalizePath(filePath);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<User>) ois.readObject();
        }
    }

    public static void listSerializedFiles(String directoryPath) {
        directoryPath = normalizePath(directoryPath);
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("El directorio no existe o no es válido.");
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".ser"));
        if (files == null || files.length == 0) {
            System.out.println("No se encontraron archivos .ser en el directorio especificado.");
        } else {
            System.out.println("Archivos .ser encontrados:");
            for (File file : files) {
                System.out.println("- " + file.getName());
            }
        }
    }

    private static String normalizePath(String path) {
        return path.replace("/", File.separator).replace("\\", File.separator);
    }

    public static boolean fileExists(String filePath) {
        filePath = normalizePath(filePath);
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }
}