package Empleados;

import java.sql.SQLException;

import Persistencia.EmpleadoDAOBD;
import ejercicio1.Empleado;
import Persistencia.ConectarBD;


public class Principal {

	public static void main(String[] args) throws SQLException {
		ConectarBD.conectarBD();
		Empleado p1= new Empleado("123456789A","Antonio"," Rodríguez Antúnez",1200,20);
		Empleado p2= new Empleado("234567890B","Pedro","Sánchez Gutiérrez",1500,5);
		Empleado p3= new Empleado("345678901W","Dolores","Rubio Delgado",1100,6);
		Empleado p4= new Empleado("456789012D","Juan","Pérez García",1800,7);
		

		
		GestionEmpleado ge = new GestionEmpleado("BD");
		GestionEmpleado g2 = new GestionEmpleado("csv");

		ge.insertarValor(p1);
		ge.insertarValor(p2);
		ge.insertarValor(p3);
		ge.insertarValor(p4);

		
		g2.insertarValor(p1);
		g2.insertarValor(p2);
		g2.insertarValor(p3);
		g2.insertarValor(p4);
		
		System.out.println(ge.getEmpleadoLista());
	}

}
