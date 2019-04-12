/**
 * 
 */
package Negocio.Provider;

import java.util.List;

import Integracion.DAO.DAOAbstractFactory;
import Integracion.Provider.DAOProvider;
import Transfers.TProvider;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author joalow
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class SAProviderImpl implements SAProvider {

	public Integer createProvider(TProvider tp) {
		int id = -1;
		DAOProvider daoProvider = DAOAbstractFactory.getInstance().createDAOProvider();
		if(tp != null){
			TProvider tpl = daoProvider.readProviderByNIF(tp.get_nif());
			if(tpl != null) id = daoProvider.createProvider(tp);
		}
		return id;
	}

	public Boolean deleteProvider(TProvider tp) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Boolean updateProvider(TProvider tp) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Object readProvider(TProvider tp) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public List readAllProviders() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

}