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
public class Rol {
    private Integer idRolEmpleado;
    private String rol;

    public Rol() {
    }

    public Rol(Integer idRolEmpleado, String rol) {
        this.idRolEmpleado = idRolEmpleado;
        this.rol = rol;
    }

    public Integer getIdRolEmpleado() {
        return idRolEmpleado;
    }

    public void setIdRolEmpleado(Integer idRolEmpleado) {
        this.idRolEmpleado = idRolEmpleado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
