package Presentacion.View;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/** 
* @author GameShop
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
@SuppressWarnings("serial")
public class ShowAll extends JPanel {
	
	// TODO numero de filas INDEFINIDO, mirar para coger el numero de filas que hay de datos en la base de datos
	private final int numRows = 1000;
	private final int numColumns = 4;
	private final String[] _columnNames = {"ID", "NIF", "Name", "Turn", "Active"};
	
	private JTable _grid;
	
	public ShowAll() {
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