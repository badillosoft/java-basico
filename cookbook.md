# Notas del curso de Java Básico

Alan Badillo Salas <badillo.soft@hotmail.com>

## Clases y Objetos

Una ´clase´ es el esquema en el que se definen
*atributos* y *métodos* para construir ´objetos´.

~~~java
class Persona {
  String Nombre;
  int Edad;
  
  void saludar() {
    System.out.printf("Me llamo %s, tengo %d años%n",
      this.Nombre, this.Edad);
  }
}
~~~

Un ´objeto´ es una instancia, es decir, un contexto
independiente de otros objetos en el que se se guardan
varables (atributos) y métodos definidos en una clase.

~~~java
Persona persona1 = new Persona();

persona1.Nombre = "pepe";
persona1.Edad = 18;

persona1.saludar();

Persona persona2 = new Persona();

persona2.Nombre = "paco";
persona2.Edad = 28;

persona2.saludar();

persona1.saludar();
~~~

## Colecciones

Existen varias colecciones como ´ArrayList´, ´Stack´, ´HashSet´,
´HashMap´. Las colecciónes son genéricas, es decir, que podemos utilizarlas
con distintos tipos de elementos almacenados.

> ArrayList

~~~java
ArrayList<Persona> personas = new ArrayList();

for (int i = 1; i <= 100; i++) {
  Persona p = new Persona();
  p.Nombre = String.format("Persona%d", i);
  p.Edad = 20 + i;
  personas.add(p);
}

Persona h = personas.get(13);

h.Edad = 9999;

h.saludar();

personas.get(23).Edad = 8888;
~~~

> Nota: El objeto ´h´ hace referencia al objeto obtenido de la lista
en la posición ´13´. Si modificamos los atributos del objeto ´h´
se modifican los atributos del objeto de la lista ´personas´ en el
índice ´13´.

~~~java
personas.add(13, null);

for (Persona p : personas) {
  if (p == null) {
    continue;
  }
  
  p.saludar();
}
~~~

~~~java

~~~

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

Podemos también usar la nueva notación de java para `try-catch`, revise las diferencias con el código anterior.

~~~java
// import java.io.FileReader
// import java.io.IOException

try(FileReader fr = new FileReader("path/.../file.ext")) {
   
  // TODO: Lógica del archivo (véase el ejemplo de archivos y Scanner)
  
  fr.close();
} catch(IOException e) {
  System.out.println(e.getMessage());
}
~~~

