/**
 * 
 */
package Negocio.Ticket;

import java.util.List;

import Integracion.DAO.DAOAbstractFactory;
import Integracion.Ticket.DAOTicket;
import Transfers.TTicket;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author joalow
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class SATicketImpl implements SATicket {
	
	public Integer createTicket(TTicket tt) {
		DAOTicket daoTicket = DAOAbstractFactory.getInstance().createDAOTicket();
		return null;
		// end-user-code
	}

	public Boolean deleteTicket(TTicket tt) {
		boolean deleted=false;
		DAOTicket daoTicket = DAOAbstractFactory.getInstance().createDAOTicket();
		if(tt!=null)
		{
			TTicket aux = daoTicket.readTicket(tt);
			if(aux!=null)
				deleted= daoTicket.deleteTicket(tt);
		}
		return deleted;
	}

	public Boolean updateTicket(TTicket tt) {
		return null;
		// end-user-code
	}
	public Object readTicket(Integer id) {
		return null;
		// end-user-code
	}
	public List<Object> readAllTickets() {
		return null;
		// end-user-code
	}
}