/**
 * 
 */
package Presentacion.Ticket;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Presentacion.View.GUIGameshop;
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
public class GUITicket extends JPanel implements IGUI {
	

	private static final long serialVersionUID = 1L;
	private OperationsPanel _leftPane;
	private ShowPanel _rightPane;

	public GUITicket() {
		alignmentPanels();
	}
	
	private void alignmentPanels() {
		this.setLayout(new BorderLayout());
		
		this._leftPane = new OperationsPanel(GUIGameshop.TAB_TICKET);
		this.add(_leftPane, BorderLayout.WEST);
		_leftPane.setVisible(true);
		
		this._rightPane = new ShowPanel();
		this.add(_rightPane, BorderLayout.EAST);
		_rightPane.setVisible(true);
	}

	@Override
	public void actualiza(Integer e, Object t) {
		switch(e){
		case Event.RES_REGISTER_PROVIDER_OK:
			Integer id = (Integer)t;
			JOptionPane.showMessageDialog(null, "Se ha insertado el proveedor " + id + " correctamente en la base de datos.", "Success",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		case Event.RES_REGISTER_PROVIDER_FAILED:
			JOptionPane.showConfirmDialog(null, "Error al insertar el proveedor en la base de datos.", "Failed",
					JOptionPane.ERROR_MESSAGE, JOptionPane.OK_OPTION);
			break;
		case Event.RES_UNSUBSCRIBE_PROVIDER_OK:
			Integer a = (Integer)t;
			JOptionPane.showMessageDialog(null, "Se ha eliminado el proveedor " + a + " correctamente en la base de datos.", "Success",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		case Event.RES_UNSUBSCRIBE_PROVIDER_FAILED:
			JOptionPane.showConfirmDialog(null, "Error al eliminar el proveedor en la base de datos.", "Failed",
					JOptionPane.ERROR_MESSAGE, JOptionPane.OK_OPTION);
			break;
		}
	}
}