package Presentacion.Controller;

import java.util.ArrayList;
import java.util.List;

import Main.Main;
import Negocio.Employee.SAEmployee;
import Negocio.Platform.SAPlatform;
import Negocio.Product.SAProduct;
import Negocio.Provider.SAProvider;
import Negocio.SA.SAAbstractFactory;
import Negocio.Ticket.SATicket;
import Presentacion.Employee.GUIEmployee;
import Presentacion.Platform.GUIPlatform;
import Presentacion.Product.GUIProduct;
import Presentacion.Provider.GUIProvider;
import Presentacion.Ticket.GUITicket;
import Presentacion.View.GUIGameshop;
import Presentacion.View.IGUI;
import Transfers.TProvider;

/** 
 * @author GameShop
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControllerImpl extends Controller {
	
	private IGUI gui;
	private GUIGameshop gs;
	
	private GUIProvider gpr;
	private GUIPlatform gpl;
	private GUIEmployee ge;
	private GUIProduct gprd;
	private GUITicket gt;
	
	private SAProvider sap;
	private SAProduct sapr;
	private SATicket sat;
	private SAEmployee sae;
	private SAPlatform sapl;
	
	public ControllerImpl() {
		gs = new GUIGameshop(Main.applicationName);
		List<Object> guis = new ArrayList<Object>();
		guis.add((gpr=new GUIProvider()));
		guis.add((gpl = new GUIPlatform()));
		guis.add((ge = new GUIEmployee()));
		guis.add((gprd = new GUIProduct()));
		guis.add((gt = new GUITicket()));
		gs.initTabs(guis);
	}

	@Override
	public void action(Object data, Integer event) {
		
		switch(Math.abs(event / 100)) {
		case 1: gui = ge; break;
		case 2: gui = gpr; break;
		case 3: gui = gt; break;
		case 4: gui = gprd; break;
		case 5: gui = gpl; break;
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
			
		case Event.READ_PROVIDER:
			Integer id = (Integer)data;
			sap = SAAbstractFactory.getInstance().createSAProvider();
			TProvider t = (TProvider)sap.readProvider(id);
			if (t != null) 
				gui.actualiza(Event.RES_READ_PROVIDER_OK, t);
			else
				gui.actualiza(Event.RES_READ_PROVIDER_FAILED, null);
			break;
		}
	}
	
}