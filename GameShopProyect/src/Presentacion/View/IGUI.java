package Presentacion.View;

import Transfers.TProduct;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface IGUI {
	public void actualiza(Integer event, Object id);
	static public Object getInfoFromBox(String str) {
		String id ="";	String type="";

		int i = 0;
		while(str.charAt(i) != '-') {
			id += str.charAt(i);
			i++;
		}++i;
		int n = str.length();
		while(i < str.length()) {
			type += str.charAt(i);
			++i;
		}
		if(type.equals(TProduct.accessory) || type.equals(TProduct.game)) {
			TProduct tp = new TProduct();
			tp.set_id(Integer.parseInt(id));
			tp.set_type(type);
			return tp;
		}
		return id;
	}
}