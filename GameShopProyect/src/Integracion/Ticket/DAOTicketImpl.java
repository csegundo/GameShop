package Integracion.Ticket;

import java.util.List;

import Transfers.TProduct;
import Transfers.TTicket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class DAOTicketImpl implements DAOTicket {
	
	public Integer createTicket(TTicket tt) {
		int id = -1;
		try {
			List<Object> prod = tt.get_products();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Main.Main.database, Main.Main.user, Main.Main.password);
			
			for(int i = 0 ; i < prod.size(); ++i) {
				PreparedStatement ps = con.prepareStatement("INSERT INTO ticket(idEmpl, fecha, precioFinal, idProd , nombre , idPlat, cantidad, precio) VALUES(?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
				TProduct pr = (TProduct) prod.get(0);
				ps.setInt(1, tt.get_employeeId());
				ps.setTimestamp(2, tt.get_date()); 
				ps.setDouble(3,tt.get_finalPrice());
				ps.setInt(4, pr.get_id());
				ps.setString(5, pr.get_name());
				ps.setInt(6,pr.get_platformId());
				ps.setInt(7, pr.get_unitsProvided());
				ps.setDouble(8, pr.get_pvp());
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()){
					id = rs.getInt(1);
				}
			}
			con.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return id;
	}
	public Boolean deleteTicket(TTicket tt) {
		boolean ret = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Main.Main.database, Main.Main.user, Main.Main.password);
			PreparedStatement ps = con.prepareStatement("DELETE ticket WHERE ID=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, tt.get_id());
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
	public Boolean updateTicket(TTicket tt) {
		return null;
	}
	public TTicket readTicket(TTicket tt) {
		return null;
	}
	public List<Object> readAllTickets() {
		return null;
	}
	public Integer readByDate(Timestamp d) {
		return null;
	}
}