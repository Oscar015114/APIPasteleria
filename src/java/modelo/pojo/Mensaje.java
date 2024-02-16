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
    private List<Empleado> empleados;
    private List<Rol> roles;
    
    public Mensaje() {
    }

    public Mensaje(Boolean error, String contenido, List<Empleado> empleados, List<Rol> roles) {
        this.error = error;
        this.contenido = contenido;
        this.empleados = empleados;
        this.roles = roles;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
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
}
