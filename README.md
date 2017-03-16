# Notas del curso Java Básico

Instructor: Alan Badillo Salas <badillo.soft@hotmail.com>

# Proyectos

## IMPORTANTE:

Subí el proyecto A para los que gusten hacerlo.

El proyecto B y C los subiré cuando tenga tiempo, intenten trabajarlos.s

### Revisiones:

Dany Moreno: https://www.youtube.com/watch?v=AtI8kQXG_3A

# Tareas

## Tarea 1

* Crear una clase llamada `Foco` que contenga un atributo de tipo **booleano** llamado `encendido` y posea dos métodos llamados `encender()` y `apagar()` que cambien el valor de `encendido`.

* Crear una clase llamada `FocoPrueba` que sea ejecutable. El método ejecutable debe instanciar tres objetos de la clase `Foco` y encenderlos todos y luego apagarlos todos.

# Resúmenes

## Sesión 1

La programación en *Java* consiste en modelar objetos mediante clases, esto permite crear un nuevo paradigma de programación que es orientada a objetos.

### Variables

Las variables son como cajas donde podemos almacenar datos y acceder a ellos mediante un nombre. Cada variable creada debe tener un tipo de dato asociado que indica que tipo de dato puede almacenar.

> Ejemplo de variables y tipo de datos básicos

~~~java
int a = 123;
float b = 1.5f;
double c = 3.141592654;
boolean encendido = true;
char e = 'A';
String mensaje = "Hola mundo";
~~~~

Cuando decimos `int a;` estamos declarando la variable `a` de tipo `int`. Al decir `a = 123;` estamos asignado dicha variable a un valor. Poemos declarar y asignar una variable al mismo tiempo al decir `int a = 123;`.

### Clases y objetos

Una **Clase** es el esquema que se debe seguir para generar objetos, piense por ejemplo en un diagrama o plano para construir un edificio. La clase define los atributos y métodos que tendrá el objeto.

Un **Atributo** es una característica del objeto como tamaño, forma, color, etc. Los atributos en programación se almacenan como variables que contienen datos.

Un **Método** es un conjunto de instrucciones que realiza el objeto tomando su contexto de referencia, es decir, que accede solo a los valores internos del objeto y esto se conoce como su contexto. Un método puede recibir argumentos o parámetros del exterior del objeto mediante variables.

> Ejemplo de un método

~~~java
int suma(int a, int b) {
      this.ans = a + b;
      return ans;
}
~~~

Podemos observar que el método `suma` recibe dos argumentos `a` y `b` de tipo entero. La variable `this.ans` pertenece al objeto y es un atributo interno de el. La palabra `this` se puede omitir cuando no hay ambigüedad de acceder a una variable del objeto como `ans`.

Supongamos que deseamos crear una clase llamada `Persona` para representar de forma abstracta una persona en nuestro sistema, entonces tendríamos que crear un archivo llamado `Persona.java` y dentro de él el siguiente código:

~~~java
class Persona {
      
      String nombre;
      int edad;
      char sexo;
      float estatura;
      double peso;
      
      void saludar() {
            System.out.printf("Nombre: %s Edad: %d Sexo: %c %n", nombre, edad, sexo);
            System.out.printf("Estatura: %.2f Peso: %.2f %n", estatura, peso);
      }
      
}
~~~

> Incompleto: Esperen al martes o miércoles para el resumen completo.
