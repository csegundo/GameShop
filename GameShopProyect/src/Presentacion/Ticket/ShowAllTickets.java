/**
 * 
 */
package Presentacion.Ticket;

import Presentacion.View.ShowAll;

import java.util.List;
import java.util.Set;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author joalow
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class ShowAllTickets extends ShowAll {
	public ShowAllTickets(String nameIdentificator) {
		super(nameIdentificator);
		// TODO Auto-generated constructor stub
	}

	//private Set<String> _columnsId = null;
	private String[] _columnsId = {"ID","IDEmpleado","Precio","Productos","Comentarios"};

	@Override
	public void update(List<Object> l) {
		// TODO Auto-generated method stub
		
	}
}