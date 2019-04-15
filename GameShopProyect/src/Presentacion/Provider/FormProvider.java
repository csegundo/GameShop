package Presentacion.Provider;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Event;
import Transfers.TProvider;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class FormProvider extends JDialog {

	private final JLabel _nif = new JLabel("NIF:");
	private final JLabel _address = new JLabel("Address:");
	private final JLabel _phone = new JLabel("Phone:");
	private JTextField _nifText;
	private JTextField _addressText;
	private JTextField _phoneText;
	private JButton _ok;
	private JButton _cancel;
	
	public FormProvider(){
		this.setTitle("Register a provider");
		this.setIconImage(new ImageIcon("resources/GameShopLogo.png").getImage());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new FlowLayout());
		this.setBounds(new Rectangle(300,140));
		this.setLocationRelativeTo(null);
		
		initComponents();
		okButtonAction();
		cancelButtonAction();
		
		this.setVisible(true);
	}
	
	private String getNif(){
		return this._nifText.getText();
	}
	
	private String getAddress(){
		return this._addressText.getText();
	}
	
	private int getPhoneNumber(){
		return Integer.parseInt(this._phoneText.getText());
	}
	
	private void okButtonAction(){
		_ok.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				TProvider tp = new TProvider();
				tp.set_nif(getNif());
				tp.set_address(getAddress());
				tp.set_phoneNumber(getPhoneNumber());
				Controller.getInstance().action(tp, Event.REGISTER_PROVIDER);
			}
		});
	}
	
	private void cancelButtonAction(){
		_cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
	}
	
	private void initComponents() {
		//_nif = new JLabel("NIF:");
		_nifText = new JTextField();
		_nifText.setPreferredSize(new Dimension(220,20));
		_nifText.setMaximumSize(new Dimension(220,20));
		_nifText.setMinimumSize(new Dimension(220,20));
		
		//_address = new JLabel("Address:");
		_addressText = new JTextField();
		_addressText.setPreferredSize(new Dimension(220,20));
		_addressText.setMaximumSize(new Dimension(220,20));
		_addressText.setMinimumSize(new Dimension(220,20));
		
		//_phone = new JLabel("Phone:");
		_phoneText = new JTextField();
		_phoneText.setPreferredSize(new Dimension(220,20));
		_phoneText.setMaximumSize(new Dimension(220,20));
		_phoneText.setMinimumSize(new Dimension(220,20));
		
		_ok = new JButton("OK");
		_ok.setPreferredSize(new Dimension(70,20));
		_ok.setMaximumSize(new Dimension(70,20));
		_ok.setMinimumSize(new Dimension(70,20));
		
		_cancel = new JButton("Cancel");
		_cancel.setPreferredSize(new Dimension(70,20));
		_cancel.setMaximumSize(new Dimension(70,20));
		_cancel.setMinimumSize(new Dimension(70,20));
		
		this.add(_nif);
		this.add(Box.createRigidArea(new Dimension(16, 1)));
		this.add(_nifText);
		this.add(_address);
		this.add(_addressText);
		this.add(_phone);
		this.add(Box.createRigidArea(new Dimension(5, 1)));
		this.add(_phoneText);
		this.add(_ok);
		this.add(_cancel);
	}
	
}