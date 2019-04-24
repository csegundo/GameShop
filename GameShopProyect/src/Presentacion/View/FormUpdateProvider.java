package Presentacion.View;

import javax.swing.JDialog;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Negocio.SA.SAAbstractFactory;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Event;
import Presentacion.Provider.FormProvider;
import Transfers.TProvider;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class FormUpdateProvider extends FormProvider{
	
	private JCheckBox _reactivate;
	private TProvider _provider;
	
	public FormUpdateProvider(TProvider t) {
		super();
		_provider = t;
		this.setTitle("Update Provider");
		
		this._reactivate = new JCheckBox("Activated");
		this._reactivate.setBounds(200, 240, 140, 30);;
		this._reactivate.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				if(_reactivate.isSelected()) {
					_provider.set_activated(true);
					_reactivate.setEnabled(false);
				}else
					_provider.set_activated(false);
			}
			
		});
		initForm();
		
		this.add(this._reactivate);
	}
	
	private void initForm() {
		this._nifText.setText(_provider.get_nif());
		this._addressText.setText(_provider.get_address());
		this._phoneText.setText(_provider.get_phoneNumber().toString());
		
		if(_provider.get_activated())
			this._reactivate.setEnabled(false);
	}
	
	@Override
	protected void okButtonAction(){ //LLAMAR/CREAR EVENT.UPDATE_PROVIDER
		_ok.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				_provider.set_nif(_nifText.getText());
				_provider.set_address(_addressText.getText());
				_provider.set_phoneNumber(Integer.parseInt(_phoneText.getText()));
				Controller.getInstance().action(_provider, Event.MODIFY_PROVIDER);
				closeDialog();
			}
		});
	}
}