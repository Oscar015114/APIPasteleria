/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;
import modelo.pojo.Empleado;
import modelo.pojo.Mensaje;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Oscar
 */
public class AutenticacionDAO {
    public static Mensaje iniciarSesionEscritorio(
            String username, String contrasenia) {

        Mensaje mensaje = new Mensaje();
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
                    mensaje.setContenido("¡Hola " + empleado.getNombre() + "! bienvenido/a al sistema de la pasteleria.");
                    mensaje.setEmpleadoSesion(empleado);
                } else {
                    mensaje.setContenido("Usuario incorrecto y/o contraseña incorrectos, favor de verificar.");
                }
            } catch (Exception e) {
                mensaje.setContenido("Error: " + e.getMessage());
            } finally {
                conexionBD.close();
            }

        } else {
            mensaje.setContenido("Por el momento no hay conexion en la base de datos.");
        }

        return mensaje;
    }
}
