/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.pojo.Cliente;
import modelo.pojo.Mensaje;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cr7_k
 */
public class ClienteDAO {
    
    public static Mensaje registrarCliente(Cliente cliente){
        Mensaje respuesta = new Mensaje();
        respuesta.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                int filasAfectadas = conexionBD.insert("cliente.registrarCliente", cliente);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    respuesta.setError(false);
                    respuesta.setContenido("Registro exitoso");
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
    
    public static Mensaje modificarCliente(Cliente cliente){
        Mensaje respuesta = new Mensaje();
        respuesta.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                int filasAfectadas = conexionBD.update("cliente.editarCliente", cliente);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    respuesta.setError(false);
                    respuesta.setContenido("Modificacion exitosa");
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
    
    public static Mensaje eliminarCliente(Cliente cliente){
        Mensaje respuesta = new Mensaje();
        respuesta.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                int filasAfectadas = conexionBD.delete("cliente.eliminarCliente", cliente);
                conexionBD.commit();
                
                if(filasAfectadas > 0){
                    respuesta.setError(false);
                    respuesta.setContenido("Eliminacion exitosa");
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
