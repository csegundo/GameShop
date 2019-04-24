package Main;

import javax.swing.SwingUtilities;

import Presentacion.Controller.Controller;

public class Main {
	
	public static final String applicationName = "GameShop";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Controller.getInstance();
			}
		});
	}

}
