/**
 * 
 */
package Integracion.Provider;

import java.util.List;

import Transfers.TProvider;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author joalow
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface DAOProvider {

	public Integer createProvider(TProvider tp);

	public Boolean deleteProvider(TProvider tp);

	public Boolean updateProvider(TProvider tp);

	public Object readProvider(TProvider tp);

	public List readAllProviders();

	public TProvider readProviderByNIF(String s);
}