package Presentacion.View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class ShowPanel extends JPanel {
	
	private JTabbedPane _tabs;
	
	public ShowPanel() {
		initPanel();
	}

	private void initPanel() {
		this.setPreferredSize(new Dimension(390, 700));
		this.setMinimumSize(new Dimension(390, 700));
		this.setMaximumSize(new Dimension(390, 700));
		// Border, Box o Flow ????
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), "Data information",
				TitledBorder.LEFT, TitledBorder.TOP));
		initComponents();
		this.setVisible(true);
	}

	private void initComponents() {
		_tabs = new JTabbedPane(JTabbedPane.TOP);
		_tabs.setPreferredSize(new Dimension(400, 700));
		_tabs.setVisible(true);
		_tabs.addTab("Show one", null, null, "Show the data of the selected provider");
		_tabs.addTab("Show all", null, null, "Show the data of all providers");
		this.add(_tabs);
		
		
		
	}
}