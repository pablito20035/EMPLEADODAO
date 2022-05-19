package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import Empleados.Empleados;
import ejercicio1.Empleado;

public class EmpleadoDAOBD implements EmpleadoDAO {
	public static Connection conexion = ConectarBD.conectarBD();

	/**
	 * @return
	 * @throws SQLException
	 * DEVUELVE LA LISTA DE EMPLEADOS
	 */
	public List<Empleado> getEmpleados() throws SQLException {
		ResultSet resultado = conexion.prepareStatement("SELECT * FROM empleados").executeQuery();

		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		while (resultado.next()) {
			String dni = resultado.getString("dni");
			String nombre = resultado.getString("nombre");
			String apellidos = resultado.getString("apellidos");
			int sueldo = resultado.getInt("sueldo");
			int id = resultado.getInt("id");

			Empleado p1 = new Empleado(dni,nombre,apellidos,sueldo,id);
			lista.add(p1);

		}
		return lista;
	}

	/**
	 * @param p1
	 * @return INSERTA EMPLEADOS
	 * @throws SQLException
	 */
	public boolean insertar(Empleado p1) throws SQLException {
		PreparedStatement ol = conexion
				.prepareStatement("INSERT INTO empleados(DNI,NOMBRE,APELLIDO,SUELDO) values(?,?,?,?)");
		ol.setString(1, p1.getDni());
		ol.setString(2, p1.getNombre());
		ol.setString(3, p1.getApellidos());
		ol.setInt(4, p1.getSueldo());
		int o = ol.executeUpdate();
		if (o == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param dni
	 * @throws SQLException HACE UNA CONSULTA A TRAVES DEL DNI
	 */
	public  void buscar(int dni) throws SQLException {
		ResultSet rs = conexion.prepareStatement("SELECT * FROM empleados WHERE DNI='" + dni + "'").executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString("NOMBRE"));
			System.out.println();
		}
	}
	/**
	 * @param Dni
	 * @return BORRA UN EMPLEADO DE LA BASE DE DATOS
	 * @throws SQLException
	 */
	public  boolean borrar(String Dni) throws SQLException {
		PreparedStatement ol = conexion.prepareStatement("DELETE FROM empleados WHERE DNI='" + Dni + "'");
		int o = ol.executeUpdate();
		if (o == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param dni
	 * @param sueldo
	 * @return
	 * MODIFICA EL SUELDO
	 */
	public boolean modificarSueldo(String dni, int sueldo) {
		try {
			PreparedStatement rs = conexion.prepareStatement("UPDATE empleados set sueldo=? where dni=?");
			rs.setInt(1, sueldo);
			rs.setString(2, dni);
		    rs.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
