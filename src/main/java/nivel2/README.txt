# Manual de Compilación y Ejecución Nivel 2

Preparativos:

Antes de comenzar, asegúrate de cumplir con los siguientes requisitos:

- Tener instalado Java Development Kit (JDK) en tu sistema.
- Verificar que el comando `javac` esté disponible desde la terminal.

2. **Configuración del Archivo `config.properties`:**
   - Asegúrate de haber creado un archivo `config.properties` en el directorio `src/main/resources` con los siguientes parámetros:
     ```properties
     # Ruta del directorio a leer
     directory.path=C:/example/directory

     # Ruta y nombre del archivo de salida
     output.file.path=C:/example/output.txt
     ```

3. **Estructura del Proyecto:**
   - Asegúrate de que la estructura del proyecto sea la siguiente:
     ```
     /src
       /main
         /java
           /nivel2
             DirectoryTool.java
             Start.java
         /resources
           config.properties
     ```

---

## Compilación

1. **Navega al Directorio del Proyecto:**
   Abre una terminal o consola y dirígete al directorio raíz del proyecto donde se encuentra el directorio `src`.
   ```bash
   cd /ruta/a/tu/proyecto
   ```

2. **Compila los Archivos Java:**
   Usa el siguiente comando para compilar los archivos Java:
   ```bash
   javac -d out -sourcepath src src/main/java/nivel2/DirectoryTool.java src/main/java/nivel2/Start.java
   ```
   - Este comando:
     - Compila los archivos de código fuente.
     - Genera los archivos `.class` en el directorio `out`.

---

## Ejecución

1. **Ejecuta la Clase `Start`:**
   Una vez compilado, ejecuta la clase `Start` como punto de entrada del programa:
   ```bash
   java -cp out nivel2.Start
   ```
   - El programa mostrará un menú interactivo en la consola.

2. **Interacción con el Menú:**
   - Cuando el programa se ejecute, verás un menú con las siguientes opciones:
     ```
     Elige una opción:

     1. Generar listado alfabético y guardarlo en un fichero
     2. Generar árbol de directorios y guardarlo en un fichero
     3. Salir
     ```
   - Introduce el número de la opción deseada y sigue las instrucciones.

---

## Ejemplo de Ejecución

### Opción 1: Generar Listado Alfabético
- Si eliges la opción `1`, el programa generará un listado alfabético de los archivos y carpetas en el directorio especificado en `config.properties` y lo guardará en el archivo de salida configurado.

### Opción 2: Generar Árbol de Directorios
- Si eliges la opción `2`, el programa generará un árbol jerárquico del directorio y lo guardará en el archivo de salida configurado.

### Opción 3: Salir
- Si eliges la opción `3`, el programa terminará.

---

## Notas

1. **Errores Comunes:**
   - Si el archivo `config.properties` no se encuentra, el programa mostrará un error indicando que no se puede cargar el archivo de configuración.
   - Si el directorio o la ruta de salida configurados no son válidos, aparecerá un mensaje de error en la consola.

2. **Debugging:**
   - Asegúrate de que los permisos de lectura y escritura sean correctos para los directorios y archivos configurados en `config.properties`.

---

## Limpieza

Si deseas eliminar los archivos compilados, simplemente borra el contenido del directorio `out`:
```bash
rm -rf out
```

---

¡Listo! Ahora puedes compilar y ejecutar el proyecto sin problemas.