package Presentacion.View;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class OperationsPanel extends JPanel {
	
	private JButton _register;
	private JComboBox _election;
	private JButton _remove;
	private JButton _update;
	private JLabel _registerLabel;
	private JLabel _updaterLabel;
	private FormUpdate _info;
	
	public OperationsPanel() {
		initPanel();
	}
	
	public void initPanel() {
		this.setPreferredSize(new Dimension(300, 700));
		this.setMinimumSize(new Dimension(300, 700));
		this.setMaximumSize(new Dimension(300, 700));
		// Border, Box o Flow ????
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), "Operations",
				TitledBorder.LEFT, TitledBorder.TOP));
		
		initComponents();
		this.setVisible(true);
	}
	
	// TODO PONER MEJOR setBounds EN VEZ DE setSize
	private void initComponents() {
		this.add(Box.createVerticalGlue());
		_registerLabel = new JLabel("Register a new provider by entering the data");
		_registerLabel.setVisible(true);
		this.add(_registerLabel);
		
		_register = new JButton("Register Provider");
		_register.setSize(new Dimension(100, 50));
		_register.setVisible(true);
		this.add(_register);
		
		this.add(Box.createVerticalGlue());
		
		_updaterLabel = new JLabel("Modify or remove a provider from the list");
		_updaterLabel.setVisible(true);
		this.add(_updaterLabel);
		
		// Aqui llamar a algun metodo que se encargue rellenar la lista con los datos de la base de datos
		_election = new JComboBox<Object>();
		_election.setSize(new Dimension(200, 50));
		_election.setMinimumSize(new Dimension(200, 50));
		_election.setMaximumSize(new Dimension(200, 50));
		_election.setVisible(true);
		this.add(_election);
		
		_update = new JButton("Delete provider");
		_update.setSize(new Dimension(100, 50));
		_update.setVisible(true);
		this.add(_update);
		
		_remove = new JButton("Modify provider");
		_remove.setSize(new Dimension(100, 50));
		_remove.setVisible(true);
		this.add(_remove);
		
		this.add(Box.createVerticalGlue());
	}
}