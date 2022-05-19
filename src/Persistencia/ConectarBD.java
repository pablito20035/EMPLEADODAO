package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectarBD {
	
	/**
	 * @param conexion
	 * cinecta la base de datos
	 */
	public static Connection conectarBD() {
		String host = "localhost";
		int puerto = 3306;
		String db = "empresa";
		String url = "jdbc:mysql://" + host + ":" + puerto + "/" + db;
		String login = "root";
		String password = "";

		try {
			
			// Conectamos con la base de datos
			
			Connection conexion = DriverManager.getConnection(url, login, password);
			System.out.println((conexion != null) ? "CONEXION OK" : "CONEXION FALLIDA");
			/*if (conexion != null) {
				System.out.println("CONEXION OK");
			}else {
				System.out.println("CONEXION FALLIDA");
			}*/
			return conexion;
		} catch (java.sql.SQLException sqle) {
			System.out.println("Error: " + sqle);
			return null;
		}
	}

}
