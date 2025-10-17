public class Persona {
    // Atributos privados
    private String nombre;
    private String apellido;
    private int edad;
    private String documento; // Nuevo atributo para el documento/DNI/identificación

    // Constructor con parámetros
    public Persona(String nombre, String apellido, int edad, String documento) {
        // Usamos los setters para aprovechar las posibles validaciones
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setDocumento(documento);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        // Reutilizamos la validación de nombre
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        // Reutilizamos la validación de apellido
        if (apellido != null && !apellido.isEmpty()) {
            this.apellido = apellido;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        // Reutilizamos la validación de edad
        if (edad > 16) {
            this.edad = edad;
        }
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        // Simple validación: no nulo ni vacío
        if (documento != null && !documento.isEmpty()) {
            this.documento = documento;
        }
    }

    //Muestra la información de los objetos de manera legible.
    public String toString(){
        return super.toString() + "Nombre: " + nombre + ", Apellido: " + apellido + "Edad: " + edad + ", Documento: " + documento;
    }


@Override //metodo equals para comparar dos objetos de la clase Persona
    public boolean equals(Object o) {
        
        if (this == o) return true;  // Comprobar si son el mismo objeto
        if (o == null || getClass() != o.getClass()) return false; // Comprobar si o es nulo o de una clase diferente
        
        // Convertir el objeto 'o' a 'Persona'
        Persona persona = (Persona) o;
        
        return java.util.Objects.equals(documento, persona.documento);
    }

@Override
    public int hashCode() {
        // Se utiliza Objects.hash para generar el código hash basado en 'documento'.
        return java.util.Objects.hash(documento);
    }
}