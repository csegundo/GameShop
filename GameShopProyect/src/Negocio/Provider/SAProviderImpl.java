package Negocio.Provider;

import java.util.List;

import Integracion.DAO.DAOAbstractFactory;
import Integracion.Provider.DAOProvider;
import Transfers.TProvider;

/**
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class SAProviderImpl implements SAProvider {

	public Integer createProvider(TProvider tp) {
		int id = -1;
		DAOProvider daoProvider = DAOAbstractFactory.getInstance().createDAOProvider();
		if(tp != null){
			TProvider tpl = daoProvider.readProviderByNIF(tp.get_nif());
			//if(tpl != null)
			if(tpl == null) 
				id = daoProvider.createProvider(tp);
		}
		return id;
	}

	public Boolean deleteProvider(TProvider tp) {
		return null;
	}

	public Boolean updateProvider(TProvider tp) {
		return null;
	}

	public Object readProvider(TProvider tp) {
		return null;
	}

	public List<Object> readAllProviders() {
		return null;
	}

}