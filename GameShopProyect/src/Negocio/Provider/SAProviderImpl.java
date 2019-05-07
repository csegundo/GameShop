package Negocio.Provider;

import java.util.List;

import Integracion.DAO.DAOAbstractFactory;
import Integracion.Provider.DAOProvider;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Event;
import Transfers.TProvider;

/**
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class SAProviderImpl implements SAProvider {

	public Integer createProvider(TProvider tp) {
		int id = -1;
		if(validateData(tp)) {
			DAOProvider daoProvider = DAOAbstractFactory.getInstance().createDAOProvider();
			TProvider tpl = (TProvider) daoProvider.readProviderByNIF(tp.get_nif());
			if(tpl == null)
				id = daoProvider.createProvider(tp);
		}
		return id;
	}

	public Boolean deleteProvider(Integer id) {
		boolean ret = false;
		DAOProvider daopi = DAOAbstractFactory.getInstance().createDAOProvider();
		
		if(id != null) {
			TProvider tprnif = (TProvider)daopi.readProvider(id);
			// Si devuelve un transfer significa que existe y por lo tanto se procede a borrarlo
			if(tprnif != null && tprnif.get_activated())
				ret = daopi.deleteProvider(tprnif);
		}
		
		return ret;
	}

	public Boolean updateProvider(TProvider tp ) {
		return validateData(tp) ? DAOAbstractFactory.getInstance().createDAOProvider().updateProvider(tp) : false;
	}

	public Object readProvider(Integer id) {
		TProvider ret = null;
		DAOProvider daoProvider = DAOAbstractFactory.getInstance().createDAOProvider();
		
		if(id != null)
			ret = (TProvider)daoProvider.readProvider(id);
		
		return ret;
	}

	public List<Object> readAllProviders() {
		List<Object> providers = null;
		providers = DAOAbstractFactory.getInstance().createDAOProvider().readAllProviders();
		return providers;
	}

	private boolean validateData(TProvider tp) {
		if(tp == null || !checkNIF(tp.get_nif()) || tp.get_address().length() > 50 || tp.get_phoneNumber().toString().length() != 9)
			return false;
		else
			return true;
	}
	
	
	// ESTOS METODOS SON PARA COMPROBAR LA VALIDEZ DE UN NIF
	private boolean checkNIF(String NIF) {
		if(NIF.length() != 9 || !Character.isLetter(NIF.charAt(8))) 
			return false;
		
		return NIFletter(NIF.substring(8));
	}

	private boolean NIFletter(String upperLetter) {
		String[] posibilities = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q",
				 "V", "H", "L", "C", "K", "E"};
		for(int i = 0; i < posibilities.length; ++i){
			if(upperLetter.equalsIgnoreCase(posibilities[i])) return true;
		}
		return false;
	}

}