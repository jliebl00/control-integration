import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GUI_Login {
	private JFrame frame;
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	private JDialog d;
	private JLabel lblWrongUser;
	private JLabel lblWrongPass;
	private int rol = 0;
	private BufferedImage img = null;
	private java.net.URL url;
	private ImageIcon ic;
	
	//esto es solo para mostrarle al cliente como se veria
	private String usser = "adrian";
	private String pass = "123456";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Login window = new GUI_Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JLabel lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblUser.setForeground(new Color(0, 0, 0));
		lblUser.setBounds(224, 28, 55, 16);
		frame.getContentPane().add(lblUser);

		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPassword.setBounds(211, 124, 85, 16);
		frame.getContentPane().add(lblPassword);

		textFieldUser = new JTextField();
		textFieldUser.setBounds(76, 56, 348, 28);
		frame.getContentPane().add(textFieldUser);
		textFieldUser.setColumns(10);
		textFieldUser.setFocusable(true);

		passwordField = new JPasswordField();
		passwordField.setBounds(76, 152, 348, 28);
		frame.getContentPane().add(passwordField);

		lblWrongUser = new JLabel("Usuario Incorrecto");
		lblWrongUser.setForeground(Color.RED);
		lblWrongUser.setBounds(80, 96, 135, 16);
		lblWrongUser.setVisible(false);
		frame.getContentPane().add(lblWrongUser);

		lblWrongPass = new JLabel("Contrase\u00F1a Incorrecta");
		lblWrongPass.setForeground(Color.RED);
		lblWrongPass.setBounds(80, 192, 160, 16);
		lblWrongPass.setVisible(false);
		frame.getContentPane().add(lblWrongPass);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressLogin();
			}
		});
		
		btnLogin.setBounds(76, 226, 117, 29);
		frame.getContentPane().add(btnLogin);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(307, 226, 117, 29);
		frame.getContentPane().add(btnCancel);

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setJDialog(JDialog d) {
		this.d = d;
	}

	public int getRol() {
		return this.rol;
	}
	
	public void pressLogin(){
		String user1 = textFieldUser.getText();
		String pass1 = new String(passwordField.getPassword());
		JOptionPane login;
		
		if(user1.equals(usser)){
			lblWrongUser.setVisible(false);
			if(pass1.equals(pass)){
				lblWrongPass.setVisible(false);
				
				JOptionPane.showMessageDialog(this.frame, "log in succesful", "log in", JOptionPane.INFORMATION_MESSAGE);
				
			}else{
				lblWrongPass.setVisible(true);
			}
		}else{
			lblWrongUser.setVisible(true);
			lblWrongPass.setVisible(true);
		}
	}
}
