/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.ClienteDAO;
import modelo.pojo.Cliente;
import modelo.pojo.Mensaje;

/**
 * REST Web Service
 *
 * @author cr7_k
 */
@Path("clientes")
public class ClientesWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientesWS
     */
    public ClientesWS() {
    }

    /**
     * Retrieves representation of an instance of ws.ClientesWS
     * @return an instance of java.lang.String
     */
    
    @POST
    @Path("registrarCliente")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarCliente(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Cliente cliente = gson.fromJson(json, Cliente.class);
            
            if(cliente.getNombre() == null || cliente.getNombre().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getApellidoPaterno() == null || cliente.getApellidoPaterno().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getApellidoMaterno() == null || cliente.getApellidoMaterno().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getCorreo() == null || cliente.getCorreo().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getContrasenia() == null || cliente.getContrasenia().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getCalle() == null || cliente.getCalle().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getNumero() == null || cliente.getNumero() < 0 ){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getTelefono() == null || cliente.getTelefono().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            
            return ClienteDAO.registrarCliente(cliente);
        }
    }
    
    @PUT
    @Path("editarCliente")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarCliente(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Cliente cliente = gson.fromJson(json, Cliente.class);
            
            if(cliente.getIdCliente() == null )
            
            if(cliente.getNombre() == null || cliente.getNombre().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getApellidoPaterno() == null || cliente.getApellidoPaterno().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getApellidoMaterno() == null || cliente.getApellidoMaterno().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getCorreo() == null || cliente.getCorreo().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getContrasenia() == null || cliente.getContrasenia().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getCalle() == null || cliente.getCalle().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getNumero() == null || cliente.getNumero() < 0 ){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getTelefono() == null || cliente.getTelefono().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            
            return ClienteDAO.modificarCliente(cliente);
        }
    }
    
    @DELETE
    @Path("eliminarCliente")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje eliminarCliente(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Cliente cliente = gson.fromJson(json, Cliente.class);
            
            if(cliente.getIdCliente() == null || cliente.getIdCliente() < 0){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            
            return ClienteDAO.eliminarCliente(cliente);
        }
    }
    
}
