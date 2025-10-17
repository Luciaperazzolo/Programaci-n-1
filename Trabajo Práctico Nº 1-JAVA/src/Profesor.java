public class Profesor extends Persona implements MiembroUniversidad{
    private String especialidad;
    private int añosExperiencia;
    private Materia[] materiasAsignadas = new Materia[5]; 
    private int cantidadMaterias = 0;

    public Profesor(String nombre, String apellido, int edad, String documento, String especialidad, int añosExperiencia) {
        // Llama al constructor de la clase base Persona
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
    }

    public String getEspecialidad(){
        return especialidad;
    }
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    public int getAñosExperiencia(){
        return añosExperiencia;
    }
    public void setAñosExperiencia(int añosExperiencia){
        this.añosExperiencia = añosExperiencia;
    }


    // Método específico para asignar una materia
    public void asignarMateria(Materia materia) {
        if (cantidadMaterias < materiasAsignadas.length) {
            materiasAsignadas[cantidadMaterias++] = materia; 
        } else {
            System.out.println("El profesor " + getNombre() + " ya tiene el máximo de materias asignadas.");
        }
    }

    //Implementación de los métodos de la interfaz MiembroUniversidad
    @Override
    public String obtenerRol() {
        return "Profesor";
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
           "Especialidad: " + especialidad + ", " +
           "Años Experiencia: " + añosExperiencia  ;
}

    
}


