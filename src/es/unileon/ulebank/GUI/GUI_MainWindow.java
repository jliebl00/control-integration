package es.unileon.ulebank.GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;


public class GUI_MainWindow {

	private JFrame frame;
	private ImagePanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_MainWindow window = new GUI_MainWindow();
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
	public GUI_MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(200, 50, 955, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new ImagePanel("/images/main_window");
		frame.add(panel);
		panel.setVisible(true);
	}
	
	public JFrame getFrame(){
		return this.frame;
	}

}
