package Main;

import javax.swing.SwingUtilities;

import Presentacion.View.GUIGameshop;

public class Main {
	
	private static final String applicationName = "GameShop";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUIGameshop(Main.applicationName);
			}
		});
	}

}
