package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String dni;
	private String nombre;
	private String apellidos;
	private int sueldo;
	private int id;
	


	/**
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param double1
	 */
	public Empleado(String dni, String nombre, String apellidos, int sueldo ,int id ) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
		this.id = id ;
	}

	



	/**
	 * @return devuelve dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni cambia dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return devuelve nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre cambia nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return delvueve apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos cambia apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return devuelve sueldo
	 */
	public int getSueldo() {
		return sueldo;
	}

	/**
	 * @param sueldo cambia sueldo
	 */
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	/**
	 * @return devuelve id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param cambia id
	 */
	public void setId(int id) {
		this.id = id;
	}
	

		
		
	}


