/**
 * 
 */
package Presentacion.Platform;

import javax.swing.JPanel;
import Presentacion.View.IGUI;
import Presentacion.View.OperationsPanel;
import Presentacion.View.ShowPanel;
import Presentacion.Controller.Event;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author joalow
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIPlattform extends JPanel implements IGUI {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private OperationsPanel _leftPane;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private ShowPanel _rightPane;

	/** 
	* (non-Javadoc)
	* @see IGUI#actualiza(Event e, Object t)
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void actualiza(Event e, Object t) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void actualiza(Integer e, Object t) {
	}
}