package Presentacion.View;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import Presentacion.Provider.FormProvider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
	private FormUpdate _info;

	private String nameIdentificator;
	
	public OperationsPanel(String guiNameIdentificator) {
		this.nameIdentificator = guiNameIdentificator;
		initPanel();
	}
	
	public void initPanel() {
		this.setPreferredSize(new Dimension(300, 700));
		this.setMinimumSize(new Dimension(300, 700));
		this.setMaximumSize(new Dimension(300, 700));
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), "Operations",
				TitledBorder.LEFT, TitledBorder.TOP));
		
		initComponents();
		this.setVisible(true);
	}
	
	private void initComponents() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		//constraints.weighty = 1.0;
		
		_registerLabel = new JLabel("Register a new provider by entering the data");
		constraints.gridx = 0; // El texto empieza en la columna cero
		constraints.gridy = 1; // El texto empieza en la fila uno
		constraints.gridwidth = 1; // El texto ocupa una columna
		constraints.gridheight = 1; // El texto ocupa 1 fila/
		this.add(_registerLabel, constraints);
		//constraints.weighty = 0.0; // Restauramos al valor por defecto, para no afectar a los siguientes componentes
		
		_register = new JButton("Register Provider");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(_register, constraints);
		constraints.weighty = 1.0;
		
		_updaterLabel = new JLabel("Modify or remove a provider from the list");
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(_updaterLabel, constraints);
		
		_election = new JComboBox<Object>();
		_election.setPreferredSize(new Dimension(200, 20));
		_election.setMinimumSize(new Dimension(200, 50));
		_election.setMaximumSize(new Dimension(200, 50));
		_election.setEditable(false);
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(_election, constraints);
		
		_update = new JButton("Modify provider");
		_update.setSize(new Dimension(100, 50));
		_update.setMinimumSize(new Dimension(100, 50));
		_update.setMaximumSize(new Dimension(100, 50));
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(_update, constraints);
		
		_remove = new JButton("Remove provider");
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.add(_remove, constraints);
		
		registerButtonAction();

		/*this.add(Box.createVerticalGlue());
		_registerLabel = new JLabel("Register a new provider by entering the data");
		_registerLabel.setVisible(true);
		this.add(_registerLabel);
		
		this.add(Box.createRigidArea(new Dimension(1, 10)));
		
		_register = new JButton("Register Provider");
		_register.setSize(new Dimension(100, 50));
		_register.setVisible(true);
		this.add(_register);
		
		this.add(Box.createVerticalGlue());
		
		_updaterLabel = new JLabel("Modify or remove a provider from the list");
		_updaterLabel.setVisible(true);
		this.add(_updaterLabel);
		
		this.add(Box.createRigidArea(new Dimension(1, 10)));
		
		// Aqui llamar a algun metodo que se encargue rellenar la lista con los datos de la base de datos
		_election = new JComboBox<Object>();
		_election.setSize(new Dimension(200, 50));
		_election.setMinimumSize(new Dimension(200, 50));
		_election.setMaximumSize(new Dimension(200, 50));
		_election.setEditable(false);
		_election.setVisible(true);
		this.add(_election);
		
		this.add(Box.createRigidArea(new Dimension(1, 20)));
		
		_update = new JButton("Modify provider");
		_update.setSize(new Dimension(100, 50));
		_update.setVisible(true);
		this.add(_update);
		
		this.add(Box.createRigidArea(new Dimension(1, 10)));
		
		_remove = new JButton("Remove provider");
		_remove.setSize(new Dimension(100, 50));
		_remove.setVisible(true);
		this.add(_remove);
		
		this.add(Box.createVerticalGlue());*/
	}

	private void registerButtonAction(){
		_register.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				switch(nameIdentificator){
				case "Provider":
					new FormProvider();
					break;
				case "Platform":
					break;
				case "Employee":
					break;
				case "Product":
					break;
				case "Ticket":
					break;
				}
			}
			
		});
	}
}