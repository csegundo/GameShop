package Main;

import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;
import Presentacion.View.InfoDB;

public class Main {
	
	//No olvidar meter el campo activo a las entidades en la BD 
	
	
	public static final String applicationName = "GameShop";
	public static String database;
	public static String user;
	public static String password;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Controller.getInstance();
				//new InfoDB();
			}
		});
	}

}
