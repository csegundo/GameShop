package Presentacion.Controller;

import Transfers.TProvider;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public abstract class Controller {

	private static Controller instance;

	public static Controller getInstance() {
		if(instance == null) instance = new ControllerImpl();
		return instance;
	}
	
	public abstract void action(TProvider t, Integer e);
	
//	public void action(TProvider t, Integer e) {
//		
//		switch(e){
//		case 200: //Register provider //TODO por que no se puede poner la constante Event.REGISTER_PROVIDER
//			sap = SAAbstractFactory.getInstance().createSAProvider();
//			int res = sap.createProvider(t);
//			if(res > 0) gui.actualiza(Event.RES_REGISTER_PROVIDER_OK, new Integer(res));
//			else gui.actualiza(Event.RES_REGISTER_PROVIDER_FAILED, null);
//			break;
//		}
//		
//	}
}