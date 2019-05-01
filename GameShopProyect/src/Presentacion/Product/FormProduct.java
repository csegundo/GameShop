/**
 * 
 */
package Presentacion.Product;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;

import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class FormProduct extends JDialog {

	private JLabel _name;
	private JLabel _stock;
	private JLabel _type;
	private JLabel _gender;
	private JLabel _employee;
	private JLabel _plattform;
	private JLabel _pvp;
	private JTextField _nameText;
	private JSpinner _stockInt;
	private JComboBox _typeElection;
	private JTextField _genderText;
	private JComboBox _employeeElection;
	private JComboBox _plattformElection;
	private JSpinner _pvpInt;
	
	public FormProduct() {
		this.setTitle("Register a product");
		this.setIconImage(new ImageIcon("resources/GameShopLogo.png").getImage());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		
		this.setLayout(new FlowLayout());
		this.setBounds(new Rectangle(300, 140));
		this.setLocationRelativeTo(null);
		
		initComponents();
		okButtonAction();
		cancelButtonAction();
		
		this.setVisible(true);
	}
	
	private void initComponents() {
		
	}
	
	private void okButtonAction() {
		
	}
	
	private void cancelButtonAction() {
		
	}
}