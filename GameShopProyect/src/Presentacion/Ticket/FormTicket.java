package Presentacion.Ticket;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.AbstractTableModel;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Event;
import Transfers.TEmployee;
import Transfers.TProduct;
import Transfers.TProvider;
import Transfers.TTicket;

@SuppressWarnings("serial")
public class FormTicket extends JDialog{
	
	private JLabel _employeeId = new JLabel("Employee");
	private JLabel _products = new JLabel("Products");
	private JLabel _amount = new JLabel("Amount");
	private JComboBox<TEmployee> _employeeElection = new JComboBox<TEmployee>();
	private JComboBox<TProduct> _productsElection = new JComboBox<TProduct>();
	private JSpinner _numberOfproduct = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
	private JButton _add;
	private JButton _remove;
	private JButton _accept;
	private JButton _cancel;
	private JTable _grid;
	private String[]_columnIds = {"ID", "Name", "Platform", "Amount"};
	
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
		this.setSize(new Dimension(300, 300));
		//this.setBounds(new Rectangle(300, 350));
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
		_accept.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
//				TTicket tt = new TTicket();
//				tt.set_employeeId(getIDEmp());
//				//tt.set_productsId(????);
//				/*mirar como resolver el problema de ir añadiendo productos y su respectiva cantidad*/
//				Controller.getInstance().action(tt, Event.REGISTER_TICKET);
			}
		});
	}
	private void initComponents() {
		
		initTable();
		
		_employeeElection = new JComboBox<TEmployee>();
		_employeeElection.setPreferredSize(new Dimension(150, 20));
		_employeeElection.setMinimumSize(new Dimension(150, 20));
		_employeeElection.setMaximumSize(new Dimension(150, 20));
		_employeeElection.setEditable(false);
		_employeeElection.setVisible(true);
		
		_productsElection = new JComboBox<TProduct>();
		_productsElection.setPreferredSize(new Dimension(150, 20));
		_productsElection.setMinimumSize(new Dimension(150, 20));
		_productsElection.setMaximumSize(new Dimension(150, 20));
		_productsElection.setEditable(false);
		_productsElection.setVisible(true);
		
		_numberOfproduct.setPreferredSize(new Dimension(150, 20));
		_numberOfproduct.setMinimumSize(new Dimension(150, 20));
		_numberOfproduct.setMaximumSize(new Dimension(150, 20));
		_numberOfproduct.setVisible(true);
		
		_add = new JButton("Add product");
		_add.setPreferredSize(new Dimension(100,20));
		_add.setMaximumSize(new Dimension(100,20));
		_add.setMinimumSize(new Dimension(100,20));
		
		_remove = new JButton("Remove product");
		_remove.setPreferredSize(new Dimension(120,20));
		_remove.setMaximumSize(new Dimension(120,20));
		_remove.setMinimumSize(new Dimension(120,20));
		
		_grid.setBounds(new Rectangle(100, 100));
		_grid.setPreferredSize(new Dimension(100, 100));
		_grid.setMinimumSize(new Dimension(100, 100));
		_grid.setMaximumSize(new Dimension(100, 100));
		//_grid.setBounds(new Rectangle(50, 60));
		setColumnsWidth();
		
		_accept = new JButton("OK");
		_accept.setPreferredSize(new Dimension(70,20));
		_accept.setMaximumSize(new Dimension(70,20));
		_accept.setMinimumSize(new Dimension(70,20));
		
		_cancel = new JButton("Cancel");
		_cancel.setPreferredSize(new Dimension(70,20));
		_cancel.setMaximumSize(new Dimension(70,20));
		_cancel.setMinimumSize(new Dimension(70,20));
		
		this.add(_employeeId);
		this.add(_employeeElection);
		this.add(_products);
		this.add(_productsElection);
		this.add(_amount);
		this.add(_numberOfproduct);
		this.add(_add);
		this.add(_remove);
		//this.add(_grid);
		this.add(new JScrollPane(_grid, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		this.add(_accept);
		this.add(_cancel);
		
	}
	
	private void initTable() {
		AbstractTableModel model = new AbstractTableModel() {

			@Override
			public int getColumnCount() {
				return _columnIds.length;
			}

			@Override
			public int getRowCount() {
				return 100;
			}

			@Override
			public Object getValueAt(int arg0, int arg1) {
				return null;
			}

			@Override
			public String getColumnName(int column) {
				return _columnIds[column];
			}

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		_grid = new JTable(model);
		_grid.setVisible(true);
	}
	
	private void setColumnsWidth() {
		_grid.getColumnModel().getColumn(0).setWidth(20);
		_grid.getColumnModel().getColumn(0).setPreferredWidth(20);
		_grid.getColumnModel().getColumn(0).setMaxWidth(20);
		_grid.getColumnModel().getColumn(0).setMinWidth(20);
		
		_grid.getColumnModel().getColumn(1).setWidth(65);
		_grid.getColumnModel().getColumn(1).setPreferredWidth(65);
		_grid.getColumnModel().getColumn(1).setMaxWidth(65);
		_grid.getColumnModel().getColumn(1).setMinWidth(65);
		
		_grid.getColumnModel().getColumn(2).setWidth(65);
		_grid.getColumnModel().getColumn(2).setPreferredWidth(65);
		_grid.getColumnModel().getColumn(2).setMaxWidth(65);
		_grid.getColumnModel().getColumn(2).setMinWidth(65);
	}
	
	protected void closeDialog() {
		setVisible(false);
		dispose();
	}
	
	private Integer getIDEmp(){
		return _employeeElection.getSelectedIndex(); //devuelve el ID o la posicion ?
	}
}