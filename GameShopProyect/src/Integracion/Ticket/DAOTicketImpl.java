/**
 * 
 */
package Integracion.Ticket;

import java.util.List;

import Transfers.TTicket;

import java.sql.Timestamp;


public class DAOTicketImpl implements DAOTicket {
	
	public static final String nombreBD = "gameshop";
	public static final String userID = "root";
	public static final String userPASS = "1234";
	
	public Integer createTicket(TTicket tt) {
		return null;
	}
	public Boolean deleteTicket(TTicket tt) {
		return null;
	}
	public Boolean updateTicket(TTicket tt) {
		return null;
	}
	public TTicket readTicket(TTicket tt) {
		return null;
	}
	public List<TTicket> readAllTickets() {
		return null;
	}
	public Integer readByDate(Timestamp d) {
		return null;
	}
}