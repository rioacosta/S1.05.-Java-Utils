package nivel1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirectoryUtils {

    // Ejercicio 1: Método para listar el contenido de un directorio alfabéticamente
    public void listDirectoryContents(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            System.out.println("El camino proporcionado no es un directorio.");
            return;
        }

        String[] contents = directory.list();
        if (contents != null) {
            Arrays.sort(contents);
            for (String item : contents) {
                System.out.println(item);
            }
        } else {
            System.out.println("El directorio está vacío o ocurrió un error.");
        }
    }

    // Ejercicio 2: Método para listar el árbol de directorios recursivamente
    public void listDirectoryTree(String directoryPath, String indent) {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            System.out.println("El camino proporcionado no es un directorio.");
            return;
        }

        String[] contents = directory.list();
        if (contents != null) {
            Arrays.sort(contents);
            for (String item : contents) {
                File file = new File(directoryPath + File.separator + item);
                String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()));
                if (file.isDirectory()) {
                    System.out.println(indent + "[D] " + item + " (Última modificación: " + lastModified + ")");
                    listDirectoryTree(directoryPath + File.separator + item, indent + "    ");
                } else {
                    System.out.println(indent + "[F] " + item + " (Última modificación: " + lastModified + ")");
                }
            }
        } else {
            System.out.println("El directorio está vacío o ocurrió un error.");
        }
    }

    // Ejercicio 3: Método para guardar el árbol de directorios en un archivo TXT
    public void saveDirectoryTreeToFile(String directoryPath, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            listDirectoryTree(directoryPath, "", writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para listar el árbol de directorios recursivamente y guardar en archivo
    private void listDirectoryTree(String directoryPath, String indent, PrintWriter writer) {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            writer.println("El camino proporcionado no es un directorio.");
            return;
        }

        String[] contents = directory.list();
        if (contents != null) {
            Arrays.sort(contents);
            for (String item : contents) {
                File file = new File(directoryPath + File.separator + item);
                String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()));
                if (file.isDirectory()) {
                    writer.println(indent + "[D] " + item + " (Última modificación: " + lastModified + ")");
                    listDirectoryTree(directoryPath + File.separator + item, indent + "    ", writer);
                } else {
                    writer.println(indent + "[F] " + item + " (Última modificación: " + lastModified + ")");
                }
            }
        } else {
            writer.println("El directorio está vacío o ocurrió un error.");
        }
    }

    // Ejercicio 4: Método para leer el contenido de un archivo TXT y mostrarlo por consola
    public void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Ejercicio 5: Método para serializar un objeto Java a un archivo .ser
    public void serializeObject(Object obj, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para deserializar un objeto Java desde un archivo .ser
    public Object deserializeObject(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}