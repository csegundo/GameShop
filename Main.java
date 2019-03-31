package Launcher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static final String nombreBD = "GameShop";
	public static final String userID = "root";
	public static final String userPASS = "gameshop";
	
	Connection con; //Variable objeto que guarda lo referente a la conexion con la BD
	
	public static void main(String[] args) {
		Main m = new Main();
		m.createConnection();
		
		//m.insertData("plataforma");
		//m.updateData("plataforma");
		m.deleteData("plataforma");
		
		ResultSet query = m.selectData("SELECT * FROM plataforma");
		m.printQuery(query);
	}
	
	//Establece la conexion con la base de datos
	private void createConnection(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nombreBD, userID, userPASS);
			System.out.println("Conexión con la Base de Datos realizada con éxito.");
		} catch (ClassNotFoundException cnfe) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, cnfe);
		} catch (SQLException sqle){
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, sqle);
		}
	}
	
	//Realiza una consulta sql a la base de datos
	private ResultSet selectData(String query){
		ResultSet rs = null;
		try{
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException sqle){
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, sqle);
		}
		return rs;
	}
	
	//Imprime por pantalla una consulta sql recibida por parametro
	private void printQuery(ResultSet rs){
		
		try{
			while(rs.next()){
				System.out.print(rs.getString("ID") + " ");
				System.out.print(rs.getString("nombre") + "\n");
			}
		} catch (SQLException sqle){
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, sqle);
		}
	}
	
	private void insertData(String nombreTabla){
		try{
			/*
			Statement stmt = con.createStatement();
			String insertSql = "INSERT INTO " + nombreTabla + " VALUES('joselu',87)";
			stmt.execute(insertSql);
			stmt.close();
			*/
			
			//La ventaja del PreparedStatement es que tu preparas la consulta, y luego puedes hacer un bucle for
			//e ir realizando INSERTS, en vez de hacerlo 1 a 1 con los statements normales.
			PreparedStatement stmt = con.prepareStatement("INSERT INTO "+ nombreTabla + " VALUES(?,?)");
			//Colocamos los parametros en orden
			stmt.setString(1, "P002");
			stmt.setString(2, "Xbox");
			//jdbc coge los parametros en orden y los sustituye en la ? para realizar la consulta.
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException sqle){
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, sqle);
		}
	}
	
	private void updateData(String nombreTabla){
		try{
			PreparedStatement stmt = con.prepareStatement("UPDATE " + nombreTabla + " SET nombre = ? WHERE ID = ?");
			stmt.setString(1, "PS4");
			stmt.setString(2, "P002");
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException sqle){
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, sqle);
		}
	}
	
	private void deleteData(String nombreTabla){
		try{
			PreparedStatement stmt = con.prepareStatement("DELETE FROM " + nombreTabla + " WHERE ID=?");
			stmt.setString(1, "P001");
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException sqle){
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, sqle);
		}
		
	}

}