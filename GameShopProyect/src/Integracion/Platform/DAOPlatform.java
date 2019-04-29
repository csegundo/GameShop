/**
 * 
 */
package Integracion.Platform;

import java.util.List;

import Transfers.TPlatform;


public interface DAOPlatform {

	public Integer createPlatform(TPlatform tpla);
	public Boolean deletePlatform(Integer id);
	public Boolean updatePlatform(TPlatform tpla);
	public TPlatform readPlatform(Integer id);
	public List<TPlatform> readAllPlatforms();
	public List<TPlatform> readAllProductsOfAPlatform(Object Parameter1);
	public TPlatform readByName(String s);
	
}