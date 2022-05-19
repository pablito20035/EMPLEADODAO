package Empleados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ejercicio1.Empleado;
import Persistencia.*;


public class GestionEmpleado {

	/**
	 * atributo
	 */
	private static ArrayList<Empleado> empleados= new ArrayList<>();
	private static EmpleadoDAO dao;


	public GestionEmpleado(String opcion) {
		super();
		if(opcion.equals("BD")) {
			dao= new EmpleadoDAOBD();
		}
		else {
			dao= new EmpleadoDAOcsv();
		}
			
	}


	/**
	 * @param dni
	 * @return
	 * @throws SQLException
	 * DEVUELVE LA LISTA DE EMPLEADOS
	 */
	
	public static ArrayList<Empleado> getEmpleadoLista() throws SQLException{
		dao.getEmpleados();
		return empleados;
		
		
		
	}
	public Empleado getEmpleado(String dni) throws SQLException {
		Iterator<Empleado> it = empleados.iterator();
		while (it.hasNext()) {
			if (it.next().getDni().equals(dni)) {
				return it.next();

			}
		}
		return null;
	}


       /**
     * @param empleado
     * @return
     * @throws SQLException
     * insertar a un objeto en la lista
     */
    public  boolean insertarValor(Empleado empleado) throws SQLException {
		empleados.add(empleado);
		dao.insertar(empleado);
		return true;
	}

	/**
	 * @param dni
	 * @return
	 * @throws SQLException
	 * BORR el empleado de la lista
	 */
	public  boolean borrarEmpleado(String dni) throws SQLException {
		Iterator<Empleado> it = empleados.iterator();
		while (it.hasNext()) {
			if (it.next().getDni().equals(dni)) {
				it.remove();
			}
			dao.borrar(dni);

		}

		return true;
	}

	
	/**
	 * @param dni
	 * @param sueldo
	 * @return POR PARAMETRO DEL DNI CAMBIAMOS EL SUELDO
	 */
	public  boolean modificarSueldo(String dni, int sueldo) {
		Iterator<Empleado> it = empleados.iterator();
		while (it.hasNext()) {
			if (it.next().getDni().equals(dni)) {
				it.next().setSueldo(sueldo);
			}
			dao.modificarSueldo(dni, sueldo);

		}

		return true;
	}
}


