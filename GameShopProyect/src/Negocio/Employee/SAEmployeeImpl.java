/**
 * 
 */
package Negocio.Employee;

import java.util.List;

import Integracion.DAO.DAOAbstractFactory;
import Integracion.Employee.DAOEmployee;
import Transfers.TEmployee;

public class SAEmployeeImpl implements SAEmployee {

	@Override
	public Integer createEmployee(TEmployee te) {
		int id = -1;
		DAOEmployee daoEmployee = DAOAbstractFactory.getInstance().createDAOEmployee();
		if(te != null){
			TEmployee tpl = daoEmployee.readEmployeeByNIF(te.get_nif());
			if(tpl == null)
				id = daoEmployee.createEmployee(te);
		}
		return id;
	}

	@Override
	public Boolean deleteEmployee(Integer id) {
		boolean ret = false;
		DAOEmployee daoEmployee = DAOAbstractFactory.getInstance().createDAOEmployee();
		
		if(id != null) {
			TEmployee ternif = (TEmployee)daoEmployee.readEmployee(id);
			// Si devuelve un transfer significa que existe y por lo tanto se procede a borrarlo
			if(ternif != null && ternif.get_activated())
				ret = daoEmployee.deleteEmployee(ternif);
		}
		return ret;
	}

	@Override
	public Boolean updateEmployee(TEmployee te) {
		return DAOAbstractFactory.getInstance().createDAOEmployee().updateEmployee(te);
	}

	@Override
	public Object readEmployee(Integer id) {
		TEmployee ret = null;
		DAOEmployee daoProvider = DAOAbstractFactory.getInstance().createDAOEmployee();
		
		if(id != null)
			ret = (TEmployee)daoProvider.readEmployee(id);
		return ret;
	}

	@Override
	public List<TEmployee> readAllEmployees() {
		List<TEmployee> employees = null;
		employees = DAOAbstractFactory.getInstance().createDAOEmployee().readAllEmployees();
		return employees;
	}
}