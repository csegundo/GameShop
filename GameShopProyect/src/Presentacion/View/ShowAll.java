package Presentacion.View;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Presentacion.Provider.ShowAllProvider;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class ShowAll extends JPanel {
	
	// TODO numero de filas INDEFINIDO, mirar para coger el numero de filas que hay de datos en la base de datos
	private final int numRows = 100;
	private final int numColumns = 4;
	private final String[] _columnNames = {"ID", "Direction", "NIF", "Phone number"};
	private String nameIdentificator;
	
	private JTable _grid;
	
	public ShowAll(String nameIdentificator) {
		this.nameIdentificator = nameIdentificator.toLowerCase();
		initGUI();
	}

	private void initGUI() {
		this.setPreferredSize(new Dimension(400, 300));
		this.setMinimumSize(new Dimension(400, 300));
		this.setMaximumSize(new Dimension(400, 300));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		initComponents();
		
		this.setVisible(true);
	}

	private void initComponents() {		
		AbstractTableModel model = new AbstractTableModel() {
			
			ShowAll s = new ShowAllProvider(nameIdentificator);
			
			@Override
			public int getColumnCount() {
				return _columnNames.length;
			}
			@Override
			public int getRowCount() {
				// TODO CAMBIAR ESTO
				return numRows;
			}
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				// Ponemos un switch para averiguar en cuál estamos y segun el que sea poner un new ShowAllProvider()... etc
				switch(nameIdentificator) {
				case "provider":
					//new ShowAllProvider(nameIdentificator);
					break;
				case "employee":
					break;
				case "platform":
					break;
				case "ticket":
					break;
				case "product":
					break;
				}
				return null;
			}
			@Override
			public String getColumnName(int column){
				return _columnNames[column];
			}
			@Override
			public boolean isCellEditable(int row, int col) { 
			    return false; 
			}
		};
		
		_grid = new JTable(model);
		_grid.setVisible(true);
		this.add(_grid);
		
		JScrollPane scroll = new JScrollPane(_grid);
		scroll.setVisible(true);
		this.add(scroll);
	}
	
	
}