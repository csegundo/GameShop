package Negocio.Employee;

import java.util.List;

import Integracion.DAO.DAOAbstractFactory;
import Integracion.Employee.DAOEmployee;
import Transfers.TEmployee;
import Transfers.TProvider;

public class SAEmployeeImpl implements SAEmployee {

	@Override
	public Integer createEmployee(TEmployee te) {
		int id = -1;
		if(validateData(te)) {
			DAOEmployee daoEmployee = DAOAbstractFactory.getInstance().createDAOEmployee();
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
		DAOEmployee daoEmployee = DAOAbstractFactory.getInstance().createDAOEmployee();
		
		if(id != null)
			ret = (TEmployee)daoEmployee.readEmployee(id);
		return ret;
	}

	@Override
	public List<Object> readAllEmployees() {
		List<Object> employees = null;
		employees = DAOAbstractFactory.getInstance().createDAOEmployee().readAllEmployees();
		return employees;
	}
	
	private boolean validateData(TEmployee te) {
		if(te == null || !checkNIF(te.get_nif()) || te.get_name().length() > 45 || te.getTurn().length() > 15)
			return false;
		else
			return true;
	}
	
	
	// ESTOS METODOS SON PARA COMPROBAR LA VALIDEZ DE UN NIF
	private boolean checkNIF(String NIF) {
		if(NIF.length() != 9 || !Character.isLetter(NIF.charAt(8))) 
			return false;
		
		return NIFletter(NIF.substring(8));
	}

	private boolean NIFletter(String upperLetter) {
		String[] posibilities = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q",
				 "V", "H", "L", "C", "K", "E"};
		for(int i = 0; i < posibilities.length; ++i){
			if(upperLetter.equalsIgnoreCase(posibilities[i])) return true;
		}
		return false;
	}
}