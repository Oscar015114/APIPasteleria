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
public class MensajeEmpleado {
    private boolean error;
    private String respuesta;
    private Empleado empleado;

    public MensajeEmpleado() {
    }

    public MensajeEmpleado(boolean error, String respuesta, Empleado empleado) {
        this.error = error;
        this.respuesta = respuesta;
        this.empleado = empleado;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
   
}
