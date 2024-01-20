/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

import java.util.List;

/**
 *
 * @author Oscar
 */
public class Mensaje {
    private Boolean error;
    private String contenido;
    private Empleado empleadoSesion;
    private List<Empleado> empleados;

    public Mensaje() {
    }

    public Mensaje(Boolean error, String contenido, Empleado empleadoSesion, List<Empleado> empleados) {
        this.error = error;
        this.contenido = contenido;
        this.empleadoSesion = empleadoSesion;
        this.empleados = empleados;
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

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    
}
