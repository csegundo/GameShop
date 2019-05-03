package Integracion.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Transfers.TAccessory;
import Transfers.TGame;
import Transfers.TPlatform;
import Transfers.TProduct;
import Transfers.TProvider;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class DAOProductImpl implements DAOProduct {
	
	public Integer createProduct(Object tp) {
		int id = -1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Main.Main.database, Main.Main.user, Main.Main.password);
			PreparedStatement ps;
			if(((TProduct) tp).get_type().equals(TProduct.accessory))
				ps = con.prepareStatement("INSERT INTO accesorio(nombre, PVP, stock, IDProveedor,IDPlataforma,activo,marca,color) VALUES(?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			else
				ps = con.prepareStatement("INSERT INTO juego(nombre, PVP, stock, IDProveedor,IDPlataforma,activo,descripcion,genero) VALUES(?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, ((TProduct) tp).get_name());
			ps.setDouble(2, ((TProduct) tp).get_pvp());
			ps.setInt(3, ((TProduct) tp).get_stock());
			ps.setInt(4, ((TProduct) tp).get_providerId());
			ps.setInt(5, ((TProduct) tp).get_platformId());
			ps.setBoolean(6, true);
			if(((TProduct) tp).get_type().equals(TProduct.accessory)) {
				ps.setString(7, ((TAccessory)tp).get_brand());
				ps.setString(8, ((TAccessory) tp).get_color());
			}else {
				ps.setString(7, ((TGame) tp).get_description());
				ps.setString(8, ((TGame) tp).get_gender());
			}
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				id = rs.getInt(1);
			}
			con.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return id;
	}

	public Boolean deleteProduct(Object tp) {
		boolean ret = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Main.Main.database, Main.Main.user, Main.Main.password);
			PreparedStatement ps ;
			if(((TProduct) tp).get_type().equals(TProduct.accessory))
				ps = con.prepareStatement("UPDATE accesorio SET activo=(?) WHERE ID=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
			else
				ps = con.prepareStatement("UPDATE juego SET activo=(?) WHERE ID=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, false);
			ps.setInt(2, ((TProduct)tp).get_id());
			int res = ps.executeUpdate();
		
			if(res > 0) {
				ret = true;
			}
			con.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public Boolean updateProduct(Object tp) {
		boolean ret = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Main.Main.database, Main.Main.user, Main.Main.password);
			PreparedStatement ps;
			String table;
			if(((TProduct) tp).get_type().equals(TProduct.accessory))
				table = "accesorio";
			else
				table = "juego";
			
			if(((TProduct) tp).get_type().equals(TProduct.accessory))
				ps = con.prepareStatement("UPDATE accesorio SET activo=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
			else
				ps = con.prepareStatement("UPDATE juego SET activo=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, ((TProduct)tp).get_activated());
			ps.setString(2, ((TProduct)tp).get_id().toString());
			int res = ps.executeUpdate();
			if(((TProduct) tp).get_type().equals(TProduct.accessory))
				ps = con.prepareStatement("UPDATE accesorio SET nombre=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
			else
				ps = con.prepareStatement("UPDATE juego SET nombre=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(2, ((TProduct)tp).get_id());
			ps.setString(1, ((TProduct)tp).get_name());
			res = ps.executeUpdate();
			if(((TProduct) tp).get_type().equals(TProduct.accessory))
				ps = con.prepareStatement("UPDATE accesorio SET stock=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
			else
				ps = con.prepareStatement("UPDATE juego SET stock=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(2, ((TProduct)tp).get_id());
			ps.setInt(1, ((TProduct)tp).get_stock());
			res = ps.executeUpdate();
			if(((TProduct) tp).get_type().equals(TProduct.accessory))
				ps = con.prepareStatement("UPDATE accesorio SET pvp=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
			else
				ps = con.prepareStatement("UPDATE juego SET pvp=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(2, ((TProduct)tp).get_id());
			ps.setDouble(1, ((TProduct)tp).get_pvp());
			res = ps.executeUpdate();
			if(((TProduct) tp).get_type().equals(TProduct.accessory))
				ps = con.prepareStatement("UPDATE accesorio SET IDPlataforma=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
			else
				ps = con.prepareStatement("UPDATE juego SET IDPlataforma=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(2, ((TProduct)tp).get_id());
			ps.setInt(1, ((TProduct)tp).get_platformId());
			res = ps.executeUpdate();
			if(((TProduct) tp).get_type().equals(TProduct.accessory))
				ps = con.prepareStatement("UPDATE accesorio SET IDProveedor=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
			else
				ps = con.prepareStatement("UPDATE juego SET IDProveedor=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(2, ((TProduct)tp).get_id());
			ps.setInt(1, ((TProduct)tp).get_providerId());
			res = ps.executeUpdate();
			
			if(((TProduct) tp).get_type().equals(TProduct.accessory)) {
				ps = con.prepareStatement("UPDATE accesorio SET marca=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(2, ((TProduct)tp).get_id());
				ps.setString(1, ((TAccessory)tp).get_brand());
				res = ps.executeUpdate();
				
				ps = con.prepareStatement("UPDATE accesorio SET color=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(2, ((TProduct)tp).get_id());
				ps.setString(1, ((TAccessory)tp).get_color());
				res = ps.executeUpdate();
			}else {
				ps = con.prepareStatement("UPDATE juego SET descripcion=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(2, ((TProduct)tp).get_id());
				ps.setString(1, ((TGame)tp).get_description());
				res = ps.executeUpdate();
				
				ps = con.prepareStatement("UPDATE juego SET genero=? WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(2, ((TProduct)tp).get_id());
				ps.setString(1, ((TGame)tp).get_gender());
				res = ps.executeUpdate();
			}
			
			if(res > 0) {
				ret = true;
			}
			con.close();
			
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public Object readProduct(Object tp) {
		TProduct tpr = null;
		try {
			/*
			 * STACKOVERFLOW ERROR SOLUTION: (https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue)
			 * jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
			 * Hay que descargarse el JAR executable file y añadirlo a la libreria del proyecto para solucionar ese error y en la BD poner:
			 * SET GLOBAL time_zone = '+3:00'; para arreglar el error de la zona horaria*/
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Main.Main.database, Main.Main.user, Main.Main.password);
			PreparedStatement ps;
			if(((TProduct) tp).get_type().equalsIgnoreCase(TProduct.accessory)) {
				ps = con.prepareStatement("SELECT * FROM accesorio WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
				tpr = new TAccessory();
			}else {
				ps = con.prepareStatement("SELECT * FROM juego WHERE ID=?", PreparedStatement.RETURN_GENERATED_KEYS);
				tpr= new TGame();
			}
			ps.setInt(1, ((TProduct)tp).get_id());
			ResultSet rs = ps.executeQuery();
	
			if(rs.next()){

				// TODO no faltaria aqui el UNITS PROVIDED?
				((TProduct)tpr).set_id(rs.getInt(1));
				((TProduct)tpr).set_name(rs.getString(2));
				((TProduct)tpr).set_pvp(rs.getDouble(3));
				((TProduct)tpr).set_stock(rs.getInt(4));
				((TProduct)tpr).set_providerId(rs.getInt(5));
				((TProduct)tpr).set_platformId(rs.getInt(6));
				((TProduct)tpr).set_activated(rs.getBoolean(7));
				if(((TProduct) tp).get_type().equals(TProduct.accessory)) {
					((TAccessory)tpr).set_brand(rs.getString(8));
					((TAccessory)tpr).set_color(rs.getString(9));
					((TAccessory)tpr).set_type(TProduct.accessory);
				}else {
					((TGame)tpr).set_description(rs.getString(8));
					((TGame)tpr).set_gender(rs.getString(9));
					((TGame)tpr).set_type(TProduct.game);
				}
			}else
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return tpr;
	}

	public List<Object> readAllProducts() {
		List<Object> l = new ArrayList<Object>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Main.Main.database, Main.Main.user, Main.Main.password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM accesorio", PreparedStatement.RETURN_GENERATED_KEYS);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				TAccessory tp = new TAccessory();
				tp.set_id(rs.getInt(1));
				tp.set_name(rs.getString(2));
				tp.set_pvp(rs.getDouble(3));
				tp.set_stock(rs.getInt(4));
				tp.set_providerId(rs.getInt(5));
				tp.set_platformId(rs.getInt(6));
				tp.set_activated(rs.getBoolean(7));
				tp.set_brand(rs.getString(8));
				tp.set_color(rs.getString(9));
				tp.set_type(TProduct.accessory);
				l.add(tp);
			}
			
			ps = con.prepareStatement("SELECT * FROM juego", PreparedStatement.RETURN_GENERATED_KEYS);
			rs = ps.executeQuery();
			
			while(rs.next()){
				TGame tp = new TGame();
				tp.set_id(rs.getInt(1));
				tp.set_name(rs.getString(2));
				tp.set_pvp(rs.getDouble(3));
				tp.set_stock(rs.getInt(4));
				tp.set_providerId(rs.getInt(5));
				tp.set_platformId(rs.getInt(6));
				tp.set_activated(rs.getBoolean(7));
				tp.set_description(rs.getString(8));
				tp.set_gender(rs.getString(9));
				tp.set_type(TProduct.game);
				l.add(tp);
			}
			
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public TProduct readProductByName(Object tpr) {
		TProduct tp = null;
		try {
			/*
			 * STACKOVERFLOW ERROR SOLUTION: (https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue)
			 * jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
			 * Hay que descargarse el JAR executable file y añadirlo a la libreria del proyecto para solucionar ese error y en la BD poner:
			 * SET GLOBAL time_zone = '+3:00'; para arreglar el error de la zona horaria*/
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Main.Main.database, Main.Main.user, Main.Main.password);
			PreparedStatement ps;
			if(((TProduct)tpr).get_type().equals(TProduct.accessory))
				ps= con.prepareStatement("SELECT ID FROM accesorio WHERE nombre=?", PreparedStatement.RETURN_GENERATED_KEYS);
			else
				ps= con.prepareStatement("SELECT ID FROM juego WHERE nombre=?", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, ((TProduct)tpr).get_name());
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				tp = new TProduct();
				tp.set_id(rs.getInt(1));
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return tp;
	}
}