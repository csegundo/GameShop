package Presentacion.Provider;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import Presentacion.View.IGUI;
import Presentacion.View.OperationsPanel;
import Presentacion.View.ShowPanel;
import Presentacion.Controller.Event;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class GUIProvider extends JPanel implements IGUI {
	
	private OperationsPanel _leftPane;
	private ShowPanel _rightPane;
	
	public GUIProvider() {
		alignmentPanels();
	}
	
	private void alignmentPanels() {
		this.setLayout(new BorderLayout());
		this._leftPane = new OperationsPanel();
		this.add(_leftPane, BorderLayout.WEST);
		_leftPane.setVisible(true);
		this._rightPane = new ShowPanel();
		this.add(_rightPane, BorderLayout.EAST);
		_rightPane.setVisible(true);
	}
	
	public void actualiza(Event e, Object t) {
		
	}
}