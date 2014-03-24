package es.unileon.ulebank.GUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

import es.unileon.ulebank.Register;

public class GUI_AddEmployee {
	private JFrame frame;
	private JTextField textFieldDni;
	private JTextField textFieldName;
	private JTextField textFieldLastName;
	private JPasswordField passwordField;
	private JPasswordField passwordRepeatedField;
	private JTextField textFieldUserName;
	private JComboBox comboBoxRole;
	private JDialog d;
	private JLabel lblPassWrong;
	private final BufferedImage img = null;
	private java.net.URL url;
	private ImageIcon ic;
	private Register register;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					GUI_AddEmployee window = new GUI_AddEmployee();
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
	public GUI_AddEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("A\u00F1adir Empleado");
		lblTitle.setForeground(Color.YELLOW);
		lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		lblTitle.setBounds(130, 6, 340, 27);
		frame.getContentPane().add(lblTitle);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(50, 39, 29, 16);
		frame.getContentPane().add(lblDni);

		JLabel lblName = new JLabel("Nombre");
		lblName.setBounds(50, 79, 61, 16);
		frame.getContentPane().add(lblName);

		JLabel lblLastName = new JLabel("Apellidos");
		lblLastName.setBounds(50, 119, 65, 16);
		frame.getContentPane().add(lblLastName);

		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setBounds(50, 199, 90, 16);
		frame.getContentPane().add(lblPassword);

		JLabel lblRepeatPassword = new JLabel("Repetir contrase\u00F1a");
		lblRepeatPassword.setBounds(50, 239, 140, 16);
		frame.getContentPane().add(lblRepeatPassword);

		JLabel lblChooseRole = new JLabel("Elegir rol");
		lblChooseRole.setBounds(50, 279, 80, 16);
		frame.getContentPane().add(lblChooseRole);

		textFieldDni = new JTextField();
		textFieldDni.setBounds(399, 33, 87, 28);
		frame.getContentPane().add(textFieldDni);
		textFieldDni.setColumns(10);
		textFieldDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				// Ayuda para permitir unicamente la introduccion de numeros y
				// que el maximo sea 8 digitos sin la letra.
				char car = evt.getKeyChar();
				if (textFieldDni.getText().length() >= 9)
					evt.consume();
			}
		});

		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(314, 73, 257, 28);
		frame.getContentPane().add(textFieldName);

		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(314, 113, 257, 28);
		frame.getContentPane().add(textFieldLastName);

		passwordField = new JPasswordField();
		passwordField.setBounds(314, 193, 257, 28);
		frame.getContentPane().add(passwordField);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(50, 159, 61, 16);
		frame.getContentPane().add(lblUsuario);

		passwordRepeatedField = new JPasswordField();
		passwordRepeatedField.setBounds(314, 233, 257, 28);
		frame.getContentPane().add(passwordRepeatedField);

		lblPassWrong = new JLabel("Las contrase\u00F1as no coinciden");
		lblPassWrong.setForeground(Color.RED);
		lblPassWrong.setBounds(320, 262, 240, 16);
		lblPassWrong.setVisible(false);
		frame.getContentPane().add(lblPassWrong);

		textFieldUserName = new JTextField();
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(314, 153, 257, 28);
		frame.getContentPane().add(textFieldUserName);

		comboBoxRole = new JComboBox();
		comboBoxRole.addItem("Empleado");
		comboBoxRole.addItem("Administrador");
		comboBoxRole.setBounds(314, 279, 257, 27);
		frame.getContentPane().add(comboBoxRole);


		JButton btnAdd = new JButton("A\u00F1adir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEmployee();
			}
		});
		btnAdd.setBounds(60, 330, 120, 29);
		frame.getContentPane().add(btnAdd);

		JButton btnClean = new JButton("Limpiar");
		btnClean.setBounds(240, 330, 120, 29);
		frame.getContentPane().add(btnClean);
		btnClean.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldDni.setText("");
				textFieldName.setText("");
				textFieldLastName.setText("");
				textFieldUserName.setText("");
				passwordField.setText("");
				passwordRepeatedField.setText("");
				comboBoxRole.setSelectedIndex(0);

			}
		});

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(420, 330, 120, 29);
		frame.getContentPane().add(btnCancel);

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
	}
	
	private void addEmployee(){
		register = new Register(textFieldUserName.getText(), new String(passwordField.getPassword()));
	}
}
