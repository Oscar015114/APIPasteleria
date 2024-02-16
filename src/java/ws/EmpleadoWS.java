/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.EmpleadoDAO;
import modelo.pojo.Mensaje;
import utils.Constantes;

/**
 * REST Web Service
 *
 * @author Oscar
 */
@Path("empleados")
public class EmpleadoWS {

    @Context
    private UriInfo context;

    @POST
    @Path("registrarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registrarEmpleado(
            @FormParam("nombre") String nombre, @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno, @FormParam("username") String username,
            @FormParam("contrasenia") String contrasenia, @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("sexo") String sexo, @FormParam("idRolEmpleado") Integer idRolEmpleado) {
        Mensaje mensaje = null;

        if (nombre == null || nombre.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        if (apellidoPaterno == null || apellidoPaterno.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        if (apellidoMaterno == null || apellidoMaterno.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        if (username == null || username.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        if (contrasenia == null || contrasenia.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        if (fechaNacimiento == null || fechaNacimiento.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        if (sexo == null || sexo.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        if (idRolEmpleado == null || idRolEmpleado != Constantes.ID_ROL_COMERCIAL && idRolEmpleado != Constantes.ID_ROL_GENERAL) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        if (idRolEmpleado == Constantes.ID_ROL_GENERAL) {
            mensaje = EmpleadoDAO.registrarEmpleado(nombre, apellidoPaterno, apellidoMaterno, username, contrasenia, fechaNacimiento, sexo, idRolEmpleado);
        }

        mensaje = EmpleadoDAO.registrarEmpleado(nombre, apellidoPaterno, apellidoMaterno, username, contrasenia, fechaNacimiento, sexo, idRolEmpleado);

        return mensaje;
    }

    @PUT
    @Path("editarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje editarEmpleado(
            @FormParam("nombre") String nombre, @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno, @FormParam("username") String username,
            @FormParam("contrasenia") String contrasenia, @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("sexo") String sexo, @FormParam("idEmpleado") Integer idEmpleado) {

        if (idEmpleado == null || idEmpleado <= 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        if (nombre == null || nombre.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        if (apellidoPaterno == null || apellidoPaterno.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        if (apellidoMaterno == null || apellidoMaterno.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        if (username == null || username.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        if (contrasenia == null || contrasenia.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        if (fechaNacimiento == null || fechaNacimiento.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        if (sexo == null || sexo.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        Mensaje mensaje = EmpleadoDAO.editarEmpleado(nombre, apellidoPaterno, apellidoMaterno, username, contrasenia, fechaNacimiento, sexo, idEmpleado);

        return mensaje;
    }

    @DELETE
    @Path("eliminarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarEmpleado(@FormParam("idEmpleado") Integer idEmpleado) {

        if (idEmpleado == null || idEmpleado <= 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        Mensaje mensaje = EmpleadoDAO.eliminarEmpleado(idEmpleado);

        return mensaje;
    }

    @GET
    @Path("buscarEmpleados/{idEmpleado}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje buscarEmpleados(
            @PathParam("idEmpleado") Integer idEmpleado) {
     if(idEmpleado == null || idEmpleado <=0){
     throw new WebApplicationException(Response.Status.BAD_REQUEST);
     }
     return EmpleadoDAO.buscarEmpleados(idEmpleado);
    }
    
    @GET
    @Path("buscarRoles")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje buscarRoles(){
    return EmpleadoDAO.buscarRoles();
    }
}
