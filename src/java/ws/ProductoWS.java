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
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.ProductoDAO;
import modelo.pojo.Mensaje;
import modelo.pojo.Producto;

/**
 * REST Web Service
 *
 * @author cr7_k
 */
@Path("productos")
public class ProductoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductoWS
     */
    public ProductoWS() {
    }

    @POST
    @Path("registrarProducto")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registroProducto(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Producto producto = gson.fromJson(json, Producto.class);
            
            if(producto != null){
                return ProductoDAO.registrarProducto(producto);
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
    
    @PUT
    @Path("editarProducto")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje modificionProducto(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Producto producto = gson.fromJson(json, Producto.class);
            
            if((producto.getIdProducto() == null || producto.getIdProducto() < 0) || (producto == null)){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }else{
                return ProductoDAO.modificarProducto(producto);
            }
        }
    }
    
    @GET
    @Path("obtenerProductos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> solicitarProductos(){
        
        return ProductoDAO.solicitarProductos();
    }
    
    
    @DELETE
    @Path("eliminarProducto")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje eliminarProcducto(String json){
        if(json.isEmpty()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }else{
            Gson gson = new Gson();
            Producto producto = gson.fromJson(json, Producto.class);
            
            if((producto.getIdProducto() == null || producto.getIdProducto() < 0) || (producto == null)){
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }else{
                return ProductoDAO.eliminarProducto(producto);
            }
        }
    }
}
