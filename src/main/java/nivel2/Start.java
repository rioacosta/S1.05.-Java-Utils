package nivel2;

import java.io.IOException;
import java.util.Scanner;

import static nivel2.DirectoryTool.*;

public class Start {
    public static void main(String[] args) throws IOException {
        int choice;
        Scanner input = new Scanner(System.in);

        try {
            do {
                System.out.println("""
                        Elige una opción:\n
                        1. Generar listado alfabético y guardarlo en un fichero \n
                        2. Generar árbol de directorios y guardarlo en un fichero \n
                        3. Salir \
                        """);
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1 -> alphabeticListingToFile();
                    case 2 -> directoryTreeToFile();
                    case 3 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción no válida.");
                }
            } while (choice != 3);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}