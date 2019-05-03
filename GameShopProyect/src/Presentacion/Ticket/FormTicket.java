package Presentacion.Ticket;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.AbstractTableModel;

import Negocio.SA.SAAbstractFactory;
import Transfers.TEmployee;
import Transfers.TProduct;

@SuppressWarnings("serial")
public class FormTicket extends JDialog {
	
	private JLabel _employeeId = new JLabel("Employee");
	private JLabel _products = new JLabel("Products");
	private JLabel _amount = new JLabel("Amount");
	private JComboBox<Object> _employeeElection = new JComboBox<Object>();
	private JComboBox<Object> _productsElection = new JComboBox<Object>();
	private JSpinner _numberOfproduct = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
	private JButton _add;
	private JButton _remove;
	private JButton _accept;
	private JButton _cancel;
	private JTable _grid;
	private String[]_columnIds = {"ID", "Name", "Platform", "Amount"};
	private JScrollPane _jsp;
	
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
		this.setSize(new Dimension(320, 290));
		this.setLocationRelativeTo(null);
		
		initComponents();
		okButtonAction();
		cancelButtonAction();
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
				
			}
		});
	}
	
	private void addButtonAction() {
		_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TProduct toAdd = new TProduct();
				toAdd.set_id((Integer)_productsElection.getSelectedItem());
				toAdd.set_unitsProvided((Integer)_numberOfproduct.getValue());
				/* Hay que añadirlo ahora a la tabla de informacion del alta de ticket:
				 * 1) Acceder a la BD para pillar el ID del producto y su plataforma (con readByName)
				 * 2) */
				
			}
		});
	}
	
	private void fillRegisterTicketLists() {
		// Rellenar la lista de los productos
		for(Object tp : SAAbstractFactory.getInstance().createSAProduct().readAllProducts())
			_productsElection.addItem(((TProduct) tp).get_name());
		
		// Rellenar la lista de los empelados disponibles en la base de datos
		for(Object te : SAAbstractFactory.getInstance().createSAEmployee().readAllEmployees())
			_employeeElection.addItem(((TEmployee) te).get_id());
	}
	
	
	
	
	// METODOS PARA INICIALIZAR LOS COMPONENTES DE LA GUI
	private void initComponents() {
		_employeeId.setAlignmentX(Component.CENTER_ALIGNMENT);
		_products.setAlignmentX(Component.CENTER_ALIGNMENT);
		_amount.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		sizeComponent(_employeeElection, new Dimension(200, 20));
		sizeComponent(_productsElection, new Dimension(200, 20));
		sizeComponent(_numberOfproduct, new Dimension(50, 20));
		
		_add = new JButton("Add");
		sizeComponent(_add, new Dimension(75, 20));
		_remove = new JButton("Remove");
		sizeComponent(_remove, new Dimension(75, 20));
		
		initTable();
		
		_accept = new JButton("Accept");
		sizeComponent(_accept, new Dimension(75, 20));
		_cancel = new JButton("Cancel");
		sizeComponent(_cancel, new Dimension(75, 20));
		
		addComponentToDialog(_employeeId);
		this.add(Box.createRigidArea(new Dimension(10, 1)));
		addComponentToDialog(_employeeElection);
		this.add(Box.createRigidArea(new Dimension(20, 1)));
		addComponentToDialog(_products);
		this.add(Box.createRigidArea(new Dimension(13, 1)));
		addComponentToDialog(_productsElection);
		this.add(Box.createRigidArea(new Dimension(20, 1)));
		addComponentToDialog(_amount);
		addComponentToDialog(_numberOfproduct);
		addComponentToDialog(_add);
		addComponentToDialog(_remove);
		addComponentToDialog(_jsp);
		addComponentToDialog(_accept);
		addComponentToDialog(_cancel);
		this.setVisible(true);
	}
	
	protected void addComponentToDialog(JComponent c) {
		this.add(c);
	}
	
	protected void sizeComponent(JComponent c, Dimension d) {
		c.setPreferredSize(d);
		c.setMinimumSize(d);
		c.setMaximumSize(d);
		c.setAlignmentX(Component.CENTER_ALIGNMENT);
		c.setVisible(true);
	}
	
	private void initTable() {
		AbstractTableModel model = new AbstractTableModel() {
			@Override
			public int getColumnCount() {
				return _columnIds.length;
			}
			@Override
			public int getRowCount() {
				return 10;
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
		_jsp = new JScrollPane(_grid, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sizeComponent(_grid, new Dimension(300, 150));
		sizeComponent(_jsp, new Dimension(300, 150));
		setColumnsWidth();
		_grid.setVisible(true);
	}
	
	private void setColumnsWidth() {
		columnWidth(0, 40);
		columnWidth(1, 110);
		columnWidth(2, 80);
		columnWidth(3, 50);
	}
	
	private void columnWidth(int column, int width) {
		_grid.getColumnModel().getColumn(column).setPreferredWidth(width);
		_grid.getColumnModel().getColumn(column).setMinWidth(width);
		_grid.getColumnModel().getColumn(column).setMaxWidth(width);
	}

	protected void closeDialog() {
		setVisible(false);
		dispose();
	}
	
	private Integer getIDEmp(){
		return _employeeElection.getSelectedIndex(); //devuelve el ID o la posicion ?
	}
}
