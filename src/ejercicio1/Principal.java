package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	private static Connection conexion;

	public static void main(String[] args) throws SQLException {
		Empleado pepe = new Empleado("657", "pepe", "lopez", 2500,5);
		Empleado antonio = new Empleado("898","antonio","muñoz",1500,8);
		conectarBD();
		insertar(pepe);
		buscar(898);
		borrar(657);
		
		
		
	
		
		

	}

	/**
	 * conecta a la base de datos 
	 */
	public static void conectarBD() {
		String host = "localhost";
		int puerto = 3306;
		String db = "empresa";
		String url = "jdbc:mysql://" + host + ":" + puerto + "/" + db;
		String login = "root";
		String password = "";

		try {
			// Conectamos con la base de datos
			conexion = DriverManager.getConnection(url, login, password);
			System.out.println((conexion != null) ? "CONEXION OK" : "CONEXION FALLIDA");
			
			  if (conexion != null) { System.out.println("CONEXION OK"); }else {
			  System.out.println("CONEXION FALLIDA"); }
			 

		} catch (java.sql.SQLException sqle) {
			System.out.println("Error: " + sqle);
		}
		

	}
	/**
	 * @param consulta
	 * @return consulta en la base de datos y la devuelve
	 */
	public static ResultSet consultar(String consulta) {
		ResultSet resultado;
		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			resultado = sentencia.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return resultado;
	}
	/**
	 * @param cambio
	 * @return ejecuta la cnsulta
	 */
	public boolean ejecutar(String cambio) {
		try {
			PreparedStatement sentencia = conexion.prepareStatement(cambio);
			int totalRows = sentencia.executeUpdate(); // devuelve el número de tuplas modificadas
			System.out.println("Se han modificado: " + totalRows + " tuplas");
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * @param resultado imrpime el resultado
	 */
	public void imprimirResultado(ResultSet resultado) {
		try {
			System.out.println("\nNOMBRE\tID");
			System.out.println("--------------------------------");
			while (resultado.next()) {
				System.out.println(resultado.getString("nombre")+ "\t" +
						+ resultado.getInt("id") + "\t" );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//EJERCICIO1
	
	ArrayList<Empleado>al = new ArrayList<>();
	
	/**
	 * @return devuelve la lista de empleados
	 */
	public ArrayList<Empleado>getEmpleado(){
		return al;
		
		}
	//EJERCICIO2.1
	
	/**
	 * @param empleado
	 * @return devuelve verdadero al insertar un empleado a la bd 
	 * @throws SQLException
	 */
	public static boolean insertar(Empleado empleado) throws SQLException {
		PreparedStatement ol= conexion.prepareStatement("INSERT INTO empleados(DNI,NOMBRE,APELLIDO,SALARIO) values(?,?,?,?)");
		ol.setString(1, empleado.getDni());
		ol.setString(2, empleado.getNombre());
		ol.setString(3, empleado.getApellidos());
		ol.setInt(4, empleado.getSueldo());
		int o = ol.executeUpdate();
		if(o==0) {
			return false;
		}
		else {
			return true;
		}
		}

	
	/**
	 * @param dni
	 * @throws SQLException Consulta por dni
	 */
	public static void buscar(int dni) throws SQLException {
		ResultSet rs = conexion.prepareStatement("SELECT * FROM empleados WHERE DNI='"+dni+"'").executeQuery();
		
		
		while (rs.next()) {
			System.out.print(rs.getString("NOMBRE"));
			System.out.println();
		}
	}
		
	/**
	 * @param Dni
	 * @return 
	 * @throws SQLException
	 * Borra por Dni y devuelve true si se ha cumplido
	 */
	public static boolean borrar(int Dni) throws SQLException {
		Statement ol = conexion.createStatement();
		String rs = ("DELETE FROM empleados WHERE DNI='"+Dni+"'");
		ol.executeUpdate(rs);
		return true;
		
		
		
		
	}
}
	
		
		
		
	
		
		
		


	
	



