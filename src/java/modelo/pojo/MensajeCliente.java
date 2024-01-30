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
public class MensajeCliente {
    private boolean error;
    private String respuesta;
    private Cliente cliente;

    public MensajeCliente() {
    }

    public MensajeCliente(boolean error, String respuesta, Cliente cliente) {
        this.error = error;
        this.respuesta = respuesta;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
