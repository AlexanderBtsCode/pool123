
package com.mycompany.lab010pooi2312051;

public class Paciente {
    private String DNI;
    private String nombre;
    private String apellido;
    private String direccion;
    private double peso;
    private double temperatura;

    // Constructor
    public Paciente(String DNI, String nombre, String direccion, double peso, double temperatura) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.peso = peso;
        this.temperatura = temperatura;
    }

    // Getters
    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getPeso() {
        return peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    // Setters
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}