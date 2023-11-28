
package com.mycompany.lab010pooi2312051;

public class Medico {
    private int numeroColegiatura;
    private String nombre;
    private String especialidad;

    public Medico(int numeroColegiatura, String nombre, String especialidad) {
        this.numeroColegiatura = numeroColegiatura;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getNumeroColegiatura() {
        return numeroColegiatura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    // Setters
    public void setNumeroColegiatura(int numeroColegiatura) {
        this.numeroColegiatura = numeroColegiatura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}