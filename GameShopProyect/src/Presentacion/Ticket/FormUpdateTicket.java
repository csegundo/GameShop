package Presentacion.Ticket;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JCheckBox;

import Transfers.TTicket;

@SuppressWarnings("serial")
public class FormUpdateTicket extends FormTicket {
	
	private TTicket _tTicket;
	
	public FormUpdateTicket(TTicket tt) {
		super();
		this.setTitle("Modify a ticket");
		this.setSize(new Dimension(320, 300));
		super.disableEmployeeElection();
		_tTicket = tt;
	}
}
