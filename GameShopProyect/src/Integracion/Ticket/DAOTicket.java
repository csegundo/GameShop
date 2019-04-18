/**
 * 
 */
package Integracion.Ticket;

import java.util.List;

import Transfers.TTicket;

import java.sql.Timestamp;

public interface DAOTicket {
	
	public Integer createTicket(TTicket tt);
	public Boolean deleteTicket(TTicket tt);
	public Boolean updateTicket(TTicket tt);
	public TTicket readTicket(TTicket tt);
	public List<TTicket> readAllTickets();
	public Integer readByDate(Timestamp d);
}