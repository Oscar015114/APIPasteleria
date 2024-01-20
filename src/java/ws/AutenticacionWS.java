/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

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
import modelo.pojo.Mensaje;

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
    public Mensaje iniciarSesionEscritorio(
            @FormParam("username") String username,
            @FormParam("contrasenia") String contrasenia) {

        Mensaje mensaje = new Mensaje();
        if (!username.isEmpty() && !contrasenia.isEmpty()) {
            mensaje = AutenticacionDAO.iniciarSesionEscritorio(username, contrasenia);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        return mensaje;
    }
}
