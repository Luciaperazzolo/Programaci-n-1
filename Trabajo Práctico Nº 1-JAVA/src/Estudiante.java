public class Estudiante extends Persona implements MiembroUniversidad{ //Definimos una clase pública llamada Estudiante.
    // Atributos privados para aplicar encapsulamiento
    private String carrera;
    private double promedio;

    // Array de materias (máximo 10 por estudiante)
    private Materia[] materias = new Materia[10]; //Declaramos un array privado de objetos Materia, limitado a 10.
    private int cantidadMaterias = 0; // Contador para el número actual de materias inscritas (inicializado a 0).

    // Constructor sin parámetros
    public Estudiante() {
       super(null, null, 0, null); 
    } 

    // Constructor con parámetros usando this
    public Estudiante(String nombre, String apellido, int edad, String documento , String carrera, double promedio) { //Se define un constructor que inicializa todos los atributos principales.
        super (nombre , apellido , edad , documento); // Llamada al constructor de la clase base
        // Atributos propios de Estudiante
        this.carrera = carrera; //Asigna directamente el valor a la variable de instancia. No tiene ninguna lógica de validación dentro de su método setter.
        setPromedio(promedio);
    }

    // Getters y Setters con validaciones
    
    public String getCarrera() { 
        return carrera; 
    }
    public void setCarrera(String carrera) { 
        this.carrera = carrera; 
    }
    public double getPromedio() { 
        return promedio; 
    }
    public void setPromedio(double promedio) { //Método setter para establecer el promedio.
        if (promedio >= 0 && promedio <= 10) this.promedio = promedio; //Asigna el promedio solo si está en el rango de 0 a 10.
    }

    // Método para agregar una materia
    public void agregarMateria(Materia materia) { //Definimos un método para añadir una Materia al array.
        if (cantidadMaterias < materias.length) { //Comprueba si el array de materias no ha alcanzado su capacidad máxima (10).
            materias[cantidadMaterias++] = materia; //Añade el objeto Materia al siguiente espacio disponible y luego incrementa el contador de materias.
        }
    }

    // Método para calcular el promedio de calificaciones
    public double calcularPromedio() { //Definimos un método que calcula el promedio de las calificaciones.
        if (cantidadMaterias == 0) return 0.0; //Si no hay materias, devuelve 0.0 para evitar división por cero.
        double suma = 0; //Inicializa una variable para acumular la suma de las calificaciones.
        for (int i = 0; i < cantidadMaterias; i++) { //Itera sobre todas las materias inscritas.
            suma += materias[i].getCalificacion(); //Suma la calificación de la materia actual a la variable 'suma'.
        }
        promedio = suma / cantidadMaterias;  //Calcula el promedio dividiendo la suma por la cantidad de materias y lo asigna al atributo 'promedio'.
        return promedio; //Devuelve el Resultado.
    }

    // Mostrar materias del estudiante
    public void mostrarMaterias() { //Definimos un método para imprimir las materias y sus calificaciones.
        for (int i = 0; i < cantidadMaterias; i++) {
            System.out.println("- " + materias[i].getNombre() + ": " + materias[i].getCalificacion()); //Imprime el nombre y la calificación de la materia actual.
        }
    }


    //Método toString, Muestra la información de los objetos de manera legible.
    public String toString() {
    return "Nombre: " + getNombre() + ", " +
           "Apellido: " + getApellido() + ", " +
           "Edad: " + getEdad() + ", " +
           "Documento: " + getDocumento() + ", " +
           "Carrera: " + carrera + ", " +
           "Promedio: " + promedio;
}

    //Implementacion de metodos de la interfaz MiembroUniversidad
    @Override
    public String obtenerRol() {
        return "Estudiante";
    }

    @Override
    public String obtenerInformacionCompleta() {
        // Reutilizamos el método toString() para la información completa
        return this.toString();
    }






    //Parte 1 del tp: Implementación de Funciones Recursivas
    //función recursiva para calcular el promedio académico de un estudiante

    public static double calcularPromedioRecursivo(Materia[] materias, int indice) { //si el arreglo es nulo o llegamos al final
    if (materias == null || indice >= materias.length) {
        return 0.0;
    }

    if (materias[indice] == null) {     // Si la materia en esta posición es nula, pasamos a la siguiente
        return calcularPromedioRecursivo(materias, indice + 1);
    }

    double promedioResto = calcularPromedioRecursivo(materias, indice + 1); // Llamada recursiva para el resto del arreglo

    int materiasRestantes = contarMateriasRecursivo(materias, indice + 1); // Contamos cuántas materias quedan después de esta

    int totalMaterias = 1 + materiasRestantes;  // Total de materias válidas hasta ahora

    double sumaTotal = (promedioResto * materiasRestantes) + materias[indice].getCalificacion();// Suma total = calificación actual + suma del resto

    return sumaTotal / totalMaterias;   // Calculamos el promedio total
}

// Método auxiliar para contar materias válidas
private static int contarMateriasRecursivo(Materia[] materias, int indice) {
    if (materias == null || indice >= materias.length) {
        return 0;
    }
    if (materias[indice] == null) {
        return contarMateriasRecursivo(materias, indice + 1);
    }
    return 1 + contarMateriasRecursivo(materias, indice + 1);
}
/*  Recursivo: más elegante desde el punto de vista teórico,
    pero más dificil de leer y menos eficiente
    porque hace muchas llamadas a la pila.*/



//versión iterativa
public double calcularPromedioIterativo() {
    double suma = 0.0;
    int contador = 0;

    // Verificamos primero que el arreglo no sea nulo
    if (materias != null) {
        // Recorremos las materias
        for (Materia m : materias) {
            // Si la materia existe, sumamos su calificación y contamos
            if (m != null) {
                suma += m.getCalificacion();
                contador++;
            }
        }
    }

    // Si no hay materias válidas, devolvemos 0
    return (contador == 0) ? 0.0 : (suma / contador);
}
//  Iterativo: más simple y directo, recomendado en casos reales con muchos datos.


}