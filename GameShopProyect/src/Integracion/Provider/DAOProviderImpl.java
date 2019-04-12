/**
 * 
 */
package Integracion.Provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Transfers.TProvider;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author joalow
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class DAOProviderImpl implements DAOProvider {
	
	public static final String nombreBD = "GameShop";
	public static final String userID = "root";
	public static final String userPASS = "gameshop";

	public Integer createProvider(TProvider tp) {
		int id = -1;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nombreBD, userID, userPASS);
			PreparedStatement ps = con.prepareStatement("INSERT INTO proveedor VALUES(?,?,?,?)");
			ps.setString(1, tp.get_address());
			ps.setString(2, tp.get_nif());
			ps.setInt(3, tp.get_phoneNumber());
			ps.setBoolean(4, true);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				id = rs.getInt(1);
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
		
	}

	public Boolean deleteProvider(TProvider tp) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Boolean updateProvider(TProvider tp) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Object readProvider(TProvider tp) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public List readAllProviders() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public TProvider readProviderByNIF(String s) {
		
		TProvider tpl = new TProvider();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nombreBD, userID, userPASS);
			PreparedStatement ps = con.prepareStatement("SELECT NIF FROM proveedor WHERE NIF=?");
			ps.setString(1, s);
			ps.executeQuery();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				tpl.set_id(rs.getInt(1));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		return tpl;
	}
}