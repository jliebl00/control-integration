package es.unileon.assets.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Data implements ChangeListener{

	private JFrame frame;
	private JTextField textFieldMoney;
	private JTextField textFieldInterest;
	private JTextField textFieldOpenningComission;
	private JTextField textFieldStudy;
	private JRadioButton radioButtonInHand,radioButtonAddToCredit;
	private JComboBox comboBox;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldPays;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Data window = new Data();
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
	public Data() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(300, 400, 450, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCrditos = new JLabel("PR\u00C9STAMOS");
		lblCrditos.setForeground(Color.BLACK);
		lblCrditos.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		lblCrditos.setBounds(100, 18, 249, 48);
		frame.getContentPane().add(lblCrditos);
		
		JLabel lblDineroSolicitado = new JLabel("Dinero Solicitado");
		lblDineroSolicitado.setBounds(92, 90, 108, 16);
		frame.getContentPane().add(lblDineroSolicitado);
		
		textFieldMoney = new JTextField();
		textFieldMoney.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMoney.setBounds(238, 84, 134, 28);
		frame.getContentPane().add(textFieldMoney);
		textFieldMoney.setColumns(10);
		
		JLabel lblInterest = new JLabel("Intereses %");
		lblInterest.setBounds(92, 150, 70, 16);
		frame.getContentPane().add(lblInterest);
		
		textFieldInterest = new JTextField();
		textFieldInterest.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldInterest.setBounds(238, 144, 134, 28);
		frame.getContentPane().add(textFieldInterest);
		textFieldInterest.setColumns(10);
		
		JLabel lblOpenningComission = new JLabel("Comisi\u00F3n apertura");
		lblOpenningComission.setBounds(92, 210, 116, 16);
		frame.getContentPane().add(lblOpenningComission);
		
		textFieldOpenningComission = new JTextField();
		textFieldOpenningComission.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldOpenningComission.setBounds(238, 204, 134, 28);
		frame.getContentPane().add(textFieldOpenningComission);
		textFieldOpenningComission.setColumns(10);
		
		JCheckBox radioButtonInHand = new JCheckBox("En el acto");
		radioButtonInHand.setBounds(276, 244, 128, 23);
		radioButtonInHand.addChangeListener(this);
		frame.getContentPane().add(radioButtonInHand);
		buttonGroup.add(radioButtonInHand);
		
		JCheckBox radioButtonAddToCredit = new JCheckBox("A\u00F1adir al cr\u00E9dito\n");
		radioButtonAddToCredit.setBounds(276, 226, 140, 23);
		radioButtonAddToCredit.addChangeListener(this);
		frame.getContentPane().add(radioButtonAddToCredit);
		buttonGroup.add(radioButtonAddToCredit);
		
		JLabel lblPaymentType = new JLabel("Tipo de pago");
		lblPaymentType.setBounds(92, 330, 82, 16);
		frame.getContentPane().add(lblPaymentType);
		
		JComboBox comboBoxPayType = new JComboBox();
		comboBoxPayType.setModel(new DefaultComboBoxModel(new String[] {"Mensual", "Bimensual", "Trimestral", "Semestral", "Anual"}));
		comboBoxPayType.setBounds(238, 326, 134, 27);
		frame.getContentPane().add(comboBoxPayType);
		
		JLabel lblStudy = new JLabel("Estudio");
		lblStudy.setBounds(92, 270, 61, 16);
		frame.getContentPane().add(lblStudy);
		
		textFieldStudy = new JTextField();
		textFieldStudy.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldStudy.setBounds(238, 264, 134, 28);
		frame.getContentPane().add(textFieldStudy);
		textFieldStudy.setColumns(10);
		
		JButton btnCalculate = new JButton("Calcular");
		btnCalculate.setBounds(166, 508, 117, 29);
		frame.getContentPane().add(btnCalculate);
		
		JLabel lblTipoInteres = new JLabel("Tipo interes");
		lblTipoInteres.setBounds(92, 450, 82, 16);
		frame.getContentPane().add(lblTipoInteres);
		
		JComboBox comboBoxLoanModel = new JComboBox();
		comboBoxLoanModel.setModel(new DefaultComboBoxModel(new String[] {"Franc\u00E9s", "Alem\u00E1n", "Italiano", "Progresivo"}));
		comboBoxLoanModel.setBounds(238, 446, 134, 27);
		frame.getContentPane().add(comboBoxLoanModel);
		
		JLabel lblPaysNumber = new JLabel("Numero Pagos");
		lblPaysNumber.setBounds(92, 390, 91, 16);
		frame.getContentPane().add(lblPaysNumber);
		
		textFieldPays = new JTextField();
		textFieldPays.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPays.setBounds(238, 384, 134, 28);
		frame.getContentPane().add(textFieldPays);
		textFieldPays.setColumns(10);
	}
	private double calcLoan()
	{
		if(!radioButtonInHand.isSelected())
			return Double.parseDouble(textFieldMoney.getText())+Double.parseDouble(textFieldStudy.getText())+Double.parseDouble(textFieldOpenningComission.getText());
		else
			return Double.parseDouble(textFieldMoney.getText());
	}

	private int calcPeriod()
	{
		if(comboBox.getSelectedItem().toString() == "Mensual")
			return 12;
		else if(comboBox.getSelectedItem().toString() == "Bimensual")
			return 6;
		else if(comboBox.getSelectedItem().toString() == "Trimestral")
			return 4;
		else if(comboBox.getSelectedItem().toString() == "Semestral")
			return 2;
		else if(comboBox.getSelectedItem().toString() == "Anual")
			return 1;
		return 0;
	}
	
	private int calcType(){
		if(comboBox.getSelectedItem().toString() == "Frances")
			return 1;
		else if(comboBox.getSelectedItem().toString() == "Aleman")
			return 2;
		else if(comboBox.getSelectedItem().toString() == "Italiano")
			return 3;
		else if(comboBox.getSelectedItem().toString() == "Progresivo")
			return 4;
		return 0;
	}


	@Override
	public void stateChanged(ChangeEvent e) {
//		if(radioButtonActo.isSelected()){
//			radioButtonAnadir.disable();
//		}
		
	}
}
