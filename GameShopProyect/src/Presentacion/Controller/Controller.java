/**
 * 
 */
package Presentacion.Controller;

import Negocio.Provider.SAProvider;
import Negocio.Provider.SAProviderImpl;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Controller.Event;
import Presentacion.View.IGUI;
import Transfers.TProvider;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author joalow
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class Controller {

	private static Controller instance;
	private SAProvider sap;
	private IGUI gui;

	public static Controller getInstance() {
		if(instance == null) instance = new Controller();
		return instance;
	}
	
	public void action(TProvider t, Integer e) {
		
		switch(e){
		case 200: //Register provider //TODO por que no se puede poner la constante Event.REGISTER_PROVIDER
			sap = SAAbstractFactory.getInstance().createSAProvider();
			int res = sap.createProvider(t);
			if(res > 0) gui.actualiza(Event.RES_REGISTER_PROVIDER_OK, new Integer(res));
			else gui.actualiza(Event.RES_REGISTER_PROVIDER_FAILED, null);
			break;
		}
		
	}
}