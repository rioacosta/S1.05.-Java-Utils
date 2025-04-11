package ex1ex2;

import java.util.Scanner;

import static ex1ex2.DirectoryTool.AlphabeticListing;
import static ex1ex2.DirectoryTool.DirectoryTree;

public class Start {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Elige una opción:");
        System.out.println("1. Listado alfabético");
        System.out.println("2. Árbol de directorios");
        int choice = input.nextInt();
        input.nextLine();

        System.out.println("Introduce el directorio path: ");
        String directoryPath = input.nextLine();

        try {
            switch (choice) {
                case 1:
                    System.out.println("Listado alfabético del directorio:");
                    String[] files = AlphabeticListing(directoryPath);
                    for (String file : files) {
                        System.out.println(file);
                    }
                    break;
                case 2:
                    System.out.println("Árbol del directorio:");
                    DirectoryTree(directoryPath);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}