/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

/**
 *
 * @author cr7_k
 */
public class Producto {
    private Integer idProducto;
    private String nombreProducto;
    private String fechaCreacion;
    private String fechaCaducidad;

    public Producto() {
    }

    public Producto(Integer idProducto, String nombreProducto, String fechaCreacion, String fechaCaducidad) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.fechaCreacion = fechaCreacion;
        this.fechaCaducidad = fechaCaducidad;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
        
}
