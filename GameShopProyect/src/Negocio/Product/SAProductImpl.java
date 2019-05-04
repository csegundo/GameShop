package Negocio.Product;

import java.util.List;

import Integracion.DAO.DAOAbstractFactory;
import Transfers.TPlatform;
import Transfers.TProduct;
import Transfers.TProvider;
import Transfers.TAccessory;
import Transfers.TGame;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class SAProductImpl implements SAProduct {
	
	public Integer createProduct(Object tpr) {
		TPlatform tpl;
		TProvider tprd;
		
		if(((TProduct)tpr).get_name().trim().isEmpty())
			return 0;
		if(((TProduct)tpr).get_unitsProvided() <= 0)
			return 0;
		if(((TProduct)tpr).get_pvp() < 0)
			return 0;
		if((tpl = DAOAbstractFactory.getInstance().createDAOPlatform().readPlatform(((TProduct)tpr).get_platformId())) == null || !tpl.get_activated())
			return 0;
		if((tprd = (TProvider) DAOAbstractFactory.getInstance().createDAOProvider().readProvider(((TProduct)tpr).get_providerId())) == null || !tprd.get_activated())
			return 0;
		if(((TProduct)tpr).get_type() == TProduct.accessory) {
			if(((TAccessory)tpr).get_brand().isEmpty())
				return 0;
			if(((TAccessory)tpr).get_color().isEmpty())
				return 0;
		}else {
			if(((TGame)tpr).get_description().isEmpty())
				return 0;
			if(((TGame)tpr).get_gender().isEmpty())
				return 0;
		}
		
		TProduct tp;
		if ((tp = DAOAbstractFactory.getInstance().createDAOProduct().readProductByName((TProduct)tpr)) != null)
			return 0;
		
		return DAOAbstractFactory.getInstance().createDAOProduct().createProduct(tpr);
	}

	public Boolean deleteProduct(Object tpr) {
		TProduct tp = (TProduct) DAOAbstractFactory.getInstance().createDAOProduct().readProduct(tpr);
		if (tp.get_activated())
			return DAOAbstractFactory.getInstance().createDAOProduct().deleteProduct(tp);
		return false;
	}

	public Boolean updateProduct(Object tpr) {
		TPlatform tpl;
		TProvider tprd;
		
		if(((TProduct)tpr).get_name().trim().isEmpty())
			return false;
		if(((TProduct)tpr).get_stock() < 0)
			return false;
		if(((TProduct)tpr).get_pvp() < 0)
			return false;
		if((tpl = DAOAbstractFactory.getInstance().createDAOPlatform().readPlatform(((TProduct)tpr).get_platformId())) == null || !tpl.get_activated())
			return false;
		if((tprd = (TProvider) DAOAbstractFactory.getInstance().createDAOProvider().readProvider(((TProduct)tpr).get_providerId())) == null || !tprd.get_activated())
			return false;
		if(((TProduct)tpr).get_type() == TProduct.accessory) {
			if(((TAccessory)tpr).get_brand().isEmpty())
				return false;
			if(((TAccessory)tpr).get_color().isEmpty())
				return false;
		}else {
			if(((TGame)tpr).get_description().isEmpty())
				return false;
			if(((TGame)tpr).get_gender().isEmpty())
				return false;
		}
		
		if(((TProduct)tpr).get_stock() > ((TProduct)tpr).get_unitsProvided())
			((TProduct)tpr).set_unitsProvided(((TProduct)tpr).get_stock()-((TProduct)tpr).get_unitsProvided());
		else
			((TProduct)tpr).set_unitsProvided(0);
		
		return  DAOAbstractFactory.getInstance().createDAOProduct().updateProduct(tpr);
	}

	public Object readProduct(Object tpr) {
		return DAOAbstractFactory.getInstance().createDAOProduct().readProduct(tpr);
	}

	public List<Object> readAllProducts() {
		return DAOAbstractFactory.getInstance().createDAOProduct().readAllProducts();
	}
}