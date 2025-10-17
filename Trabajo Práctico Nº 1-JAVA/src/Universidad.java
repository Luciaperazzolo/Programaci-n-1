import java.util.ArrayList; // Importa la clase ArrayList para usar listas dinámicas.
import java.util.List; // Importa la interfaz List.

public class Universidad { //Define la clase pública 'Universidad'.
    private String nombre; //Variable de instancia privada para almacenar el nombre de la universidad.
    private String direccion;
    private List<MiembroUniversidad> miembros; //Variable de instancia privada para almacenar una lista de miembros, tipada con la interfaz 'MiembroUniversidad'.

    public Universidad(String nombre, String direccion) { //Definimos el constructor de la clase Universidad que acepta el nombre y la dirección.
        this.nombre = nombre; //Asigna el valor del parámetro 'nombre' a la variable de instancia 'nombre'.
        this.direccion = direccion; //Asigna el valor del parámetro 'direccion' a la variable de instancia 'direccion'.
        this.miembros = new ArrayList<>(); //Inicializa la lista 'miembros' como un nuevo ArrayList vacío.
    }

    // Este método demuestra cómo se pueden procesar objetos diferentes, a través de una misma interfaz/clase base.
    public List<MiembroUniversidad> getMiembros(){ //Método getter para obtener la lista de miembros.
    return miembros; //Devuelve la lista de miembros.
    }

    public void agregarMiembro(MiembroUniversidad miembro){ //Método para añadir un objeto que implemente la interfaz 'MiembroUniversidad'.
        if (miembro != null) { //Verifica que el objeto 'miembro' no sea nulo.
            miembros.add(miembro); //Agrega el objeto a la lista de miembros.
            System.out.println(miembro.obtenerRol() + " " + ((Persona)miembro).getNombre() + " agregado a la universidad."); //Imprime un mensaje usando el rol y haciendo un casting a 'Persona' para obtener el nombre.
        }
    }

    public void listarTodosLosMiembros(){ //Método para imprimir la información de todos los miembros.
        System.out.println("\n--- Miembros de la Universidad " + this.nombre + " ---"); //Imprime un encabezado.
        if (miembros.isEmpty()) { //Comprueba si la lista de miembros está vacía.
            System.out.println("No hay miembros registrados."); //Imprime un mensaje si no hay miembros.
            return; //Termina la ejecución del método.
        }
        
        for (MiembroUniversidad miembro : miembros) { //Itera sobre cada miembro de la lista.
            // Usamos el método de la interfaz para obtener la información
            System.out.println("[" + miembro.obtenerRol() + "] " + miembro.obtenerInformacionCompleta()); //Imprime el rol y la información completa del miembro.
        }
    }

    public void listarMiembrosPorRol(String rolBuscado) { //Método para listar miembros filtrando por su rol.
        System.out.println("\n--- Listado de " + rolBuscado + " ---"); //Imprime un encabezado con el rol buscado.
        boolean encontrado = false; //Para saber si se encontró al menos un miembro.
        
        for (MiembroUniversidad miembro : miembros) { //Itera sobre cada miembro.
            if (miembro.obtenerRol().equalsIgnoreCase(rolBuscado)) { //Compara si el rol del miembro coincide (ignorando mayúsculas/minúsculas) con el buscado.
                System.out.println(miembro.obtenerInformacionCompleta()); //Si coincide, imprime su información completa.
                encontrado = true; 
            }
        }
        
        if (!encontrado) { //Si es falsa después de revisar toda la lista, imprime un mensaje de no encontrado.
            System.out.println("No se encontraron miembros con el rol: " + rolBuscado);
        }
    }

    public String toString(){ //Sobrescribe el método 'toString'.
        return super.toString() + "Nombre: " + nombre + ", Dirección: " + direccion + ", Total de Miembros: " + miembros.size(); //Devuelve una cadena con la información de la universidad y el total de miembros.
    }   

//Parte 1: Implementación de Funciones Recursivas
//Método recursivo para contar estudiantes por carrera
public static int contarEstudiantesRecursivo(Estudiante[] estudiantes, String carrera, int indice) { //Método estático recursivo para contar estudiantes en una carrera.
    if (estudiantes == null || indice >= estudiantes.length) { //Si el array es nulo o el índice excede la longitud, retorna 0.
        return 0;
    }

    int contadorActual = 0; //Inicializa un contador para el estudiante actual.
    Estudiante e = estudiantes[indice]; //Obtiene la referencia al estudiante en la posición actual.

    if (e != null && carrera != null && carrera.equalsIgnoreCase(e.getCarrera())) { //Comprueba si el estudiante no es nulo y la carrera coincide.
        contadorActual = 1; // Si no es nulo y la carrera coincide, contamos 1
    }

    //Sumamos el resultado actual con el del resto del arreglo
    return contadorActual + contarEstudiantesRecursivo(estudiantes, carrera, indice + 1); //Paso recursivo: suma 1 (si coincide) y el resultado de la llamada con el índice incrementado.
}
    /* Recursivo: más elegante desde el punto de vista teórico,
    pero más dificil de leer y menos eficiente
    porque hace muchas llamadas a la pila.*/

//Iterativo: más simple y directo, recomendado en casos reales con muchos datos.
//Cuenta estudiantes por carrera usando un bucle normal
public static int contarEstudiantesIterativo(Estudiante[] estudiantes, String carrera) { //Método estático iterativo para contar estudiantes.
    if (estudiantes == null) return 0; //Verificación inicial: si el array es nulo, retorna 0.

    int total = 0; //Inicializa el contador total.

    for (Estudiante e : estudiantes) { //Bucle que itera sobre cada estudiante.
        if (e != null && carrera != null && carrera.equalsIgnoreCase(e.getCarrera())) { //Comprueba si el estudiante y la carrera coinciden.
            total++; //Incrementa el contador si la condición se cumple.
        }
    }
    return total; //Devuelve el conteo total.
} 

/*Metodo recursivo: La función se llama a sí misma para avanzar, es lento y riesgoso con muchos datos.*/
//3.Crea una función recursiva para buscar un estudiante por documento en la universidad:
public static Estudiante buscarEstudianteRecursivo(Estudiante[] estudiantes, String documento, int indice) { //Método estático recursivo para buscar un estudiante por documento. 

    if (estudiantes == null || indice >= estudiantes.length) return null;   //Si array es nulo o se termina, retorna null (no encontrado).
    
    Estudiante e = estudiantes[indice]; // Estudiante actual.
    
    if (e != null && documento != null && documento.equals(e.getDocumento())) return e; //Si el estudiante y el documento coinciden, retorna el estudiante.

    return buscarEstudianteRecursivo(estudiantes, documento, indice + 1); //Paso Recursivo: Llama a la función para revisar el siguiente elemento (indice + 1).
}

//Método Iterativo:
/*Metodo iterativo: usa un bucle (for) para ir uno por uno, es rápido y seguro.*/
public static Estudiante buscarEstudianteIterativo(Estudiante[] estudiantes, String documento) { //Método estático iterativo para buscar estudiante.
    if (estudiantes == null) return null; //Verificación inicial: Si el arreglo es nulo, retorna null
    
    //Bucle: Itera sobre cada estudiante 'e' en el arreglo 'estudiantes'.
    for (Estudiante e : estudiantes) { 
        if (e != null && documento != null && documento.equals(e.getDocumento())) { //Condición: Si el estudiante no es nulo y su documento coincide con el buscado.
            return e; //Retorna el estudiante encontrado.
        }
    }
    return null; //Si el bucle termina sin encontrarlo, retorna null.
}

//Implementación del algoritmo de Búsqueda Binaria
public static int busquedaBinariaEstudiantes(Estudiante[] estudiantes, String apellido) { //Método estático de búsqueda binaria. Requiere que el array esté ORDENADO.
    if (estudiantes == null) return -1; //Verificación inicial: si el array es nulo, retorna -1.

    int inicio = 0; //Índice inicial de la búsqueda.
    int fin = estudiantes.length - 1; //Índice final de la búsqueda.

    while (inicio <= fin) { //Bucle de búsqueda: continúa mientras el índice inicial no supere al final.
        int medio = inicio + (fin - inicio) / 2; //Calcula el índice del medio. Previene desbordamiento en enteros grandes.
        // Comparamos el apellido buscado con el apellido del estudiante en el medio.
        int comparacion = apellido.compareTo(estudiantes[medio].getApellido()); //Compara alfabéticamente el apellido buscado con el del medio.

        if (comparacion == 0) { //Si la comparación es 0, los apellidos son iguales.
            return medio; //Encontrado, devuelve el índice.
        } else if (comparacion < 0) { //Si la comparación es menor que 0, el apellido buscado es alfabéticamente menor (está a la izquierda).
            fin = medio - 1; //Ajusta el índice final para buscar en la mitad izquierda.
        } else { //Si la comparación es mayor que 0, el apellido buscado es alfabéticamente mayor (está a la derecha).
            inicio = medio + 1; //Ajusta el índice inicial para buscar en la mitad derecha.
        }
    }
    return -1; //Si el bucle termina, el elemento no fue encontrado, retorna -1.
}


    //Implementación del algoritmo (Ordenamiento por Selección)
    //Ordena el array de estudiantes por Apellido (ascendente).
    public static Estudiante[] ordenarEstudiantesPorApellido(Estudiante[] estudiantes) { //Método estático que implementa el algoritmo de Ordenamiento por Selección.
        if (estudiantes == null || estudiantes.length <= 1) { //Si es nulo o tiene 0 o 1 elemento, ya está ordenado.
          return estudiantes; //Retorna el array sin cambios.
        }

        int n = estudiantes.length; //Almacena la longitud del array.

        // Bucle principal para la selección
        for (int i = 0; i < n - 1; i++) { //Itera desde el primer elemento hasta el penúltimo.
            int indiceMinimo = i; //Asume que el elemento actual (i) es el mínimo.
            // Bucle anidado para encontrar el elemento mínimo (apellido más bajo)
            for (int j = i + 1; j < n; j++) { //Itera sobre los elementos restantes (a la derecha de i).
             //Comparamos apellidos: < 0 significa que j es alfabéticamente menor que indiceMinimo
                if (estudiantes[j].getApellido().compareTo(estudiantes[indiceMinimo].getApellido()) < 0) { //Compara los apellidos. Si el de 'j' es menor.
                    indiceMinimo = j; //'j' se convierte en el nuevo índice mínimo.
                }  
            }

            // Intercambio de posiciones
            if (indiceMinimo != i) { //Si se encontró un elemento más pequeño que el actual.
                Estudiante temp = estudiantes[i]; //Guarda temporalmente el estudiante actual (en i).
                estudiantes[i] = estudiantes[indiceMinimo]; //Coloca el elemento mínimo en la posición actual (i).
                estudiantes[indiceMinimo] = temp; //Mueve el elemento original de 'i' a la posición donde estaba el mínimo.
            }
        }
        return estudiantes; //Devuelve el array de estudiantes ya ordenado.
    }
}