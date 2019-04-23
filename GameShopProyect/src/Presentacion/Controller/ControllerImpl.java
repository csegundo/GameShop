package Presentacion.Controller;

import Negocio.Employee.SAEmployee;
import Negocio.Platform.SAPlatform;
import Negocio.Product.SAProduct;
import Negocio.Provider.SAProvider;
import Negocio.SA.SAAbstractFactory;
import Negocio.Ticket.SATicket;
import Presentacion.Employee.GUIEmployee;
import Presentacion.Platform.GUIPlattform;
import Presentacion.Product.GUIProduct;
import Presentacion.Provider.GUIProvider;
import Presentacion.Ticket.GUITicket;
import Presentacion.View.IGUI;
import Transfers.TProvider;

/** 
 * @author GameShop
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControllerImpl extends Controller {
	
	private IGUI gui;
	private SAProvider sap;
	private SAProduct sapr;
	private SATicket sat;
	private SAEmployee sae;
	private SAPlatform sapl;

	@Override
	public void action(Object data, Integer event) {
		
		switch(Math.abs(event / 100)) {
		case 1: gui = new GUIEmployee(); break;
		case 2: gui = new GUIProvider(); break;
		case 3: gui = new GUITicket(); break;
		case 4: gui = new GUIProduct(); break;
		case 5: gui = new GUIPlattform(); break;
		}
		
		switch(event) {
		case Event.REGISTER_PROVIDER:
			TProvider tpr = (TProvider)data;
			sap = SAAbstractFactory.getInstance().createSAProvider();
			int resRegisterProv = sap.createProvider(tpr);
			if(resRegisterProv > 0)
				gui.actualiza(Event.RES_REGISTER_PROVIDER_OK, new Integer(resRegisterProv));
			else if (resRegisterProv <= 0)
				gui.actualiza(Event.RES_REGISTER_PROVIDER_FAILED, null);
			break;
			
		case Event.UNSUBSCRIBE_PROVIDER:
			Integer ID = (Integer)data;
			sap = SAAbstractFactory.getInstance().createSAProvider();
			boolean resDeleteProv = sap.deleteProvider(ID);
			if(resDeleteProv)
				gui.actualiza(Event.RES_UNSUBSCRIBE_PROVIDER_OK, ID);
			else
				gui.actualiza(Event.RES_UNSUBSCRIBE_PROVIDER_FAILED, null);
			break;
		}
	}
	
}