/**
 * 
 */
package Integracion.DAO;

import Integracion.Employee.DAOEmployee;
import Integracion.Employee.TestDAOEmployee;
import Integracion.Platform.DAOPlatform;
import Integracion.Platform.TestDAOPlatform;
import Integracion.Product.DAOProduct;
import Integracion.Product.TestDAOProduct;
import Integracion.Provider.DAOProvider;
import Integracion.Provider.TestDAOProvider;
import Integracion.Ticket.DAOTicket;
import Integracion.Ticket.TestDAOTicket;


public class DAOAbstractFactoryImpl extends DAOAbstractFactory {
	public DAOEmployee createDAOEmployee() {
		return new TestDAOEmployee();
	}

	public DAOPlatform createDAOPlatform() {
		return new TestDAOPlatform();
	}

	public DAOProduct createDAOProduct() {
		return new TestDAOProduct();
	}

	public DAOProvider createDAOProvider() {
		return new TestDAOProvider();
	}

	public DAOTicket createDAOTicket() {
		return new TestDAOTicket();
	}
}