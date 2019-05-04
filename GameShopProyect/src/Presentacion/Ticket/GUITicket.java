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
* @author GameShop
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
		
		this._rightPane = new ShowPanel(GUIGameshop.TAB_TICKET);
		this.add(_rightPane, BorderLayout.EAST);
		_rightPane.setVisible(true);
	}

	@Override
	public void actualiza(Integer e, Object t) {
		switch(e){
		case Event.RES_REGISTER_TICKET_OK:
			Integer id = (Integer)t;
			JOptionPane.showMessageDialog(null, "Ticket " + id + " has been correctly inserted into the database.", "Success",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		case Event.RES_REGISTER_TICKET_FAILED:
			JOptionPane.showConfirmDialog(null, "Error inserting the ticket in the database.", "Failed",
					JOptionPane.ERROR_MESSAGE);
			break;
		case Event.RES_UNSUBSCRIBE_TICKET_OK:
			Integer a = (Integer)t;
			JOptionPane.showMessageDialog(null, "The ticket " + a + " has been properly unsubscribed.", "Success",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		case Event.RES_UNSUBSCRIBE_TICKET_FAILED:
			JOptionPane.showConfirmDialog(null, "Error deleting the ticket in the database.", "Failed",
					JOptionPane.ERROR_MESSAGE);
		case Event.RES_MODIFY_TICKET_OK:
			Integer b = (Integer)t;
			JOptionPane.showMessageDialog(null, "Ticket successfully updated in the database.", "Success",
					JOptionPane.INFORMATION_MESSAGE);
		case Event.RES_MODIFY_TICKET_FAILED:
			JOptionPane.showConfirmDialog(null, "Error while modifying the ticket in the database.", "Failed",
					JOptionPane.ERROR_MESSAGE);
		case Event.RES_READ_TICKET_OK:
			Integer c = (Integer)t;
			// COOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOODDDDDDDDDDDDDDDDDDDDEEEEEEEEEEEEEEEEEEEEEEEEEE
		case Event.RES_READ_TICKET_FAILED:
			JOptionPane.showConfirmDialog(null, "Error showing a ticket in the database.", "Failed",
					JOptionPane.ERROR_MESSAGE);
			break;
		case Event.RES_READALL_TICKET_OK:
			// COOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOODDDDDDDDDDDDDDDDDDDDEEEEEEEEEEEEEEEEEEEEEEEEEE
			break;
		case Event.RES_READALL_TICKET_FAILED:
			JOptionPane.showMessageDialog(this, "Error showing all tickets in the database.","Failed",JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}