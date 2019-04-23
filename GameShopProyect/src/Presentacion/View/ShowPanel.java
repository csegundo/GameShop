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
	private String nameIdentificator;
	
	public ShowPanel(String nameIdentificator) {
		this.nameIdentificator = nameIdentificator.toLowerCase();
		initPanel();
	}

	private void initPanel() {
		this.setPreferredSize(new Dimension(390, 700));
		this.setMinimumSize(new Dimension(390, 700));
		this.setMaximumSize(new Dimension(390, 700));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "Data information",
				TitledBorder.LEFT, TitledBorder.TOP));
		
		initTabs();
		
		this.setVisible(true);
	}

	private void initTabs() {
		_tabs = new JTabbedPane(JTabbedPane.TOP);
		_tabs.setPreferredSize(new Dimension(400, 300));
		_tabs.setVisible(true);
		
		// TODO caso para PROVEEDOR
		_tabs.addTab("Show one", null, new ShowOne(), "Show the data of the selected " + nameIdentificator);
		_tabs.addTab("Show all", null, new ShowAll(), "Show the data of all " + nameIdentificator);
		
		this.add(_tabs);		
	}
	
}