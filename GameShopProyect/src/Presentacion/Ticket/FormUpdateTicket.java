package Presentacion.Ticket;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JCheckBox;

import Transfers.TTicket;

@SuppressWarnings("serial")
public class FormUpdateTicket extends FormTicket {
	
	private JCheckBox _reactivate = new JCheckBox("Activated");
	private TTicket _tTicket;
	
	public FormUpdateTicket(TTicket tt) {
		super();
		this.setTitle("Modify a ticket");
		this.setSize(new Dimension(320, 300));
		super.disableEmployeeElection();
		initCheckBox();
		_tTicket = tt;
	}
	
	private void initCheckBox() {
		_reactivate.setPreferredSize(new Dimension(75, 20));
		_reactivate.setMinimumSize(new Dimension(75, 20));
		_reactivate.setMaximumSize(new Dimension(75, 20));
		_reactivate.setAlignmentX(Component.CENTER_ALIGNMENT);
		_reactivate.setVisible(true);
		this.add(_reactivate);
	}
}
