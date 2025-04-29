package ex5;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SerializationTool {
    private final static Scanner INPUT = new Scanner(System.in);

    public static void serializeObjects()  {
        Logger logger = Logger.getLogger("UserSerializationLogger");
        logger.setLevel(Level.ALL);

        System.out.println("Introduce el nombre del usuario: ");
        String name = INPUT.nextLine();

        System.out.println("Introduce el ID del usuario: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();

        System.out.println("Introduce la ruta y nombre del archivo para guardar los usuarios serializados (ejemplo: users.ser): ");
        String filePath = INPUT.nextLine();
        filePath = normalizePath(filePath);

        User user = new User(name, id);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(user);
            System.out.println("Usuario serializado y guardado en: " + filePath);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error al serializar los usuarios: ", e);
            System.out.println("Consulta los registros para ver que ha salido mal");
        }
    }

    public static void deserializeObjects() {
        Logger logger = Logger.getLogger("UserDeserializationLogger");
        logger.setLevel(Level.ALL);

        System.out.println("Introduce la ruta del archivo que contiene los usuarios serializados (ejemplo: users.ser): ");
        String filePath = INPUT.nextLine();
        filePath = normalizePath(filePath);

        if (!validatePath(filePath)) {
            System.out.println("El archivo especificado no existe o no es válido.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            @SuppressWarnings("unchecked")
            User deserializedUser = (User) ois.readObject();
            System.out.println("Usuarios deserializados: " + deserializedUser);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error al deserializar el archivo: ", e);
            System.out.println("Ocurrió un error. Consulta los registros para más detalles.");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Clase no encontrada durante la deserialización: ", e);
            System.out.println("Ocurrió un error con las clases. Consulta los registros para más detalles.");
        }
    }

    public static void listSerializedFiles() {
        System.out.println("Introduce el directorio donde buscar archivos .ser: ");
        String directoryPath = INPUT.nextLine();
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
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede ser nula o estar vacía.");
        }
        return path.trim().replace("/", File.separator).replace("\\", File.separator);
    }

    public static boolean validatePath(String filePath) {
        filePath = normalizePath(filePath);
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }
}