package Integracion.Ticket;

import java.util.Date;
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
			Date d = tt.get_date();
			List<TProduct> prod = tt.get_productsId();
			TProduct pr = prod.get(0);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Main.Main.database, Main.Main.user, Main.Main.password);
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO ticket(idEmpl, fecha, precioFinal, idProd , nombre , plataforma, cantidad, precio) VALUES(?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, tt.get_employeeId());
			ps.setDate(2, (java.sql.Date) d); //SI ALGO PETA , PROBABLEMENTE ES ESTO
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
			int i=1;
			while(i<prod.size())
			{
				pr=prod.get(i);
				PreparedStatement ps2 = con.prepareStatement("INSERT INTO ticket(ID, idEmpl, fecha, precioFinal, idProd , nombre , plataforma, cantidad, precio) VALUES(?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, id);
				ps2.setInt(2, tt.get_employeeId());
				ps2.setDate(3, (java.sql.Date) d); //SI ALGO PETA , PROBABLEMENTE ES ESTO
				ps2.setDouble(4,tt.get_finalPrice());
				ps2.setInt(5, pr.get_id());
				ps2.setString(6, pr.get_name());
				ps2.setInt(7,pr.get_platformId());
				ps2.setInt(8, pr.get_unitsProvided());
				ps2.setDouble(9, pr.get_pvp());
				ps.executeUpdate();
				i++;
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