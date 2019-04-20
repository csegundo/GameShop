/**
 * 
 */
package Presentacion.Ticket;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Event;
import Transfers.TEmployee;
import Transfers.TProduct;
import Transfers.TTicket;

public class FormTicket extends JDialog{
	private JLabel _employeeId = new JLabel("IDEmpleado");
	private JLabel _products = new JLabel("Productos");
	private JLabel _amount = new JLabel("Cantidad");
	private JComboBox _employeeElection = new JComboBox<TEmployee>();
	private JComboBox _productsElection = new JComboBox<TProduct>();
	private JSpinner _numberOfproduct = new JSpinner();
	private JButton _add;
	private JButton _remove;
	private JButton _accept;
	private JButton _cancel;
	private JTable _grid;
	private String[]_columnIds = { "ID", "NAME", "PLATFORM" };
	public FormTicket(){
		this.setTitle("Add new ticket");
		this.setIconImage(new ImageIcon("resources/GameShopLogo.png").getImage());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				closeDialog();
			}
		});
		
		this.setLayout(new FlowLayout());
		this.setBounds(new Rectangle(300,140));
		this.setLocationRelativeTo(null);
		
		initComponents();
		okButtonAction();
		cancelButtonAction();
		
		this.setVisible(true);
	}
	private void cancelButtonAction() {
		_cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				closeDialog();
			}
		});
	}
	private void okButtonAction() {
		this._accept.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				TTicket tt = new TTicket();
				tt.set_employeeId(getIDEmp());
				//tt.set_productsId(????);
				/*mirar como resolver el problema de ir añadiendo productos y su respectiva cantidad*/
				Controller.getInstance().action(tt, Event.REGISTER_TICKET);
			}
		});
	}
	private void initComponents() {
		
		
	}
	protected void closeDialog() {
		setVisible(false);
		dispose();
	}
	
	private Integer getIDEmp()
	{
		return _employeeElection.getSelectedIndex(); //devuelve el ID o la posicion ?
	}
}