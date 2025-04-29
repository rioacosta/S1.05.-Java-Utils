package ex3ex4;

import java.io.IOException;
import java.util.Scanner;

import static ex3ex4.DirectoryTool.*;

public class Start {
    public static void main(String[] args) throws IOException {
        String directoryPath;
        String outputPath;
        int choice;
        Scanner input = new Scanner(System.in);

        try {
            do {
        System.out.println("""
                            Elige una opción:\n
                            1. Generar listado alfabético y guardarlo en un fichero \n
                            2. Generar árbol de directorios y guardarlo en un fichero \n
                            3. Leer un fichero TXT y mostrar su contenido \n
                            4. Salir \
                            """);
        choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1-> alphabeticListingToFile();

            case 2-> directoryTreeToFile();

            case 3-> readFileAndPrint();

            default -> System.out.println("Opción no válida.");

        }
            } while (choice != 4);

        } catch(IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

    }

}
