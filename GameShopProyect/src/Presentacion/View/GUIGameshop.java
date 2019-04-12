package Presentacion.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import Presentacion.Provider.GUIProvider;

/**
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class GUIGameshop extends JFrame {
	
	public static final String TAB_PROVIDER = "Provider";
	public static final String TAB_PLATFORM = "Platform";
	public static final String TAB_EMPLOYEE = "Employee";
	public static final String TAB_PRODUCT = "Product";
	public static final String TAB_TICKET = "Ticket";
	
	private JTabbedPane _tabs;
	
	public GUIGameshop(String applicationName) {
		super(applicationName);
		initGUI();
	}

	private void initGUI() {
		// TODO MIRAR LA DOCUMENTACION DEL lookAndFell();
		try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception ex){
        	System.err.println("ERROR lookAndFeel");
        }
		this.setSize(new Dimension(700, 500));
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure that you want to close the program?", "Exit",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("resources/GameShopLogo.png").getImage());
		
		this.setLayout(new BorderLayout());
		this.add(new JLabel("  GameShop Application. Developed by UCM FdI students. "
				+ "Department of Software Engineering and artificial intelligence."), BorderLayout.SOUTH);
		initTabs();
		
		this.setVisible(true);
	}

	private void initTabs() {
		_tabs = new JTabbedPane(JTabbedPane.TOP);
		_tabs.setPreferredSize(new Dimension(700, 500));
		_tabs.setMinimumSize(new Dimension(700, 500));
		_tabs.setMaximumSize(new Dimension(700, 500));
		
		_tabs.addTab(GUIGameshop.TAB_PROVIDER, null, new GUIProvider(), "Provider tab");
		
		_tabs.addTab(GUIGameshop.TAB_PLATFORM, null, new JLabel("holaa"), "Platform tab");
		
		_tabs.addTab(GUIGameshop.TAB_EMPLOYEE, null, null, "Employee tab");
		
		_tabs.addTab(GUIGameshop.TAB_PRODUCT, null, null, "Product tab");
		
		_tabs.addTab(GUIGameshop.TAB_TICKET, null, null, "Ticket tab");
		
		this.add(_tabs, BorderLayout.CENTER);
	}
	
}