import java.util.Objects; // Necesario para la implementación de equals y hashCode
public class Materia {
    private String nombre; //Variable de instancia privada para almacenar el nombre de la materia.
    private String codigo;
    private int creditos;
    private double calificacion; //Variable de instancia privada para almacenar la calificación obtenida en la materia.
    private Profesor profesor;

    public Materia(String nombre, String codigo, int creditos, double calificacion) { //Define el constructor de la clase Materia que recibe cuatro parámetros.
        this.nombre = nombre; //Asigna el valor del parámetro 'nombre' a la variable de instancia 'nombre'.
        this.codigo = codigo;
        this.creditos = creditos;
        this.calificacion = calificacion;
    }

    public String getNombre() { //Definimos el método getter público para obtener el nombre.
        return nombre; //Devuelve el valor de la variable de instancia 'nombre'.
    }
    public String getCodigo() { 
        return codigo; 
    }
    public int getCreditos() { 
        return creditos; 
    }
    public double getCalificacion() { 
        return calificacion; 
    }

    public void setNombre(String nombre) { //Definimos el método setter público para establecer el nombre.
        this.nombre = nombre; //Asigna el valor del parámetro a la variable de instancia 'nombre'.
    }
    public void setCodigo(String codigo) { 
        this.codigo = codigo; 
    }
    public void setCreditos(int creditos) { 
        this.creditos = creditos; 
    }
    public void setCalificacion(double calificacion) { 
        this.calificacion = calificacion; 
    }

    public Profesor getProfesor(){
        return profesor;
    }

    public void setProfesor(Profesor profesor){
        this.profesor = profesor;
    }

    public String toString(){
        return super.toString() + "Nombre: " + nombre + ", Código: " + codigo + "Créditos: " + creditos + ", Calificación: " + calificacion + ", Profesor: " + profesor;
    }

@Override  //metodo equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Materia materia = (Materia) o;
        
        // Comparamos el atributo único 'codigo'
        return Objects.equals(codigo, materia.codigo);
    }

    //Método hashCode
    @Override
    public int hashCode() {
        // Se genera el hash basado en 'codigo'.
        return Objects.hash(codigo);
    }
}
