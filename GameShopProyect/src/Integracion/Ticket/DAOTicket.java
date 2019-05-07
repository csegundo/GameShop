/**
 * 
 */
package Integracion.Ticket;

import java.util.List;

import Transfers.TTicket;

import java.sql.Timestamp;

public interface DAOTicket {
	
	public Integer createTicket(TTicket tt);
	public Boolean deleteTicket(Integer id);
	public Boolean updateTicket(TTicket tt);
	public TTicket readTicket(TTicket tt);
	public List<Object> readAllTickets();
	public TTicket readByDate(Timestamp d); //estaba a Integer (devolvia el id) , lo he cambiado a TTicket porque
											//lo del id es un puto jaleo. ~Vitali
}