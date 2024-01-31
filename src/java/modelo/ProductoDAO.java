/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.pojo.Mensaje;
import modelo.pojo.Producto;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cr7_k
 */
public class ProductoDAO {
    
    public static Mensaje registrarProducto(Producto producto){
        Mensaje respuesta = new Mensaje();
        respuesta.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                int filasAfectadas = conexionBD.insert("producto.registroProducto", producto);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    respuesta.setError(false);
                    respuesta.setContenido("Registro éxitoso");
                }else{
                    respuesta.setContenido("Error al registrar");
                }
                
            }catch(Exception e){
                respuesta.setContenido("Error: " + e.getMessage());
            }finally{
                conexionBD.close();
            }
        }else{
            respuesta.setContenido("Error: Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde");
        }
        return respuesta;
    }
    
    public static Mensaje modificarProducto(Producto producto){
        Mensaje respuesta = new Mensaje();
        respuesta.setError(false);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                int filasAfectadas = conexionBD.update("producto.editarProducto", producto);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    respuesta.setError(false);
                    respuesta.setContenido("Modificación exitosa");
                }else{
                    respuesta.setContenido("Error al modificar");
                }
                
            }catch(Exception e){
                respuesta.setContenido("Error: " + e.getMessage());
            }finally{
                conexionBD.close();
            }
        }else{
            respuesta.setContenido("Error: Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde");
        }
        
        return respuesta;
    }
    
    
    public static List<Producto> solicitarProductos(){
        List<Producto> productos = new ArrayList<>();
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                productos = conexionBD.selectList("producto.obtenerProductos");
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexionBD.close();
            }
        }
        
        return productos;
    }
    
    public static Mensaje eliminarProducto(Producto producto){
        Mensaje respuesta = new Mensaje();
        SqlSession conexionBD = MyBatisUtil.getSession();
        respuesta.setError(true);
        if(conexionBD != null){
            try{
                int filasAfectadas = conexionBD.delete("producto.eliminarProducto", producto);
                conexionBD.commit();
                if(filasAfectadas > 0){
                    respuesta.setError(false);
                    respuesta.setContenido("Eliminación exitosa");
                }else{
                    respuesta.setContenido("Error al eliminar");
                }
            }catch(Exception e){
                respuesta.setContenido("Error: " + e.getMessage());
            }finally{
                conexionBD.close();
            }
        }else{
            respuesta.setContenido("Error: Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde");
        }
        
        return respuesta;
    }
}