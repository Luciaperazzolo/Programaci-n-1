public class Estudiante extends Persona implements MiembroUniversidad{ //Definimos una clase pública llamada Estudiante, HEREDA de Persona (atributos básicos), IMPLEMENTA la interfaz MiembroUniversidad (contrato de rol y obtener información).
    // Atributos privados para aplicar encapsulamiento
    private String carrera;
    private double promedio;

    // Array de materias (máximo 10 por estudiante)
    private Materia[] materias = new Materia[10]; //Declaramos un array privado de objetos Materia, limitado a 10.
    private int cantidadMaterias = 0; // Contador para el número actual de materias inscritas (inicializado a 0).

    // Constructor sin parámetros
    public Estudiante() {
       super(null, null, 0, null); //Llama al constructor de la clase Persona inicializando los atributos heredados con valores nulos/cero.
    } 

    // Constructor con parámetros usando this
    public Estudiante(String nombre, String apellido, int edad, String documento , String carrera, double promedio) { //Se define un constructor que inicializa todos los atributos principales.
        super (nombre , apellido , edad , documento); //Llama al constructor de la clase base (Persona) para inicializar los atributos heredados.
        // Atributos propios de Estudiante
        this.carrera = carrera; //Asigna directamente el valor a la variable de instancia. No tiene ninguna lógica de validación dentro de su método setter.
        setPromedio(promedio); //Usa el setter para aplicar la validación de rango (0 a 10) al promedio.
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
    //Setter con validación para asegurar que el promedio esté en un rango válido.
    public void setPromedio(double promedio) { //Método setter para establecer el promedio.
        if (promedio >= 0 && promedio <= 10) this.promedio = promedio; //Asigna el promedio solo si está en el rango de 0 a 10.
    }

    //Método para agregar una materia al array de materias del estudiante.
    public void agregarMateria(Materia materia) { //Definimos un método para añadir una Materia al array.
        if (cantidadMaterias < materias.length) { //Comprueba si el array de materias no ha alcanzado su capacidad máxima (10).
            materias[cantidadMaterias++] = materia; // Añade la materia al índice actual y luego incrementa el contador (cantidadMaterias++).
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
    //Concatena la información heredada (Persona) y la propia (Carrera, Promedio).
    public String toString() {
    return "Nombre: " + getNombre() + ", " +
           "Apellido: " + getApellido() + ", " +
           "Edad: " + getEdad() + ", " +
           "Documento: " + getDocumento() + ", " +
           "Carrera: " + carrera + ", " +
           "Promedio: " + promedio;
}

    //Implementacion de metodos de la interfaz MiembroUniversidad
    //Método para devolver el rol del miembro en la universidad.
    @Override
    public String obtenerRol() {
        return "Estudiante"; //Devuelve el rol específico de esta clase.
    }

    //Método para devolver toda la información del miembro.
    @Override
    public String obtenerInformacionCompleta() {
        // Reutilizamos el método toString() para la información completa
        return this.toString();
    }
}