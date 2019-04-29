package Presentacion.View;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Negocio.SA.SAAbstractFactory;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Event;
import Presentacion.Employee.FormEmployee;
import Presentacion.Platform.FormPlatform;
import Presentacion.Product.FormProduct;
import Presentacion.Provider.FormProvider;
import Presentacion.Ticket.FormTicket;
import Transfers.TEmployee;
import Transfers.TProvider;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JComboBox<Object> _election;
	private JButton _remove;
	private JButton _update;
	private JLabel _registerLabel;
	private JLabel _updaterLabel;
	//private FormUpdateProvider _info;

	private String nameIdentificator;
	
	public OperationsPanel(String guiNameIdentificator) {
		this.nameIdentificator = guiNameIdentificator.toLowerCase();
		initPanel();
	}
	
	public void initPanel() {
		this.setPreferredSize(new Dimension(300, 700));
		this.setMinimumSize(new Dimension(300, 700));
		this.setMaximumSize(new Dimension(300, 700));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "Operations",
				TitledBorder.LEFT, TitledBorder.TOP));
		
		initComponents();
		
		this.setVisible(true);
	}

	private void registerButtonAction(){
		_register.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(nameIdentificator){
				case "provider":
					new FormProvider();
					break;
				case "platform":
					new FormPlatform();
					break;
				case "employee":
					new FormEmployee();
					break;
				case "product":
					new FormProduct();
					break;
				case "ticket":
					new FormTicket();
					break;
				}
			}
		});
	}
	
	private void updateButtonAction() {
		this._update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(nameIdentificator){
				case "provider":
					Controller.getInstance().action(_election.getSelectedItem(), Event.MODIFYBUTTON_PROVIDER);
					break;
				case "platform":
					break;
				case "employee":
					Controller.getInstance().action(_election.getSelectedItem(), Event.MODIFYBUTTON_EMPLOYEE);
					break;
				case "product":
					break;
				case "ticket":
					break;
				}
			}
		});
	}

	private void deleteButtonAction() {
		_remove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(nameIdentificator){
				case "provider":
					Controller.getInstance().action(_election.getSelectedItem(), Event.UNSUBSCRIBE_PROVIDER);
					break;
				case "platform":
					break;
				case "employee":
					Controller.getInstance().action(_election.getSelectedItem(), Event.UNSUBSCRIBE_EMPLOYEE);
					break;
				case "product":
					break;
				case "ticket":
					break;
				}
			}
		});
	}

	private void addInfoToComboBox() {
		switch(nameIdentificator){
		case "provider":
			for(TProvider tpro : SAAbstractFactory.getInstance().createSAProvider().readAllProviders())
				_election.addItem(tpro.get_id());
			break;
		case "platform":
			break;
		case "employee":
			for(TEmployee temp : SAAbstractFactory.getInstance().createSAEmployee().readAllEmployees())
				_election.addItem(temp.get_id());
			break;
		case "product":
			break;
		case "ticket":
			break;
		}
	}
	
	private void initComponents() {
		this.add(Box.createVerticalGlue());
		_registerLabel = new JLabel("Register a new " + nameIdentificator);
		_registerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		_registerLabel.setVisible(true);
		this.add(_registerLabel);
		
		this.add(Box.createRigidArea(new Dimension(1, 10)));
		
		_register = new JButton("Register " + nameIdentificator);
		_register.setAlignmentX(Component.CENTER_ALIGNMENT);
		_register.setSize(new Dimension(100, 50));
		_register.setVisible(true);
		this.add(_register);
		
		this.add(Box.createVerticalGlue());
		
		_updaterLabel = new JLabel("Modify or remove a " + nameIdentificator);
		_updaterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		_updaterLabel.setVisible(true);
		this.add(_updaterLabel);
		
		this.add(Box.createRigidArea(new Dimension(1, 10)));
		
		// Aqui llamar a algun metodo que se encargue rellenar la lista con los datos de la base de datos
		_election = new JComboBox<Object>();
		_election.setAlignmentX(Component.CENTER_ALIGNMENT);
		_election.setSize(new Dimension(150, 50));
		_election.setBounds(new Rectangle(50, 150));
		_election.setMinimumSize(new Dimension(150, 50));
		_election.setMaximumSize(new Dimension(150, 50));
		_election.setEditable(false);
		_election.setVisible(true);
		this.add(_election);
		
		this.add(Box.createRigidArea(new Dimension(1, 20)));
		
		_update = new JButton("Modify " + nameIdentificator);
		_update.setAlignmentX(Component.CENTER_ALIGNMENT);
		_update.setSize(new Dimension(100, 50));
		_update.setVisible(true);
		this.add(_update);
		
		this.add(Box.createRigidArea(new Dimension(1, 10)));
		
		_remove = new JButton("Remove " + nameIdentificator);
		_remove.setAlignmentX(Component.CENTER_ALIGNMENT);
		_remove.setSize(new Dimension(100, 50));
		_remove.setVisible(true);
		this.add(_remove);
		
		this.add(Box.createVerticalGlue());
		
		addInfoToComboBox();
		registerButtonAction();
		deleteButtonAction();
		updateButtonAction();
	}
	
}