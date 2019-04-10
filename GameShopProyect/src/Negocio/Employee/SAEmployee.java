/**
 * 
 */
package Negocio.Employee;

import java.util.List;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author joalow
* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface SAEmployee {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param te
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer createEmployee(Object te);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param te
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Boolean deleteEmployee(Object te);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param te
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Boolean updateEmployee(Object te);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param te
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Object readEmployee(Object te);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public List readAllEmployees();
}