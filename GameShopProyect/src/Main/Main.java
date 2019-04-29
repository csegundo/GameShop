package Main;

import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;
import Presentacion.View.InfoDB;

public class Main {
	
	public static final String applicationName = "GameShop";
	public static String database = "gameshop";
	public static String user = "root";
	public static String password ;

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
