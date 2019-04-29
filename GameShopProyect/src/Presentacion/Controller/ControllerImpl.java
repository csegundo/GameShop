package Presentacion.Controller;

import java.util.ArrayList;
import java.util.List;

import Main.Main;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Employee.FormUpdateEmployee;
import Presentacion.Employee.GUIEmployee;
import Presentacion.Platform.GUIPlatform;
import Presentacion.Product.GUIProduct;
import Presentacion.Provider.FormUpdateProvider;
import Presentacion.Provider.GUIProvider;
import Presentacion.Ticket.GUITicket;
import Presentacion.View.GUIGameshop;
import Presentacion.View.IGUI;
import Transfers.TEmployee;
import Transfers.TProvider;

/** 
 * @author GameShop
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControllerImpl extends Controller {
	
	private IGUI gui;
	private GUIGameshop gs;
	
	public ControllerImpl() {
		gs = new GUIGameshop(Main.applicationName);
		List<Object> guis = new ArrayList<Object>();
		guis.add((new GUIProvider()));
		guis.add((new GUIPlatform()));
		guis.add((new GUIEmployee()));
		guis.add((new GUIProduct()));
		guis.add((new GUITicket()));
		gs.initTabs(guis);
	}

	@Override
	public void action(Object data, Integer event) {
		Integer id;
		TProvider tpr;
		TEmployee tpe;
		
		gui = gs.getGuiAt(event/100 - 1);

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
			List<TProvider> providers = (SAAbstractFactory.getInstance().createSAProvider()).readAllProviders();
			if(providers == null)
				gui.actualiza(Event.RES_READALL_PROVIDERS_FAILED, null);
			else
				gui.actualiza(Event.RES_READALL_PROVIDERS_OK, providers);
			break;
			
			
			
			
		case Event.REGISTER_EMPLOYEE:
			tpe = (TEmployee)data;
			int resRegisterEmp = (SAAbstractFactory.getInstance().createSAEmployee()).createEmployee(tpe);
			if(resRegisterEmp > 0)
				gui.actualiza(Event.RES_REGISTER_EMPLOYEE_OK, new Integer(resRegisterEmp));
			else
				gui.actualiza(Event.RES_REGISTER_PROVIDER_FAILED, null);
			break;
			
		case Event.UNSUBSCRIBE_EMPLOYEE:
			id = (Integer)data;
			boolean resDeleteEmp = (SAAbstractFactory.getInstance().createSAEmployee()).deleteEmployee(id);
			if(resDeleteEmp)
				gui.actualiza(Event.RES_UNSUBSCRIBE_EMPLOYEE_OK, id);
			else
				gui.actualiza(Event.RES_UNSUBSCRIBE_EMPLOYEE_FAILED, null);
			break;
			
		case Event.MODIFYBUTTON_EMPLOYEE:
			id = (Integer)data;
			tpe = (TEmployee)(SAAbstractFactory.getInstance().createSAEmployee()).readEmployee(id);
			if(tpe != null)
				new FormUpdateEmployee(tpe);
			else
				gui.actualiza(Event.RES_MODIFY_EMPLOYEE_FAILED, null);
			break;
			
		case Event.MODIFY_EMPLOYEE:
			tpe = (TEmployee)data;
			if(SAAbstractFactory.getInstance().createSAEmployee().updateEmployee(tpe))
				gui.actualiza(Event.RES_MODIFY_EMPLOYEE_OK, null);
			else
				gui.actualiza(Event.RES_MODIFY_EMPLOYEE_FAILED, null);
			break;
			
		case Event.READ_EMPLOYEE:
			id = (Integer)data;
			TEmployee te = (TEmployee)(SAAbstractFactory.getInstance().createSAEmployee()).readEmployee(id);
			if (te != null) 
				gui.actualiza(Event.RES_READ_EMPLOYEE_OK, te);
			else
				gui.actualiza(Event.RES_READ_EMPLOYEE_FAILED, null);
			break;
			
		case Event.READ_ALL_EMPLOYEES:
			List<TEmployee> employees = (SAAbstractFactory.getInstance().createSAEmployee()).readAllEmployees();
			if(employees == null)
				gui.actualiza(Event.RES_READALL_EMPLOYEES_FAILED, null);
			else
				gui.actualiza(Event.RES_READALL_EMPLOYEES_OK, employees);
			break;
		}
	}
	
}