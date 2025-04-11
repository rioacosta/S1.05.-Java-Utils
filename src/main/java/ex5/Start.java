package ex5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ex5.SerializationTool.*;

public class Start {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        while (true) {
            System.out.println("\nElige una opción:");
            System.out.println("1. Serializar un usuario y guardarlo en un fichero");
            System.out.println("2. Deserializar usuarios desde un fichero");
            System.out.println("3. Listar archivos .ser en un directorio");
            System.out.println("4. Salir del programa");
            int choice = input.nextInt();
            input.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1 -> {
                    System.out.println("Introduce el nombre del usuario: ");
                    String name = input.nextLine();
                    System.out.println("Introduce el ID del usuario: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.println("Introduce la ruta y nombre del archivo para guardar los usuarios serializados (ejemplo: users.ser): ");
                    String serializePath = input.nextLine();

                    users.add(new User(name, id));
                    try {
                        serializeObjects(users, serializePath);
                        System.out.println("Usuarios serializados y guardados en: " + serializePath);
                    } catch (IOException e) {
                        System.out.println("Error al serializar los usuarios: " + e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.println("Introduce la ruta del archivo que contiene los usuarios serializados (ejemplo: users.ser): ");
                    String deserializePath = input.nextLine();

                    if (!fileExists(deserializePath)) {
                        System.out.println("El archivo especificado no existe o no es válido.");
                        break;
                    }

                    try {
                        List<User> deserializedUsers = deserializeObjects(deserializePath);
                        System.out.println("Usuarios deserializados:");
                        deserializedUsers.forEach(System.out::println);
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error al deserializar los usuarios: " + e.getMessage());
                    }
                }

                case 3 -> {
                    System.out.println("Introduce el directorio donde buscar archivos .ser: ");
                    String directoryPath = input.nextLine();

                    listSerializedFiles(directoryPath);
                }

                case 4 -> {
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    return; // Salir del programa
                }

                default -> System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }
        }
    }
}