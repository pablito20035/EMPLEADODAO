package Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Empleados {
	private static Connection conexion;
	private String dni;
	private String nombre;
	private String apellidos;
	private int sueldo;
	private int id;
	

	/**
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param sueldo
	 * @param id
	 * CONSTRUCTOR DE EMPLEADOS
	 */
	public Empleados(String dni, String nombre, String apellidos, int sueldo, int id) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
		this.id = id;
	}

	/**
	 * @param consulta
	 * @return 
	 * CONSULTA EN LA BASE DE DATOS
	 */
	public  ResultSet consultar(String consulta) {
		ResultSet rs;
		try {
			PreparedStatement sr = conexion.prepareStatement(consulta);
			rs = sr.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	/**
	 * @param cambio
	 * @return
	 * ejecuta la consulta
	 */
	public boolean ejecutar(String cambio) {
		try {
			PreparedStatement sr = conexion.prepareStatement(cambio);
			int totalRows = sr.executeUpdate(); // devuelve el número de tuplas modificadas
			System.out.println("Se han modificado: " + totalRows + " tuplas");
			sr.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param o
	 * @return
	 * @throws SQLException
	 * DEVOLVER LA LISTA DE EMPLEADOS
	 */
	public  List<Empleados> getEmpleados(ResultSet o) throws SQLException {
			System.out.println("\nDNI\tNOMBRE\tAPELLIDOS\tSUELDO\tID");
			System.out.println("--------------------------------");
				ArrayList<Empleados> AL= new ArrayList<Empleados>();
			while (o.next()) {
						String dni=o.getString("dni");
						String nombre= o.getString("nombre");
						String apellidos= o.getString("apellidos");
						int sueldo=  o.getInt("sueldo");
						int id= o.getInt("id");
						
						Empleados p1=new Empleados(dni,nombre,apellidos,sueldo,id);
						AL.add(p1);
						
			}
			return AL;
	}
	
	/**
	 * @param empleado
	 * @return
	 * @throws SQLException
	 * insertamos empleado
	 */
	public  boolean insertar(Empleados empleado) throws SQLException {
			int or= conexion.prepareStatement("INSERT INTO empleados values("+empleado.dni+empleado.nombre+empleado.apellidos+empleado.sueldo
				+empleado.id+")").executeUpdate();
		if(or!=0) {
			return true;
		}
		else {
			return false;
		}

	}
	
	/**
	 * @param dni
	 * @return
	 * buscamos por el parametro dni
	 */
	public Empleados buscarDni(String dni) {
		try {
			ResultSet rs = conexion.prepareStatement("SELECT dni FROM empleados").executeQuery();
			while(rs.next()) {
				if(dni.equals(rs.getString("dni"))) {
					System.out.println("\nDNI\tNOMBRE\tAPELLIDOS\tSUELDO\tID");
					System.out.println("--------------------------------");
					String dni2=rs.getString("dni");
					String nombre= rs.getString("nombre");
					String apellidos= rs.getString("apellidos");
					int sueldo=  rs.getInt("sueldo");
					int id= rs.getInt("id");
					
					Empleados p1=new Empleados(dni2,nombre,apellidos,sueldo,id);
					
					return p1;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param dni
	 * @return
	 * borramos a traves del dni
	 */
	public boolean borrar(String dni) {
		try {
			PreparedStatement ol = conexion.prepareStatement("DELETE FROM empleados WHERE DNI='" + dni + "'");
			int o = ol.executeUpdate();
			if (o == 0) {
				return false;
			} else {
				return true;
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(String dni, int sueldo) {
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