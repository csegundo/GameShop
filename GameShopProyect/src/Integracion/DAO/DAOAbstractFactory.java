/**
 * 
 */
package Integracion.DAO;

import Integracion.Employee.DAOEmployee;
import Integracion.Platform.DAOPlatform;
import Integracion.Product.DAOProduct;
import Integracion.Provider.DAOProvider;
import Integracion.Ticket.DAOTicket;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author joalow
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public abstract class DAOAbstractFactory {

	private static DAOAbstractFactory instance;

	public static DAOAbstractFactory getInstance() {
		if(instance == null) instance = new DAOAbstractFactoryImpl();
		return instance;
	}

	public abstract DAOEmployee createDAOEmployee();
	public abstract DAOPlatform createDAOPlatform();
	public abstract DAOProduct createDAOProduct();
	public abstract DAOProvider createDAOProvider();
	public abstract DAOTicket createDAOTicket();
}