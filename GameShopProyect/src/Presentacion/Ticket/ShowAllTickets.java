/**
 * 
 */
package Presentacion.Ticket;

import Presentacion.View.ShowAll;
import Transfers.TTicket;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ShowAllTickets extends ShowAll {
	private static final long serialVersionUID = 1L;
	private String[] _columnsId = {"ID","IDEmpleado","Precio final","Fecha"};
	AbstractTableModel model;
	private List<Object> tickets;
	
	public ShowAllTickets(String nameIdentificator, List<Object> l) {
		super(nameIdentificator);
		tickets = l;
		this.initComponents();
	}


	private void initComponents() {
		model = new AbstractTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public int getColumnCount() {
				return _columnsId.length;
			}

			@Override
			public int getRowCount() {
				return tickets == null ? 0 : tickets.size();
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				Object o = null;
				
				switch(columnIndex){
				case 0:
					o = ((TTicket)tickets.get(rowIndex)).get_id();
					break;
					
				case 1:
					o = ((TTicket)tickets.get(rowIndex)).get_employeeId();
					break;
					
				case 2:
					o = ((TTicket)tickets.get(rowIndex)).get_finalPrice();
					break;
					
				case 3:
					o = ((TTicket)tickets.get(rowIndex)).get_date();
					break;
				}
				return o;
			}

			@Override
			public String getColumnName(int column) {
				return _columnsId[column];
			}

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		_grid = new JTable(model);
		setColumnsWidth();
		_grid.setVisible(true);

		this.add(new JScrollPane(_grid, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
	}
	
	private void setColumnsWidth() {
		_grid.getColumnModel().getColumn(0).setPreferredWidth(30);
		_grid.getColumnModel().getColumn(1).setPreferredWidth(80);
		_grid.getColumnModel().getColumn(2).setPreferredWidth(50);
		_grid.getColumnModel().getColumn(3).setPreferredWidth(80);
	}

	@Override
	public void update(List<Object> l) {
		tickets = l;
		model.fireTableDataChanged();
	}
}