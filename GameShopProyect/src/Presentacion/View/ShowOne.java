package Presentacion.View;

import javax.swing.JPanel;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Event;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class ShowOne extends JPanel {
	
	private JComboBox<Object> _election;
	private JButton _show;
	private JTextArea _info;
	private String nameIdentificator;
	
	public ShowOne(String nameIdentificator) {
		this.nameIdentificator = nameIdentificator.toLowerCase();
		initGUI();
	}

	private void initGUI() {
		this.setPreferredSize(new Dimension(400, 300));
		this.setMinimumSize(new Dimension(400, 300));
		this.setMaximumSize(new Dimension(400, 300));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		initComponents();
		
		this.setVisible(true);
	}
	
	private void addShowButtonAction() {
		_show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(nameIdentificator){
				case "provider":
					Controller.getInstance().action(_election.getSelectedItem(), Event.READ_PROVIDER);
					break;
				case "platform":
					break;
				case "employee":
					break;
				case "product":
					break;
				case "ticket":
					break;
				}
			}
		});
	}

	private void initComponents() {
		this.add(Box.createVerticalGlue());
		
		_election = new JComboBox<Object>();
		_election.setPreferredSize(new Dimension(200, 20));
		_election.setMinimumSize(new Dimension(200, 20));
		_election.setMaximumSize(new Dimension(200, 20));
		_election.setEditable(false);
		_election.setVisible(true);
		this.add(_election);
		
		this.add(Box.createRigidArea(new Dimension(1, 10)));
		
		_show = new JButton("Show data");
		_show.setAlignmentX(CENTER_ALIGNMENT);
		_show.setSize(new Dimension(100, 30));
		_show.setMinimumSize(new Dimension(100, 30));
		_show.setMaximumSize(new Dimension(100, 30));
		this.add(_show);
		_show.setVisible(true);
		
		this.add(Box.createRigidArea(new Dimension(1, 30)));
		
		_info = new JTextArea("");
		_info.setWrapStyleWord(true);
		_info.setLineWrap(true);
		_info.setPreferredSize(new Dimension(300, 190));
		_info.setMinimumSize(new Dimension(300, 190));
		_info.setMaximumSize(new Dimension(300, 190));
		_info.setEditable(true);
		_info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "Detailed data",
				TitledBorder.LEFT, TitledBorder.TOP));
		_info.setFont(new Font("Arial", 0, 15));
		_info.setVisible(true);
		this.add(_info);
		
		this.add(Box.createVerticalGlue());
		
		addShowButtonAction();
		fillProviderList();
	}

	private void fillProviderList() {
		_election.addItem(new Integer(85));
	}

	public void set_info(String text) {
		_info.setText(text);
	}
}