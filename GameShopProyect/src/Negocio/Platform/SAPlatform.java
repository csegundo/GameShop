/**
 * 
 */
package Negocio.Platform;

import java.util.List;

import Transfers.TPlatform;

public interface SAPlatform {

	public Integer createPlatform(TPlatform tpla);
	public Boolean deletePlatform(Integer id);
	public Boolean updatePlatform(TPlatform tpla);
	public TPlatform readPlatform(Integer id);
	public List<TPlatform> readAllPlatforms();
	public List<TPlatform> readAllProductsOfAPlatform(Object Parameter1);
	
}