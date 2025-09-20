package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class SingleConnection {
	private static String url = "jdbc:postgresql://localhost:5432/posjava";
	private static String password;
	private static String user;
	private static Connection connection = null;
	public static Scanner sc = new Scanner(System.in);
	
	static{
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
		
	private static void conectar() {
		System.out.print("User: ");
		user = sc.nextLine();
		System.out.print("Password: ");
		password = sc.nextLine();
		System.out.println("teste de commit");

		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conectou");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
