/**
 * 
 */
package Presentacion.Provider;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Event;
import Transfers.TProvider;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author joalow
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class FormProvider extends JDialog {

	private final JLabel _nif;

	private final JLabel _address;

	private final JLabel _phone;

	private JTextField _nifText;

	private JTextField _addressText;

	private JTextField _phoneText;

	private JButton _ok;

	private JButton _cancel;
	
	public FormProvider(){
		
		this.setLayout(new FlowLayout());
		this.setBounds(new Rectangle(300,150));
		this.setLocationRelativeTo(null);
		
		_nif = new JLabel("nif:");
		_nifText = new JTextField();
		_nifText.setPreferredSize(new Dimension(250,20));
		_nifText.setMaximumSize(new Dimension(250,20));
		_nifText.setMinimumSize(new Dimension(250,20));
		
		_address = new JLabel("address:");
		_addressText = new JTextField();
		_addressText.setPreferredSize(new Dimension(220,20));
		_addressText.setMaximumSize(new Dimension(220,20));
		_addressText.setMinimumSize(new Dimension(220,20));
		
		_phone = new JLabel("phone:");
		_phoneText = new JTextField();
		_phoneText.setPreferredSize(new Dimension(220,20));
		_phoneText.setMaximumSize(new Dimension(220,20));
		_phoneText.setMinimumSize(new Dimension(220,20));
		
		_ok = new JButton("OK");
		_ok.setPreferredSize(new Dimension(50,20));
		_ok.setMaximumSize(new Dimension(50,20));
		_ok.setMinimumSize(new Dimension(50,20));
		
		_cancel = new JButton("Cancel");
		_cancel.setPreferredSize(new Dimension(50,20));
		_cancel.setMaximumSize(new Dimension(50,20));
		_cancel.setMinimumSize(new Dimension(50,20));
		
		this.add(_nif);
		this.add(_nifText);
		this.add(_address);
		this.add(_addressText);
		this.add(_phone);
		this.add(_phoneText);
		
		okButtonAction();
		cancelButtonAction();
		
		this.add(_ok);
		this.add(_cancel);
		
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
	
}