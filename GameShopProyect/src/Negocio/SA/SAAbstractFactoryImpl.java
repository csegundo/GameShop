package Negocio.SA;

import Negocio.Employee.SAEmployee;
import Negocio.Employee.TestSAEmployee;
import Negocio.Platform.SAPlatform;
import Negocio.Platform.TestSAPlatform;
import Negocio.Product.SAProduct;
import Negocio.Product.TestSAProduct;
import Negocio.Provider.SAProvider;
import Negocio.Provider.TestSAProvider;
import Negocio.Ticket.SATicket;
import Negocio.Ticket.TestSATicket;

/** 
 * @author GameShop
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAAbstractFactoryImpl extends SAAbstractFactory {
	
	public SAEmployee createSAEmployee() {
		return new TestSAEmployee();
	}

	public SAPlatform createSAPlatform() {
		return new TestSAPlatform();
	}

	public SAProduct createSAProduct() {
		return new TestSAProduct();
	}

	public SAProvider createSAProvider() {
		return new TestSAProvider();
	}

	public SATicket createSATicket() {
		return new TestSATicket();
	}

	
	
}