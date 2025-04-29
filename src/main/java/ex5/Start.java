package ex5;

import java.io.IOException;
import java.util.Scanner;

import static ex5.SerializationTool.*;

public class Start {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int choice;
        try {
            do {
                System.out.println("\nElige una opción:");
                System.out.println("1. Serializar un usuario y guardarlo en un fichero");
                System.out.println("2. Deserializar usuarios desde un fichero");
                System.out.println("3. Listar archivos .ser en un directorio");
                System.out.println("4. Salir del programa");
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1 -> serializeObjects();

                    case 2 -> deserializeObjects();

                    case 3 -> listSerializedFiles();

                    case 4 -> System.out.println("Saliendo del programa. ¡Hasta luego!");

                    default -> System.out.println("Opción no válida. Por favor, elige una opción del menú.");

                }
            } while (choice != 4);

        } catch(IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

    }

}