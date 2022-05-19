package Persistencia;

import java.sql.SQLException;

import Empleados.Empleados;
import ejercicio1.Empleado;

public class PrincipalCSV {

	public static void main(String[] args) throws SQLException {
		Empleado p1 = new Empleado("123456789A","Antonio", "Rodríguez Antúnez", 1200,3);
		Empleado p2 = new Empleado("234567890B","Pedro", "Sánchez Guitiérrez", 1500,7);
		Empleado p3 = new Empleado("345678901C","Dolores", "Rubio Delgado", 1100,11);
		Empleado p4 = new Empleado("345678902D","Jose", "Felipez Delgado", 1100,11);
		
		
		EmpleadoDAOcsv csv = new EmpleadoDAOcsv();
		csv.insertar(p1);
		csv.insertar(p2);
		csv.insertar(p3);
		csv.insertar(p4);
		
		
	}

}
