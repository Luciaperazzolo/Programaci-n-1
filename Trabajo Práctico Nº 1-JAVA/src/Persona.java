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
}