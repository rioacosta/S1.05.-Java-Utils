package nivel1;

import java.io.Serializable;

public class Main {

	 public static void main(String[] args) {
	        DirectoryUtils utils = new DirectoryUtils();

	        // Ejercicio 1
	        utils.listDirectoryContents("path/to/your/directory");

	        // Ejercicio 2
	        utils.listDirectoryTree("path/to/your/directory", "");

	        // Ejercicio 3
	        utils.saveDirectoryTreeToFile("path/to/your/directory", "output.txt");

	        // Ejercicio 4
	        utils.readFile("output.txt");

	        // Ejercicio 5
	        String filePath = "object.ser";
	        MyClass obj = new MyClass("example", 123);
	        utils.serializeObject(obj, filePath);
	        MyClass deserializedObj = (MyClass) utils.deserializeObject(filePath);
	        System.out.println(deserializedObj);
	    }
	}

	// Clase de ejemplo para la serialización y deserialización
	class MyClass implements Serializable {
	    private String name;
	    private int value;

	    public MyClass(String name, int value) {
	        this.name = name;
	        this.value = value;
	    }

	    @Override
	    public String toString() {
	        return "MyClass{name='" + name + "', value=" + value + "}";
	    }
	}