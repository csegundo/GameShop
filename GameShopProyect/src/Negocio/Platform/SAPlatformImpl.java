/**
 * 
 */
package Negocio.Platform;

import java.util.List;

import Integracion.DAO.DAOAbstractFactory;
import Integracion.Platform.DAOPlatform;
import Transfers.TPlatform;


public class SAPlatformImpl implements SAPlatform {

	@Override
	public Integer createPlatform(TPlatform tpla) {
		int id = -1;
		DAOPlatform daoPlatform = DAOAbstractFactory.getInstance().createDAOPlatform();
		if(tpla != null){
			TPlatform tpl = daoPlatform.readByName(tpla.get_name());
			if(tpl == null)
				id = daoPlatform.createPlatform(tpla);
		}
		return id;
	}

	@Override
	public Boolean deletePlatform(Integer id) {
		boolean ret = false;
		DAOPlatform daoPlatform = DAOAbstractFactory.getInstance().createDAOPlatform();
		
		if(id != null) {
			TPlatform ternif = daoPlatform.readPlatform(id);
			// Si devuelve un transfer significa que existe y por lo tanto se procede a borrarlo
			if(ternif != null && ternif.get_activated())
				ret = daoPlatform.deletePlatform(id);
		}
		return ret;
	}

	@Override
	public Boolean updatePlatform(TPlatform tpla) {
		return DAOAbstractFactory.getInstance().createDAOPlatform().updatePlatform(tpla);
	}

	@Override
	public TPlatform readPlatform(Integer id) {
		TPlatform ret = null;
		DAOPlatform daoPlatform = DAOAbstractFactory.getInstance().createDAOPlatform();
		
		if(id != null)
			ret = (TPlatform) daoPlatform.readPlatform(id);
		return ret;
	}

	@Override
	public List<Object> readAllPlatforms() {
		List<Object> platforms = null;
		platforms = DAOAbstractFactory.getInstance().createDAOPlatform().readAllPlatforms();
		return platforms;
	}

	@Override
	public List<Object> readAllProductsOfAPlatform(Object Parameter1) {
		return null;
	}
	
	
}