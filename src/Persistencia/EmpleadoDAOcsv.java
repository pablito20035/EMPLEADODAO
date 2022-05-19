package Persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Empleados.Empleados;
import ejercicio1.Empleado;

public class EmpleadoDAOcsv implements EmpleadoDAO {
	/**
	 * atributos estaticos y que no cambian
	 * 
	 */
	final static String SEPARADOR = ",";
	final static String COMILLAS = "\"";
	private List<Empleado> empleados = new ArrayList<>();
	
	/**
	 * @return
	 * DEVUELVE LA LISTA DE EMPLEADOS
	 */
	public List<Empleado> getEmpleados() {
		Scanner sc1 = null;
		String url = "C:\\Users\\pablo jimenez\\eclipse-workspace\\practica\\src\\Persistencia\\archivo.csv";
		try {
			sc1 = new Scanner( new File(url) );
			
			while (sc1.hasNextLine()) {
				String linea = sc1.nextLine();
				String[] separacionLineas = linea.split(",");
				Empleado emp = new Empleado(separacionLineas[0], separacionLineas[1], separacionLineas[2], Integer.valueOf(separacionLineas[3]), Integer.valueOf(separacionLineas[4]));
				empleados.add(emp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sc1 != null)
				sc1.close();			
		}
		return empleados;
	}
	
	
	/**
	 * @param empleado
	 * @return
	 * @throws SQLException
	 * insertar valor en el csv
	 */



	@Override
	public boolean insertar(Empleado empleado) throws SQLException {
		String dni = empleado.getDni();
		String nombre = empleado.getNombre();
		String apellidos = empleado.getApellidos();
		int sueldo = empleado.getSueldo();
		int id = empleado.getId();
		
		String[] lineas = { dni+SEPARADOR, nombre+SEPARADOR, apellidos+SEPARADOR,Integer.toString(sueldo)+SEPARADOR , Integer.toString(id) };
		String url = "C:\\Users\\pablo jimenez\\eclipse-workspace\\practica\\src\\Persistencia\\archivo.csv";
		FileWriter csv = null;
		try {
			csv = new FileWriter(url,true);
			
			for(String linea : lineas) {
				csv.write(linea);
			}
			csv.write("\n");
			csv.close();
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepcion: " + ex.getMessage());
		}
		return false;
	}


		
	

	@Override
	public boolean borrar(String Dni) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean modificarSueldo(String dni, int sueldo) {
		// TODO Auto-generated method stub
		return false;
	}
}


	
	

	






