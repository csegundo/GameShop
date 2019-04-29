package Presentacion.View;

import java.awt.BorderLayout;
import java.awt.Component;
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
import javax.swing.BoxLayout;
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
public class InfoDB extends JDialog {
	
	private JLabel _bd;
	private JTextField _bdText;
	private JLabel _name;
	private JTextField _nameText;
	private JLabel _passw;
	private JPasswordField _passwText;
	private JButton _ok;
	private JCheckBox _create;
	private boolean finished;
	
	public InfoDB() {
		this.setTitle("DB information");
		this.setIconImage(new ImageIcon("resources/GameShopLogo.png").getImage());
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		
		this.setLayout(new FlowLayout());
		this.setBounds(new Rectangle(220, 270));
		this.setLocationRelativeTo(null);
		
		initGUI();
		
		this.setVisible(true);
	}
	
	private void initGUI() {
		
		finished = false;
		
		_bd = new JLabel("Database ");
		_bd.setAlignmentX(Component.CENTER_ALIGNMENT);
		_bd.setVisible(true);
		
		_bdText = new JTextField();
		_bdText.setAlignmentX(Component.CENTER_ALIGNMENT);
		_bdText.setText("GameShop");
		_bdText.setSize(250, 30);
		_bdText.setPreferredSize(new Dimension(200,30));
		_bdText.setMaximumSize(new Dimension(200,30));
		_bdText.setMinimumSize(new Dimension(200,30));
		
		_name = new JLabel("User ");
		_name.setAlignmentX(Component.CENTER_ALIGNMENT);
		_name.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		_nameText = new JTextField();
		_nameText.setAlignmentX(Component.CENTER_ALIGNMENT);
		_nameText.setText("root");
		_nameText.setSize(250, 30);
		_nameText.setPreferredSize(new Dimension(200,30));
		_nameText.setMaximumSize(new Dimension(200,30));
		_nameText.setMinimumSize(new Dimension(200,30));
		
		_passw = new JLabel("Password ");
		_passw.setAlignmentX(Component.CENTER_ALIGNMENT);
		_passw.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		_passwText = new JPasswordField();
		_passwText.setAlignmentX(Component.CENTER_ALIGNMENT);
		_passwText.setSize(250, 30);	
		_passwText.setPreferredSize(new Dimension(200,30));
		_passwText.setMaximumSize(new Dimension(200,30));
		_passwText.setMinimumSize(new Dimension(200,30));
		
		_ok = new JButton("Confirm");
		_ok.setAlignmentX(Component.CENTER_ALIGNMENT);
		_ok.setPreferredSize(new Dimension(150,30));
		_ok.setMaximumSize(new Dimension(150,30));
		_ok.setMinimumSize(new Dimension(150,30));
		
		_create = new JCheckBox("Crear nueva base de datos");
		_create.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		createOkButtonAction();
		
		this.add(_bd);
		this.add(_bdText);
		this.add(Box.createRigidArea(new Dimension(112, 1)));
		this.add(_name);
		this.add(_nameText);
		this.add(Box.createRigidArea(new Dimension(70, 1)));
		this.add(_passw);
		this.add(_passwText);
		this.add(_create);
		this.add(_ok);
	}
	
	private void createOkButtonAction() {
		this._ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main.Main.database = _bdText.getText();
				Main.Main.user = _nameText.getText();
				Main.Main.password = String.valueOf(_passwText.getPassword());
				Statement Stmt = null;
				if (_create.isSelected()) {
					try
					{
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306" + Main.Main.database, Main.Main.user, Main.Main.password);
						Stmt = conn.createStatement();
	
						Stmt.execute("CREATE DATABASE gameshop");
						Stmt.execute("USE gameshop");
						Stmt.execute("SET GLOBAL time_zone = '+3:00'");
						
						String aSQLScriptFilePath = "resources/GameShopTables.sql";			   
						PrintWriter prnt = new PrintWriter(System.out);
						Reader rd = new FileReader(new File(aSQLScriptFilePath));
						SqlRunner r = new SqlRunner(conn,prnt,prnt,true,false);
						r.runScript(rd);
						finished = true;
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
							e.printStackTrace();
						}
					}
				}
					dispose();
			}
		});
	}
	
	public boolean getState() {
		return this.finished;
	}

}
