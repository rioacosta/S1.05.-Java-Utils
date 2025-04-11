package ex3ex4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static ex3ex4.DirectoryTool.AlphabeticListingToFile;
import static ex3ex4.DirectoryTool.DirectoryTreeToFile;

public class Start {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Elige una opción:");
        System.out.println("1. Generar listado alfabético y guardarlo en un fichero");
        System.out.println("2. Generar árbol de directorios y guardarlo en un fichero");
        System.out.println("3. Leer un fichero TXT y mostrar su contenido");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
            case 2:
                System.out.println("Introduce el directorio path: ");
                String directoryPath = input.nextLine();
                System.out.println("Introduce la ruta y nombre para guardar el archivo de salida (ejemplo: output.txt): ");
                String outputPath = input.nextLine();

                try {
                    if (choice == 1) {
                        System.out.println("Generando listado alfabético...");
                        AlphabeticListingToFile(directoryPath, outputPath);
                        System.out.println("Listado alfabético guardado en: " + outputPath);
                    } else {
                        System.out.println("Generando árbol de directorios...");
                        DirectoryTreeToFile(directoryPath, outputPath);
                        System.out.println("Árbol del directorio guardado en: " + outputPath);
                    }
                } catch (IOException e) {
                    System.out.println("Error escribiendo en el archivo: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            case 3:
                System.out.println("Introduce la ruta del archivo TXT que deseas leer: ");
                String filePath = input.nextLine();

                try {
                    readFileAndPrint(filePath);
                } catch (IOException e) {
                    System.out.println("Error leyendo el archivo: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void readFileAndPrint(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("El archivo no existe o no es un archivo válido: " + filePath);
        }

        System.out.println("Contenido del archivo " + filePath + ":");
        Files.lines(file.toPath()).forEach(System.out::println);
    }
}
