package Presentacion.Controller;

import Negocio.Provider.SAProvider;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Provider.GUIProvider;
import Presentacion.View.IGUI;
import Transfers.TProvider;

/** 
 * @author GameShop
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControllerImpl extends Controller {
	
	private SAProvider sap;
	private IGUI gui = new GUIProvider();

	@Override
	public void action(Object data, Integer event) {
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
			TProvider tpu = (TProvider)data;
			sap = SAAbstractFactory.getInstance().createSAProvider();
			boolean resDeleteProv = sap.deleteProvider(tpu);
			if(resDeleteProv)
				gui.actualiza(Event.RES_UNSUBSCRIBE_PROVIDER_OK, new Integer(tpu.get_id()));
			else
				gui.actualiza(Event.RES_UNSUBSCRIBE_PROVIDER_FAILED, null);
			break;
		}
	}
	
}