# Manual de Compilación y Ejecución del Programa ex5

## Estructura del Proyecto
El proyecto consta de los siguientes archivos:
- `User.java`: Clase que representa el objeto `User` con propiedades `name` y `key`.
- `SerializationTool.java`: Contiene métodos para serializar (`serializeObjects`) y deserializar (`deserializeObjects`) objetos, así como para listar archivos `.ser` en un directorio.
- `Start.java`: Punto de entrada del programa que permite interactuar con las funcionalidades a través de un menú.

### Funcionalidades Principales
1. **Serialización de Usuarios**:
   - Convierte objetos de la clase `User` en un archivo binario `.ser`.
2. **Deserialización de Usuarios**:
   - Reconstruye objetos a partir de un archivo `.ser`.
3. **Listado de Archivos `.ser`**:
   - Muestra todos los archivos `.ser` en un directorio especificado.


## Instrucciones de Compilación

1. **Abrir un Terminal o Consola**:
   - Navegue al directorio raíz donde se encuentran los archivos `User.java`, `SerializationTool.java` y `Start.java`.

2. **Compilar los Archivos**:
   - Ejecute el siguiente comando para compilar los archivos:
     
     javac -d . User.java SerializationTool.java Start.java
    

3. **Verificar la Compilación**:
   - Esto generará una estructura de directorios basada en el paquete `ex5` y los archivos `.class` correspondientes.



## Instrucciones de Ejecución

1. **Ejecutar el Programa**:
   - Ejecute el siguiente comando desde el directorio raíz del proyecto:
    
     java ex5.Start
    

2. **Interacción con el Usuario**:
   - Aparecerá el siguiente menú en la consola:
   
     Elige una opción:
     1. Serializar un usuario y guardarlo en un fichero
     2. Deserializar usuarios desde un fichero
     3. Listar archivos .ser en un directorio
     4. Salir del programa
    

3. **Seleccionar Funcionalidad**:
   - Introduzca el número correspondiente a la funcionalidad deseada y presione **Enter**.


## Funcionalidades Detalladas

### 1. **Serializar un Usuario**
   - **Descripción**: Guarda uno o más objetos de la clase `User` en un archivo `.ser`.
   - **Pasos**:
     1. Seleccione la opción `1` en el menú.
     2. Introduzca el **nombre del usuario**.
     3. Introduzca el **ID del usuario**.
     4. Proporcione la **ruta y nombre del archivo** donde se guardarán los objetos serializados (ejemplo: `users.ser`).
   - **Salida esperada**:
     - Mensaje indicando que los usuarios han sido serializados correctamente.
   - **Ejemplo**:
   
     Elige una opción:
     1
     Introduce el nombre del usuario: 
     Juan
     Introduce el ID del usuario: 
     101
     Introduce la ruta y nombre del archivo para guardar los usuarios serializados: 
     users.ser
     Usuarios serializados y guardados en: users.ser
    

### 2. **Deserializar Usuarios**
   - **Descripción**: Carga objetos de un archivo `.ser` y los muestra en la consola.
   - **Pasos**:
     1. Seleccione la opción `2` en el menú.
     2. Proporcione la **ruta completa del archivo `.ser`** (ejemplo: `users.ser`).
   - **Salida esperada**:
     - Los objetos deserializados se mostrarán en la consola.
   - **Ejemplo**:
  
     Elige una opción:
     2
     Introduce la ruta del archivo que contiene los usuarios serializados: 
     users.ser
     Usuarios deserializados:
     User{name='Juan', key=101}
     

### 3. **Listar Archivos `.ser`**
   - **Descripción**: Muestra los archivos `.ser` en un directorio especificado.
   - **Pasos**:
     1. Seleccione la opción `3` en el menú.
     2. Proporcione la **ruta del directorio** donde buscar archivos `.ser`.
   - **Salida esperada**:
     - Lista de archivos `.ser` encontrados.
   - **Ejemplo**:
    
     Elige una opción:
     3
     Introduce el directorio donde buscar archivos .ser: 
     /home/user/documents
     Archivos .ser encontrados:
     - users.ser
   

### 4. **Salir del Programa**
   - **Descripción**: Finaliza la ejecución del programa.
   - **Cómo usarlo**:
     - Seleccione la opción `4` en el menú.
   - **Salida esperada**:
   
     Saliendo del programa. ¡Hasta luego!
 

## Manejo de Errores

- **Errores al Serializar**:
  - Si ocurre un problema al guardar los usuarios:
   
    Error al serializar los usuarios: {mensaje_de_error}
   

- **Errores al Deserializar**:
  - Si el archivo no existe o no es válido:
    
    Error al deserializar los usuarios: {mensaje_de_error}
   
  - Si el contenido del archivo no es compatible:
    
    Error al deserializar los usuarios: java.lang.ClassNotFoundException
    

- **Errores al Listar Archivos**:
  - Si el directorio no existe o no es válido:
    
    El directorio no existe o no es válido.
    


## Notas Adicionales
- Asegúrese de usar rutas válidas y accesibles desde su sistema operativo.
- Este programa es compatible con sistemas operativos Windows, macOS y Linux, siempre que las rutas se introduzcan de forma adecuada.
- Los archivos `.ser` generados pueden ser deserializados en cualquier sistema que use la misma versión de la clase `User`.

¡Disfrute utilizando el programa!