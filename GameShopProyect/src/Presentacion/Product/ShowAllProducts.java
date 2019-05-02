/**
 * 
 */
package Presentacion.Product;

import Presentacion.View.ShowAll;

import java.util.List;
import java.util.Set;


public class ShowAllProducts extends ShowAll {
	
	private Set<String> _columnsId = null;
	
	public ShowAllProducts(String nameIdentificator) {
		super(nameIdentificator);
	}

	@Override
	public void update(List<Object> l) {
	}
}