package Presentacion.View;

import javax.swing.JPanel;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class ShowOne extends JPanel {
	
	private JComboBox<Object> _election;
	private JButton _show;
	private JTextArea _info;
	
	public ShowOne() {
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
		
		_info = new JTextArea();
		_info.setWrapStyleWord(true);
		_info.setLineWrap(true);
		_info.setPreferredSize(new Dimension(300, 190));
		_info.setMinimumSize(new Dimension(300, 190));
		_info.setMaximumSize(new Dimension(300, 190));
		_info.setEditable(false);
		_info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "Detailed data",
				TitledBorder.LEFT, TitledBorder.TOP));
		_info.setFont(new Font("Arial", 0, 15));
		_info.setVisible(true);
		this.add(_info);
		
		this.add(Box.createVerticalGlue());
	}
}