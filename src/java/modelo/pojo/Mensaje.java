/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

/**
 *
 * @author Oscar
 */
public class Mensaje {
    private Boolean error;
    private String contenido;
    private Empleado empleadoSesion;

    public Mensaje() {
    }

    public Mensaje(Boolean error, String contenido, Empleado empleadoSesion) {
        this.error = error;
        this.contenido = contenido;
        this.empleadoSesion = empleadoSesion;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Empleado getEmpleadoSesion() {
        return empleadoSesion;
    }

    public void setEmpleadoSesion(Empleado empleadoSesion) {
        this.empleadoSesion = empleadoSesion;
    }
    
    
}
