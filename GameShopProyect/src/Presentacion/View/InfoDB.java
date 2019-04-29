package Presentacion.View;

import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Integracion.DAO.*;



@SuppressWarnings("serial")
public class InfoDB extends JDialog{
	
	private JLabel _bd;
	private JTextField _bdText;
	private JLabel _name;
	private JTextField _nameText;
	private JLabel _passw;
	private JPasswordField _passwText;
	private JButton _ok;
	private JCheckBox _create;
	
	public InfoDB() {
		this.setTitle("BD_Informacion");
		this.setIconImage(new ImageIcon("resources/GameShopLogo.png").getImage());
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		
		this.setLayout(new FlowLayout());
		this.setBounds(new Rectangle(400,200));
		this.setLocationRelativeTo(null);
		
		this._bd = new JLabel("Database: ");
		this._bd.setVisible(true);
		
		this._bdText = new JTextField();
		this._bdText.setText("gameshop");
		this._bdText.setSize(250, 30);
		this._bdText.setPreferredSize(new Dimension(200,30));
		this._bdText.setMaximumSize(new Dimension(200,30));
		this._bdText.setMinimumSize(new Dimension(200,30));
		
		this._name = new JLabel("User: ");
		
		this._nameText = new JTextField();
		this._nameText.setText("root");
		this._nameText.setSize(250, 30);
		this._nameText.setPreferredSize(new Dimension(200,30));
		this._nameText.setMaximumSize(new Dimension(200,30));
		this._nameText.setMinimumSize(new Dimension(200,30));
		
		this._passw = new JLabel("Password: ");
		
		this._passwText = new JPasswordField();
		this._passwText.setSize(250, 30);	
		this._passwText.setPreferredSize(new Dimension(200,30));
		this._passwText.setMaximumSize(new Dimension(200,30));
		this._passwText.setMinimumSize(new Dimension(200,30));
		
		this._ok = new JButton("Siguiente");
		this._ok.setPreferredSize(new Dimension(150,30));
		this._ok.setMaximumSize(new Dimension(150,30));
		this._ok.setMinimumSize(new Dimension(150,30));
		this._ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main.Main.database = _bdText.getText();
				Main.Main.user = _nameText.getText();
				Main.Main.password = _passwText.getText();
				Statement Stmt = null;
				if (_create.isSelected()) {
					try
					{
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306",Main.Main.user, Main.Main.password);
						Stmt = conn.createStatement();
	
							Stmt.execute("CREATE DATABASE gameshop");
							Stmt.execute("USE gameshop");
							Stmt.execute("SET GLOBAL time_zone = '+3:00'");
							
							String aSQLScriptFilePath = "resources/GameShopTables.sql";			   
							PrintWriter prnt = new PrintWriter(System.out);
							Reader rd = new FileReader(new File(aSQLScriptFilePath));
							SqlRunner r = new SqlRunner(conn,prnt,prnt,true,false);
							r.runScript(rd);	   
					}	
					catch (Exception e)
					{
					   /* Se lanza una excepción si no se encuentra en ejecutable o el fichero no es ejecutable. */
						JOptionPane.showMessageDialog(null, "Error al crear una nueva base de datos.","Failed",JOptionPane.ERROR_MESSAGE);			
					} finally {
						try {
							if(Stmt!=null) 
								Stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				dispose();
			}
			
		});
		
		this._create = new JCheckBox("Crear nueva base de datos");
		
		this.add(this._bd);
		this.add(this._bdText);
		this.add(Box.createRigidArea(new Dimension(112, 1)));
		this.add(this._name);
		this.add(this._nameText);
		this.add(Box.createRigidArea(new Dimension(70, 1)));
		this.add(this._passw);
		this.add(this._passwText);
		this.add(this._create);
		this.add(this._ok);
	}


}
