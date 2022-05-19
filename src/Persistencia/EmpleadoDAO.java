package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicio1.Empleado;

public interface EmpleadoDAO{

	/**
	 * @param empleado
	 * @return
	 * @throws SQLException
	 * INSERTAMOS UNA PERSONA A LA BASE DE DATOS
	 */
	public  boolean insertar(Empleado empleado) throws SQLException;
	/**
	 * @param dni
	 * @return
	 * BORRAMOS UN EMPLEADO D LA BASE DE DATOS
	 * @throws SQLException 
	 */
	public  boolean borrar(String Dni) throws SQLException ;
	
	/**
	 * @param dni
	 * @param sueldo
	 * @return MODIFICA EL SUELDO
	 */
	public  boolean modificarSueldo(String dni, int sueldo) ;

	/**
	 * @return
	 * @throws SQLException
	 * DEVUELVE LA LISTA DE EMPLEADOS
	 */
	public List<Empleado> getEmpleados() throws SQLException;

	}



