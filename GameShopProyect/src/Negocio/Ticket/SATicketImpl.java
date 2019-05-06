
package Negocio.Ticket;

import java.util.List;

import Integracion.DAO.DAOAbstractFactory;
import Integracion.Ticket.DAOTicket;
import Transfers.TProduct;
import Transfers.TTicket;


public class SATicketImpl implements SATicket {
	
	public Integer createTicket(TTicket tt) {
		//DAOTicket daoTicket = DAOAbstractFactory.getInstance().createDAOTicket();
		if(ProdListNotEmpty(tt) && CorrectInputData(tt))
		{
			return DAOAbstractFactory.getInstance().createDAOTicket().createTicket(tt); 
		}
		else
		{
			return 0;
		}
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

	public Boolean updateTicket(TTicket tt) { //TODO ?????????????????????????????????????
		return null;
		// end-user-code
	}
	public Object readTicket(Integer id) {
		TTicket ret = null;
		DAOTicket daoTicket = DAOAbstractFactory.getInstance().createDAOTicket();
		if(id != null)
		{
			TTicket aux = new TTicket();
			aux.set_id(id);
			ret = (TTicket)daoTicket.readTicket(aux);
		}
		return ret;
	}
	
	public List<Object> readAllTickets() {
		List<Object> tickets = null;
		tickets = DAOAbstractFactory.getInstance().createDAOTicket().readAllTickets();
		return tickets;
	}
	
	private boolean ProdListNotEmpty(TTicket tt)
	{ //damos por hecho en el DAO que la lista no llega vacia ===> Aqui se comprueba si esta vacia o no
		return tt.get_products().size()>0;
	}
	private boolean CorrectInputData(TTicket tt)
	{ //comprobamos que todos los datos introducidos son correctos y existen
	
		//Empleado existe y esta activo
		if(DAOAbstractFactory.getInstance().createDAOEmployee().readEmployee(tt.get_employeeId())==null)
			return false;
		
		//Cada uno de los productos existen y hay stock suficiente
		int prodAmount = tt.get_products().size();
		for(int i=0;i<prodAmount;i++)
		{
			TProduct prod = (TProduct) tt.get_products().get(i);
			TProduct aux = DAOAbstractFactory.getInstance().createDAOProduct().readProduct(prod.get_id());
			if(aux==null)
				return false;
			if((aux.get_stock() - prod.get_unitsProvided()<0))
				return false;
		}
		return true;
	}
}