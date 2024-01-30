/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.AutenticacionDAO;
import modelo.pojo.Cliente;
import modelo.pojo.MensajeCliente;
import modelo.pojo.MensajeEmpleado;

/**
 * REST Web Service
 *
 * @author Oscar
 */
@Path("autenticacion")
public class AutenticacionWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AutenticacionWS
     */
    public AutenticacionWS() {
    }

    /**
     * Retrieves representation of an instance of ws.AutenticacionWS
     * @return an instance of java.lang.String
     */
    @POST
    @Path("iniciarSesionEscritorio")
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeEmpleado iniciarSesionEscritorio(
            @FormParam("username") String username,
            @FormParam("contrasenia") String contrasenia) {

        if (!username.isEmpty() && !contrasenia.isEmpty()) {
            return AutenticacionDAO.iniciarSesionEscritorio(username, contrasenia);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
    
    @POST
    @Path("iniciarSesionMovil")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MensajeCliente iniciarSesionMovil(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Cliente cliente = gson.fromJson(json, Cliente.class);
            
            if(cliente.getCorreo() == null || cliente.getCorreo().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            if(cliente.getContrasenia() == null || cliente.getContrasenia().isEmpty()){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            
            return AutenticacionDAO.iniciarSesionMovil(cliente);
        }
    }
}
