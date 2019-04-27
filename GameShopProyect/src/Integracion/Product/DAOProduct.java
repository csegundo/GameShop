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
	public Object readProduct(Object tpr);
	public List<TProduct> readAllProducts();
	public Integer readProductByName(String s);
	public List<Object> readAllProductsOfAPlattform(Object tpl);
	// METODO PARA DIFERENCIAR DE SI ES UN JUEGO O UN ACCESORIO
}