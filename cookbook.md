# Notas del curso de Java Básico

Alan Badillo Salas <badillo.soft@hotmail.com>

## Abrir un archivo

Para abrir el flujo de un archivo hay que tomar en cuenta que este podra generar excepciones
si el archivo no existe o no se tuvieran permisos de lectura. En el siguiente ejemplo se muestra la forma correcta de abrir el flujo
de un archivo.

~~~java
// import java.io.FileReader
// import java.io.IOException

try {
  FileReader fr = new FileReader("path/.../file.ext");
  
  // TODO: Lógica del archivo (véase el ejemplo de archivos y Scanner)
  
  fr.close();
} catch(IOException e) {
  System.out.println(e.getMessage());
}
~~~
