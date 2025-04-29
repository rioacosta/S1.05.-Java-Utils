## Manual de Compilación y Ejecución del ejercicio EX5

### 1. Preparativos
Antes de comenzar, asegúrate de cumplir con los siguientes requisitos:

- Tener instalado Java Development Kit (JDK) en tu sistema.
- Verificar que el comando `javac` esté disponible desde la terminal.
- Organizar los archivos del proyecto en la siguiente estructura de directorios:
```
/
├── nivel1/
│   └── ex5/
│       ├── MainEx5.java
│       ├── User.java
│       ├── [Otros archivos .java]
```

### 2. Compilación del Proyecto
Para compilar el proyecto, sigue estos pasos:

1. Abre una terminal o línea de comandos.
2. Navega al directorio raíz del proyecto (el directorio que contiene la carpeta `nivel1`).
   ```bash
   cd /ruta/al/directorio/raiz
   ```
3. Ejecuta el siguiente comando para compilar todos los archivos `.java` dentro de `nivel1/ex5`:
   ```bash
   javac nivel1/ex5/*.java
   ```
   Esto generará archivos `.class` en la misma estructura de directorios, listos para ser ejecutados.

### 3. Ejecución del Programa
Para ejecutar el programa, utiliza el siguiente comando:

```bash
java nivel1.ex5.MainEx5 <ruta_relativa_al_archivo>
```

Donde `<ruta_relativa_al_archivo>` es la ruta relativa donde se guardará el archivo con el objeto serializado. Por ejemplo:
```bash
java nivel1.ex5.MainEx5 data/user.ser
```

### 4. Ejemplo Práctico
A continuación, se presenta un ejemplo práctico para probar el programa:

1. Crea un directorio para guardar el archivo serializado (si aún no existe):
   ```bash
   mkdir -p data
   ```
2. Ejecuta el programa especificando el archivo `data/user.ser` como destino:
   ```bash
   java nivel1.ex5.MainEx5 data/user.ser
   ```
3. Si todo funciona correctamente, deberías ver una salida similar en la terminal:
   ```
   Original User: User{name='Lila', key=54321}
   Object successfully serialized to: data/user.ser
   Object successfully deserialized
   Deserialized User: User{name='Lila', key=54321}
   ```

### 5. Notas Adicionales
- **Creación automática de archivos:** Si el archivo especificado en `<ruta_relativa_al_archivo>` no existe, el programa lo creará automáticamente.
- **Verificación del archivo serializado:** Para comprobar el contenido del archivo serializado, simplemente deserializa el objeto ejecutando nuevamente el programa con el mismo archivo. La salida en la terminal mostrará los datos deserializados.
- **Estructura del código:** Asegúrate de que las clases como `User` y `MainEx5` estén correctamente definidas y que el paquete `ex5` coincida con la estructura del directorio (`nivel1/ex5`).

### 6. Solución de Problemas
- **Error: Clase no encontrada (`ClassNotFoundException`)**
  Verifica que los archivos `.java` fueron compilados correctamente y que las rutas al ejecutarlos son correctas.
- **Error: Archivo no encontrado (`FileNotFoundException`)**
  Asegúrate de que la ruta especificada para `<ruta_relativa_al_archivo>` exista o pueda ser creada.

## 7. Notas Adicionales
- Asegúrese de usar rutas válidas y accesibles desde su sistema operativo.
- Este programa es compatible con sistemas operativos Windows, macOS y Linux, siempre que las rutas se introduzcan de forma adecuada.
- Los archivos `.ser` generados pueden ser deserializados en cualquier sistema que use la misma versión de la clase `User`.

¡Disfrute utilizando el programa!