package Presentacion.Employee;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Presentacion.Controller.Event;
import Presentacion.View.GUIGameshop;
import Presentacion.View.IGUI;
import Presentacion.View.OperationsPanel;
import Presentacion.View.ShowPanel;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class GUIEmployee extends JPanel implements IGUI {
	
	private OperationsPanel _leftPane;
	private ShowPanel _rightPane;
	
	public GUIEmployee() {
		alignmentPanels();
	}

	private void alignmentPanels() {
		this.setLayout(new BorderLayout());
		
		this._leftPane = new OperationsPanel(GUIGameshop.TAB_PROVIDER);
		this.add(_leftPane, BorderLayout.WEST);
		_leftPane.setVisible(true);
		
		this._rightPane = new ShowPanel();
		this.add(_rightPane, BorderLayout.EAST);
		_rightPane.setVisible(true);
	}

	@Override
	public void actualiza(Integer e, Integer t) {
		switch(e){
		case Event.RES_REGISTER_EMPLOYEE_OK:
			JOptionPane.showConfirmDialog(null, "Se ha insertado el proveedor correctamente en la base de datos.", "Success",
					JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_OPTION);
			//jd.add(new JLabel("Se ha insertado el proveedor correctamente en la base de datos."));
			break;
		case Event.RES_REGISTER_EMPLOYEE_FAILED:
			JOptionPane.showConfirmDialog(null, "Error al insertar el proveedor en la base de datos.", "Failed", JOptionPane.ERROR_MESSAGE, 
					JOptionPane.OK_OPTION);
			//jd.add(new JLabel("Error al insertar el proveedor en la base de datos."));
			break;
		}
	}
}