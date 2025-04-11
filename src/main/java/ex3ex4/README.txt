# Manual de Compilación y Ejecución del Programa ex3ex4


## Estructura del Proyecto
El proyecto consta de los siguientes archivos:
- `DirectoryTool.java`: Contiene los métodos principales que implementan las funcionalidades del programa.
- `Start.java`: Contiene el método `main` para interactuar con el usuario y ejecutar las funcionalidades.

### Nuevas Funcionalidades
1. **Guardar Listado Alfabético en un Archivo**: 
   - Genera un listado alfabético de los archivos y carpetas dentro de un directorio y lo guarda en un archivo `.txt`.
2. **Guardar Árbol de Directorios en un Archivo**:
   - Genera un árbol jerárquico de un directorio y sus subdirectorios, y lo guarda en un archivo `.txt`.
3. **Leer y Mostrar el Contenido de un Archivo `.txt`**:
   - Permite leer cualquier archivo `.txt` y muestra su contenido en la consola.

## Instrucciones de Compilación

1. **Abrir un Terminal o Consola**:
   - Diríjase al directorio donde se encuentran los archivos `DirectoryTool.java` y `Start.java`.

2. **Compilar los Archivos**:
   - Use el siguiente comando para compilar los archivos:
    
     javac -d . DirectoryTool.java Start.java
   
   - Esto generará una estructura de directorios basada en el paquete `ex3ex4` y creará los archivos `.class` correspondientes.

## Instrucciones de Ejecución

1. **Ejecutar el Programa**:
   - Ejecute el programa con el siguiente comando desde el directorio raíz del proyecto:
    
     java ex3ex4.Start
     

2. **Interacción con el Usuario**:
   - El programa mostrará un menú con las siguientes opciones:
     
     Elige una opción:
     1. Generar listado alfabético y guardarlo en un fichero
     2. Generar árbol de directorios y guardarlo en un fichero
     3. Leer un fichero TXT y mostrar su contenido
     

3. **Seleccionar Funcionalidad**:
   - Introduzca el número asociado a la funcionalidad que desea ejecutar y presione **Enter**.

## Funcionalidades Detalladas

### 1. **Generar Listado Alfabético y Guardarlo en un Fichero**
   - **Descripción**:
     Genera un listado alfabético de los archivos y subdirectorios dentro de un directorio y lo guarda en un archivo `.txt`.
   - **Cómo usarlo**:
     - Seleccione la opción `1` en el menú.
     - Introduzca el **path del directorio** que desea listar.
     - Introduzca la **ruta y el nombre del archivo de salida** (ejemplo: `listado.txt`).
   - **Salida esperada**:
     - Un archivo `.txt` con los nombres de los archivos y subdirectorios ordenados alfabéticamente.
   - **Ejemplo**:
    
     Elige una opción:
     1
     Introduce el directorio path: 
     C:\Usuarios\Publico
     Introduce la ruta y nombre para guardar el archivo de salida: 
     listado.txt
     Generando listado alfabético...
     Listado alfabético guardado en: listado.txt
     

### 2. **Generar Árbol de Directorios y Guardarlo en un Fichero**
   - **Descripción**:
     Genera un árbol jerárquico del directorio y sus subdirectorios, y lo guarda en un archivo `.txt`.
   - **Cómo usarlo**:
     - Seleccione la opción `2` en el menú.
     - Introduzca el **path del directorio** cuya estructura desea guardar.
     - Introduzca la **ruta y el nombre del archivo de salida** (ejemplo: `arbol.txt`).
   - **Salida esperada**:
     - Un archivo `.txt` con la estructura jerárquica del directorio.
   - **Ejemplo**:
     
     Elige una opción:
     2
     Introduce el directorio path: 
     C:\Usuarios\Publico
     Introduce la ruta y nombre para guardar el archivo de salida: 
     arbol.txt
     Generando árbol de directorios...
     Árbol del directorio guardado en: arbol.txt
    

### 3. **Leer y Mostrar el Contenido de un Archivo `.txt`**
   - **Descripción**:
     Permite leer el contenido de cualquier archivo `.txt` y mostrarlo por consola.
   - **Cómo usarlo**:
     - Seleccione la opción `3` en el menú.
     - Introduzca la **ruta completa del archivo `.txt`** que desea leer.
   - **Salida esperada**:
     - El contenido del archivo se mostrará directamente en la consola.
   - **Ejemplo**:
   
     Elige una opción:
     3
     Introduce la ruta del archivo TXT que deseas leer: 
     listado.txt
     Contenido del archivo listado.txt:
     Documentos
     Imágenes
     Música
     Videos
    

## Manejo de Errores
- **Errores relacionados con directorios**:
  - Si el directorio no existe:
    
    Error: El directorio no existe: {ruta_del_directorio}
    
  - Si la ruta proporcionada no es un directorio:
   
    Error: La ruta proporcionada no es un directorio: {ruta_del_directorio}
    
- **Errores relacionados con archivos**:
  - Si el archivo no existe o no es válido:
   
    Error: El archivo no existe o no es un archivo válido: {ruta_del_archivo}
   
  - Si ocurre un error al escribir en el archivo:
  
    Error escribiendo en el archivo: {mensaje_de_error}

  - Si ocurre un error al leer el archivo:
   
    Error leyendo el archivo: {mensaje_de_error}
 

## Notas Adicionales
- Asegúrese de proporcionar rutas válidas y accesibles desde el sistema operativo.
- El programa es compatible con sistemas operativos Windows, macOS y Linux, siempre que las rutas se introduzcan en el formato correcto para cada sistema.

¡Disfrute utilizando el programa!