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
import Presentacion.View.FormUpdateProvider;
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
		Integer id;
		TProvider tpr;
		
		switch(Math.abs(event / 100)) {
		case 1: gui = ge; break;
		case 2: gui = gpr; break;
		case 3: gui = gt; break;
		case 4: gui = gprd; break;
		case 5: gui = gpl; break;
		}
		
		switch(event) {
		case Event.REGISTER_PROVIDER:
			tpr = (TProvider)data;
			int resRegisterProv = (SAAbstractFactory.getInstance().createSAProvider()).createProvider(tpr);
			if(resRegisterProv > 0)
				gui.actualiza(Event.RES_REGISTER_PROVIDER_OK, new Integer(resRegisterProv));
			else if (resRegisterProv <= 0)
				gui.actualiza(Event.RES_REGISTER_PROVIDER_FAILED, null);
			break;
			
		case Event.UNSUBSCRIBE_PROVIDER:
			id = (Integer)data;
			boolean resDeleteProv = (SAAbstractFactory.getInstance().createSAProvider()).deleteProvider(id);
			if(resDeleteProv)
				gui.actualiza(Event.RES_UNSUBSCRIBE_PROVIDER_OK, id);
			else
				gui.actualiza(Event.RES_UNSUBSCRIBE_PROVIDER_FAILED, null);
			break;
			
		case Event.MODIFYBUTTON_PROVIDER:
			id = (Integer) data;
			tpr = (TProvider)(SAAbstractFactory.getInstance().createSAProvider()).readProvider(id);
			if(tpr != null)
				new FormUpdateProvider(tpr);
			else
				gui.actualiza(Event.RES_MODIFY_PROVIDER_FAILED, null);
			break;
			
		case Event.MODIFY_PROVIDER:
			tpr = (TProvider)data;
			if(SAAbstractFactory.getInstance().createSAProvider().updateProvider(tpr))
				gui.actualiza(Event.RES_MODIFY_PROVIDER_OK, null);
			else
				gui.actualiza(Event.RES_MODIFY_PROVIDER_FAILED, null);
			break;
			
			
		case Event.READ_PROVIDER:
			id = (Integer)data;
			TProvider t = (TProvider)(SAAbstractFactory.getInstance().createSAProvider()).readProvider(id);
			if (t != null) 
				gui.actualiza(Event.RES_READ_PROVIDER_OK, t);
			else
				gui.actualiza(Event.RES_READ_PROVIDER_FAILED, null);
			break;
			
		case Event.READ_ALL_PROVIDERS:
			List<Object> providers = (SAAbstractFactory.getInstance().createSAProvider()).readAllProviders();
			if(providers == null)
				gui.actualiza(Event.RES_READALL_PROVIDERS_FAILED, null);
			else
				gui.actualiza(Event.RES_READALL_PROVIDERS_OK, providers);
			break;
		}
	}
	
}