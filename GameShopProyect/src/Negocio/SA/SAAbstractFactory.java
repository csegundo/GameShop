/**
 * 
 */
package Negocio.SA;



import Negocio.Provider.SAProvider;
import Negocio.Provider.SAProviderImpl;
import Presentacion.Controller.Controller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author joalow
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class SAAbstractFactory {

	private static SAAbstractFactory instance;

	public static SAAbstractFactory getInstance() {
		if(instance == null) instance = new SAAbstractFactoryImpl();
		return instance;
	}
	
	public abstract Object createSAEmployee();
	public abstract Object createSAPlattform();
	public abstract Object createSAProduct();
	public abstract SAProvider createSAProvider();
	public abstract Object createSATicket();
}