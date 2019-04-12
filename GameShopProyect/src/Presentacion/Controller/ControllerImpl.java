package Presentacion.Controller;

import Negocio.Provider.SAProvider;
import Negocio.SA.SAAbstractFactory;
import Presentacion.View.IGUI;
import Transfers.TProvider;

/** 
 * @author GameShop
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControllerImpl extends Controller {
	
	private SAProvider sap;
	private IGUI gui;

	@Override
	public void action(TProvider t, Integer e) {
		switch(e) {
		case Event.REGISTER_PROVIDER:
			sap = SAAbstractFactory.getInstance().createSAProvider();
			int res = sap.createProvider(t);
			if(res > 0) gui.actualiza(Event.RES_REGISTER_PROVIDER_OK, new Integer(res));
			else gui.actualiza(Event.RES_REGISTER_PROVIDER_FAILED, null);
			break;
		}
	}
	
}