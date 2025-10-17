public class Personal extends Persona implements MiembroUniversidad{
    private String departamento;
    private String puestos;
    private String fechaIngreso;

 public Personal ( String nombre, String apellido, int edad, String documento , String departamento , String puestos , String fechaIngreso){
    super(nombre,apellido,edad,documento);
    setDepartamento(departamento);
    setPuestos(puestos);
    setFechaIngreso(fechaIngreso);
 }   

public String getDepartamento(){
    return departamento;
}

public void setDepartamento(String departamento){
    this.departamento = departamento;
}

public String getPuestos(){
    return puestos;
}

public void setPuestos(String puestos){
    this.puestos = puestos;
}

public String getFechaIngreso(){
    return fechaIngreso;
}

public void setFechaIngreso(String fechaIngreso){
    this.fechaIngreso = fechaIngreso;
}


//Implementación de los métodos de la interfaz MiembroUniversidad
    @Override
    public String obtenerRol() {
        return "Personal";
    }

    @Override
    public String obtenerInformacionCompleta() {
        // Reutilizamos el método toString() para la información completa
        return this.toString();
    }

    
//Método toString, Muestra la información de los objetos de manera legible.
    public String toString() {
    return "Nombre: " + getNombre() + ", " +
           "Apellido: " + getApellido() + ", " +
           "Edad: " + getEdad() + ", " +
           "Documento: " + getDocumento() + ", " +
           "Departamento: " + departamento + ", " +
           "Puesto: " + puestos + ", " +
           "Fecha Ingreso: " + fechaIngreso;
}




}
