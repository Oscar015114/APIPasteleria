/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import modelo.pojo.Empleado;
import modelo.pojo.Mensaje;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Oscar
 */
public class EmpleadoDAO {

    public static Mensaje registrarEmpleado(
            String nombre, String apellidoPaterno, String apellidoMaterno,
            String username, String contrasenia, String fechaNacimiento, String sexo, Integer idRolEmpleado) {
        Mensaje msj = new Mensaje();
        msj.setError(Boolean.TRUE);

        SqlSession conexionDB = mybatis.MyBatisUtil.getSession();

        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellidoPaterno(apellidoPaterno);
        empleado.setApellidoMaterno(apellidoMaterno);
        empleado.setUsername(username);
        empleado.setContrasenia(contrasenia);
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setSexo(sexo);
        empleado.setIdRolEmpleado(idRolEmpleado);

        if (conexionDB != null) {
            try {
                List<Empleado> empleadosExiste = conexionDB.selectList("empleado.buscarRepetido", empleado);

                if (!empleadosExiste.isEmpty()) {
                    msj.setContenido("Ya existe un empleado con el mismo username");
                    return msj;
                }
                int filasAfectadas = conexionDB.insert("empleado.registrar");
                conexionDB.commit();

                if (filasAfectadas != 0) {
                    msj.setError(Boolean.FALSE);
                    msj.setContenido("Se registro el usuario correctamente");
                } else {
                    msj.setContenido("No se pudo registrar el usuario");
                }

            } catch (Exception e) {
                e.printStackTrace();
                msj.setContenido("Error de tipo: " + e);
            } finally {
                conexionDB.close();
            }
        }
        return msj;
    }

    public static Mensaje editarEmpleado(
            String nombre, String apellidoPaterno, String apellidoMaterno,
            String username, String contrasenia, String fechaNacimiento, String sexo, Integer idEmpleado) {
        Mensaje msj = new Mensaje();
        msj.setError(Boolean.TRUE);

        SqlSession conexionDB = mybatis.MyBatisUtil.getSession();

        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellidoPaterno(apellidoPaterno);
        empleado.setApellidoMaterno(apellidoMaterno);
        empleado.setUsername(username);
        empleado.setContrasenia(contrasenia);
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setSexo(sexo);
        empleado.setIdEmpleado(idEmpleado);

        if (conexionDB != null) {
            try {
                List<Empleado> empleadosExiste = conexionDB.selectList("empleado.buscarRepetido", empleado);

                if (!empleadosExiste.isEmpty()) {
                    msj.setContenido("Ya existe un empleado con el mismo username");
                    return msj;
                }
                int filasAfectadas = conexionDB.update("empleado.editar", empleado);
                conexionDB.commit();

                if (filasAfectadas != 0) {
                    msj.setError(Boolean.FALSE);
                    msj.setContenido("Se actualizo el usuario correctamente");
                } else {
                    msj.setContenido("No se pudo actualizar el usuario");
                }

            } catch (Exception e) {
                e.printStackTrace();
                msj.setContenido("Error de tipo: " + e);
            } finally {
                conexionDB.close();
            }
        }

        return msj;
    }

    public static Mensaje eliminarEmpleado(Integer idEmpleado) {
        Mensaje msj = new Mensaje();
        msj.setError(Boolean.TRUE);

        SqlSession conexionDB = mybatis.MyBatisUtil.getSession();

        if (conexionDB != null) {
            try {
                int filasAfectadas = conexionDB.delete("empleado.eliminar", idEmpleado);
                conexionDB.commit();

                if (filasAfectadas != 0) {
                    msj.setError(Boolean.FALSE);
                    msj.setContenido("El empleado se eliminó correctamente.");
                } else {
                    msj.setContenido("No se pudo eliminar el empleado.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                msj.setContenido("Error: " + e);
            } finally {
                conexionDB.close();
            }

        }
        return msj;
    }

}
