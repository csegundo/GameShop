/**
 * 
 */
package Presentacion.Platform;

import javax.swing.JPanel;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Event;
import Presentacion.Product.ShowAllProducts;
import Transfers.TEmployee;
import Transfers.TPlatform;
import Transfers.TProvider;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import Negocio.SA.SAAbstractFactory;

import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class ShowProductsFromPlatform extends ShowAllProducts {

	private JComboBox<Object> _election;
	private JButton _show;
	
	public ShowProductsFromPlatform(String nameIdentificator,List<Object> l) {
		super(nameIdentificator,l);
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
				TPlatform tpla = SAAbstractFactory.getInstance().createSAPlatform().readPlatform((Integer)_election.getSelectedItem());
				Controller.getInstance().action(tpla, Event.READ_ALL_PRODUCTS_FROM_PLATFORM);
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
		
		_show = new JButton("Show");
		_show.setAlignmentX(CENTER_ALIGNMENT);
		_show.setSize(new Dimension(100, 30));
		_show.setMinimumSize(new Dimension(100, 30));
		_show.setMaximumSize(new Dimension(100, 30));
		this.add(_show);
		_show.setVisible(true);
		
		this.add(Box.createVerticalGlue());
		
		addShowButtonAction();
		fillList();
	}
	
	public void fillList() {
		_election.removeAllItems();
		for(Object tpla : SAAbstractFactory.getInstance().createSAPlatform().readAllPlatforms())
			_election.addItem(((TPlatform) tpla).get_id());
	}

	
}