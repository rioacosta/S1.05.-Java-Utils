package ex1ex2;

import java.util.Scanner;

import static ex1ex2.DirectoryTool.alphabeticListing;
import static ex1ex2.DirectoryTool.directoryTree;

public class Start {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        String directoryPath;

        try {
            do {
                System.out.println("""
                            Elige una opción: \n
                            1. Listar alfabeticamente un directorio\n
                            2. Árbol de directorios con niveles y tipo de contenido\n
                            3. Salir.""");
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1-> alphabeticListing();

                    case 2-> directoryTree();

                    case 3-> System.out.println("Ha salido del programa");

                    default-> System.out.println("Opción no válida.");

                }
            } while (choice != 3);

            } catch(IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            }

    }
}