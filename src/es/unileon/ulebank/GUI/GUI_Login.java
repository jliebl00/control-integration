import java.awt.EventQueue;

public class GUI_Login {
	private JFrame frame;
	private ImagePanel panel;
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
	private JTextField textField;
	private JTextField textField_1;

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
		frame.setResizable(false);
		frame.setBounds(200, 50, 955, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel = new ImagePanel("login");
		panel.setLayout(null);
		panel.setVisible(true);
		frame.getContentPane().add(panel);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(577, 121, 231, 37);
		panel.add(textFieldUser);
		textFieldUser.setColumns(10);
		textFieldUser.setFocusable(true);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(577, 205, 231, 37);
		panel.add(passwordField);

		lblWrongUser = new JLabel("Usuario Incorrecto");
		lblWrongUser.setForeground(Color.RED);
		lblWrongUser.setBounds(577, 160, 135, 16);
		lblWrongUser.setVisible(false);
		panel.add(lblWrongUser);

		lblWrongPass = new JLabel("Contrase\u00F1a Incorrecta");
		lblWrongPass.setForeground(Color.RED);
		lblWrongPass.setBounds(577, 245, 160, 16);
		lblWrongPass.setVisible(false);
		panel.add(lblWrongPass);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressLogin();
			}
		});

		btnLogin.setBounds(548, 291, 117, 29);
		panel.add(btnLogin);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(716, 291, 117, 29);
		panel.add(btnCancel);

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
