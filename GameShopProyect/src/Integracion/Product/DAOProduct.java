package Integracion.Product;

import java.util.List;

import Transfers.TProduct;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface DAOProduct {
	
	public Integer createProduct(Object tpr);
	public Boolean deleteProduct(Object tpr);
	public Boolean updateProduct(Object tpr);
	public Object readProduct(Object tp);
	public List<Object> readAllProducts();
	public TProduct readProductByName(Object tpr);
	// METODO PARA DIFERENCIAR DE SI ES UN JUEGO O UN ACCESORIO
}