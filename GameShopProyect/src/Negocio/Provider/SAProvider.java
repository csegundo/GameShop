package Negocio.Provider;

import java.util.List;

import Transfers.TProvider;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface SAProvider {

	public Integer createProvider(TProvider tp);
	public Boolean deleteProvider(TProvider tp);
	public Boolean updateProvider(TProvider tp);
	public Object readProvider(TProvider tp);
	public List<Object> readAllProviders();
}