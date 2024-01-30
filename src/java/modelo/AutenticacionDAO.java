/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;
import modelo.pojo.Cliente;
import modelo.pojo.Empleado;
import modelo.pojo.MensajeCliente;
import modelo.pojo.MensajeEmpleado;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Oscar
 */
public class AutenticacionDAO {
    
    public static MensajeEmpleado iniciarSesionEscritorio(String username, String contrasenia) {
        MensajeEmpleado mensaje = new MensajeEmpleado();
        mensaje.setError(true);

        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                HashMap<String, String> parametros = new HashMap<>();
                parametros.put("username", username);
                parametros.put("contrasenia", contrasenia);

                Empleado empleado = conexionBD.selectOne("autenticacion.loginEscritorio", parametros);

                if (empleado != null) {
                    mensaje.setError(false);
                    mensaje.setRespuesta("¡Hola " + empleado.getNombre() + "! bienvenido/a al sistema de la pasteleria.");
                    mensaje.setEmpleado(empleado);
                } else {
                    mensaje.setRespuesta("Usuario incorrecto y/o contraseña incorrectos, favor de verificar.");
                }
            } catch (Exception e) {
                mensaje.setRespuesta("Error: " + e.getMessage());
            } finally {
                conexionBD.close();
            }

        } else {
            mensaje.setRespuesta("Error: Por el momento no hay conexion en la base de datos, favor de intentarlo mas tarde.");
        }

        return mensaje;
    }

    public static MensajeCliente iniciarSesionMovil(Cliente cliente) {
        MensajeCliente mensaje = new MensajeCliente();
        mensaje.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if(conexionBD != null){
            try{
                
                mensaje.setCliente(conexionBD.selectOne("autenticacion.loginMovil", cliente));
                
                if(mensaje.getCliente() != null){
                    mensaje.setError(false);
                    mensaje.setRespuesta("¡Hola " + mensaje.getCliente().getNombre() + "! bienvenido/a a la app.");
                }else{
                    mensaje.setRespuesta("Correo y/o contraseña incorrectos, favor de verificar.");
                }
            }catch(Exception e){
                mensaje.setRespuesta("Error: " + e.getMessage());
            }finally{
                conexionBD.close();
            }
        }else{
            mensaje.setRespuesta("Error: Por el momento no hay conexion con la base de datos, favor de intentarlo mas tarde.");
        }
        
        return mensaje;
    }
    
    
}
