/**
 * 
 */
package Presentacion.Product;

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
@SuppressWarnings("serial")
public class GUIProduct extends JPanel implements IGUI {
	
	private OperationsPanel _leftPane;
	private ShowPanel _rightPane;
	
	public GUIProduct() {
		this.setLayout(new BorderLayout());
		
		this._leftPane = new OperationsPanel(GUIGameshop.TAB_PRODUCT);
		this.add(_leftPane, BorderLayout.WEST);
		_leftPane.setVisible(true);
		
		this._rightPane = new ShowPanel(GUIGameshop.TAB_PRODUCT);
		this.add(_rightPane, BorderLayout.EAST);
		_rightPane.setVisible(true);
	}

	@Override
	public void actualiza(Integer e, Object t) {
		Integer id ;
		switch(e) {
		case Event.RES_REGISTER_PRODUCT_OK:
			break;
		case Event.RES_REGISTER_PRODUCT_FAILED:
			JOptionPane.showMessageDialog(this, "Error when inserting the product into the database.","Failed",JOptionPane.ERROR_MESSAGE);		
			break;
		case Event.RES_UNSUBSCRIBE_PRODUCT_OK:
			break;
		case Event.RES_UNSUBSCRIBE_PRODUCT_FAILED:
			JOptionPane.showMessageDialog(this, "Error when unsubscribing the product from the database.","Failed",JOptionPane.ERROR_MESSAGE);		
			break;
		case Event.RES_MODIFY_PRODUCT_OK:
			break;
		case Event.RES_MODIFY_PRODUCT_FAILED:
			JOptionPane.showMessageDialog(this, "Error when modifying the product from the database.","Failed",JOptionPane.ERROR_MESSAGE);		
			break;
		case Event.RES_READ_PRODUCT_OK:
			break;
		case Event.RES_READ_PRODUCT_FAILED:
			JOptionPane.showMessageDialog(this, "Error when reading the product from the database.","Failed",JOptionPane.ERROR_MESSAGE);		
			break;
		case Event.RES_READALL_PRODUCT_OK:
			break;
		case Event.RES_READALL_PRODUCT_FAILED:
			JOptionPane.showMessageDialog(this, "Error when reading all products from the database.","Failed",JOptionPane.ERROR_MESSAGE);		
			break;	
		}
	}
}