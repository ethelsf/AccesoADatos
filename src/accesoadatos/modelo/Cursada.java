
package accesoadatos.modelo;


public class Cursada {
    private Alumno alumno;
    private Materia materia;
    private int nota;
    private int idcursada;

    public Cursada(Alumno alumno, Materia materia, int nota, int idcursada) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.idcursada = idcursada;
    }
    
    
      public Cursada(Alumno alumno, Materia materia, int nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getIdcursada() {
        return idcursada;
    }

    public void setIdcursada(int idcursada) {
        this.idcursada = idcursada;
    }
    
    
    
}
