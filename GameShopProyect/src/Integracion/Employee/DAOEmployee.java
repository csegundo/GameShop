/**
 * 
 */
package Integracion.Employee;

import java.util.List;

import Transfers.TEmployee;

public interface DAOEmployee {
	
	public Integer createEmployee(TEmployee te);
	public Boolean deleteEmployee(TEmployee te);
	public Boolean updateEmployee(TEmployee te);
	public Object readEmployee(Integer id);
	public List<TEmployee> readAllEmployees();
	public TEmployee readEmployeeByNIF(String s);
}