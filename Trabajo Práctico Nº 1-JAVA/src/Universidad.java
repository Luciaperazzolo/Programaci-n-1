import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre; //Variable de instancia privada para almacenar el nombre de la universidad.
    private String direccion;
    private List<MiembroUniversidad> miembros; //Variable de instancia privada para almacenar la dirección de la universidad.

    public Universidad(String nombre, String direccion) { //Definimos el constructor de la clase Universidad que acepta el nombre y la dirección.
        this.nombre = nombre; //Asigna el valor del parámetro 'nombre' a la variable de instancia 'nombre'.
        this.direccion = direccion; //Asigna el valor del parámetro 'direccion' a la variable de instancia 'direccion'.
        this.miembros = new ArrayList<>();
    }

    //metodo
    // Este método demuestra cómo se pueden procesar objetos diferentes, a través de una misma interfaz/clase base, cumpliendo el polimorfismo.
    public List<MiembroUniversidad> getMiembros() {
    return miembros;
    }

    // Nuevo método para agregar cualquier MiembroUniversidad
    public void agregarMiembro(MiembroUniversidad miembro) {
        if (miembro != null) {
            miembros.add(miembro);
            System.out.println(miembro.obtenerRol() + " " + ((Persona)miembro).getNombre() + " agregado a la universidad.");
        }
    }

    // Método para listar todos los miembros de la universidad
    public void listarTodosLosMiembros() {
        System.out.println("\n--- Miembros de la Universidad " + this.nombre + " ---");
        if (miembros.isEmpty()) {
            System.out.println("No hay miembros registrados.");
            return;
        }
        
        for (MiembroUniversidad miembro : miembros) {
            // Usamos el método de la interfaz para obtener la información
            System.out.println("[" + miembro.obtenerRol() + "] " + miembro.obtenerInformacionCompleta());
        }
    }


    // método para buscar y listar miembros por rol específico
    public void listarMiembrosPorRol(String rolBuscado) {
        System.out.println("\n--- Listado de " + rolBuscado + " ---");
        boolean encontrado = false;
        
        for (MiembroUniversidad miembro : miembros) {
            if (miembro.obtenerRol().equalsIgnoreCase(rolBuscado)) {
                System.out.println(miembro.obtenerInformacionCompleta());
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("No se encontraron miembros con el rol: " + rolBuscado);
        }
    }

     public String toString(){
        return super.toString() + "Nombre: " + nombre + ", Dirección: " + direccion + ", Total de Miembros: " + miembros.size();
}





//Parte 1: Implementación de Funciones Recursivas
//2.método recursivo para contar estudiantes por carrera

public static int contarEstudiantesRecursivo(Estudiante[] estudiantes, String carrera, int indice) {
    if (estudiantes == null || indice >= estudiantes.length) { //si el arreglo está vacío o llegamos al final
        return 0;
    }

    int contadorActual = 0;
    Estudiante e = estudiantes[indice];//el estudiante actual

    if (e != null && carrera != null && carrera.equalsIgnoreCase(e.getCarrera())) {
        contadorActual = 1; // Si no es nulo y la carrera coincide, contamos 1
    }

    // Sumamos el resultado actual con el del resto del arreglo
    return contadorActual + contarEstudiantesRecursivo(estudiantes, carrera, indice + 1);
}
/*  Recursivo: más elegante desde el punto de vista teórico,
    pero más dificil de leer y menos eficiente
    porque hace muchas llamadas a la pila.*/



// Metodo iterativo
//Cuenta estudiantes por carrera usando un bucle normal
public static int contarEstudiantesIterativo(Estudiante[] estudiantes, String carrera) {
    if (estudiantes == null) return 0;

    int total = 0;

    for (Estudiante e : estudiantes) {
        if (e != null && carrera != null && carrera.equalsIgnoreCase(e.getCarrera())) {
            total++;
        }
    }

    return total;
} 
//  Iterativo: más simple y directo, recomendado en casos reales con muchos datos.







//3.Crea una función recursiva para buscar un estudiante por documento en la universidad:

public static Estudiante buscarEstudianteRecursivo(Estudiante[] estudiantes, String documento, int indice) {    

    if (estudiantes == null || indice >= estudiantes.length) return null;   //Si el arreglo es nulo o se termina el arreglo, retorna null (no encontrado).
    
    Estudiante e = estudiantes[indice]; // Estudiante actual.
    
    if (e != null && documento != null && documento.equals(e.getDocumento())) return e; //Si el estudiante y el documento coinciden, retorna el estudiante.

    return buscarEstudianteRecursivo(estudiantes, documento, indice + 1);    // Paso Recursivo: Llama a la función para revisar el siguiente elemento (indice + 1).
}
/*Metodo recursivo: La función se llama a sí misma para avanzar, es lento y riesgoso con muchos datos. */


//Método Iterativo:
public static Estudiante buscarEstudianteIterativo(Estudiante[] estudiantes, String documento) {
    // Verificación inicial: Si el arreglo es nulo, retorna null.
    if (estudiantes == null) return null;
    
    // Bucle: Itera sobre cada estudiante 'e' en el arreglo 'estudiantes'.
    for (Estudiante e : estudiantes) { // Condición: Si el estudiante no es nulo y su documento coincide con el buscado.
        if (e != null && documento != null && documento.equals(e.getDocumento())) { //Retorna el estudiante encontrado.
            return e;
        }
    }
    return null;
}
/*Metodo iterativo: usa un bucle (for) para ir uno por uno, es rápido y seguro. */


}