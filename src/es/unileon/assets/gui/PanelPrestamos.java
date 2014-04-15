package es.unileon.assets.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import es.unileon.assets.KindOfMethod;
import es.unileon.assets.PaymentPeriod;

public class PanelPrestamos extends JPanel {

	/**
	 * 
	 */

	private GridBagConstraints constraints;

	private JButton btnCalculate = new JButton("Calcular");;

	private JTextField textFieldMoney, textFieldInterest,
			textFieldOpenningComission, textFieldStudy;

	private ButtonGroup buttonGroup;

	private JCheckBox radioButtonInHand, radioButtonAddToCredit;

	private JComboBox<PaymentPeriod> comboBox;

	private JTextField textFieldMonths;

	private JComboBox<KindOfMethod> comboBoxPayType;

	public PanelPrestamos() {
		inicializate();
	}

	private void inicializate() {

		super.setLayout(new GridBagLayout());
		
		int ancho=80;
		
		JLabel lblCrditos = new JLabel();
		lblCrditos.setText("PR\u00C9STAMOS");
		lblCrditos.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		this.constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridheight = 2;
		constraints.gridwidth = 3;
		constraints.weightx = 2.0;
		constraints.weighty = 2.0;
		constraints.fill = GridBagConstraints.CENTER;
		add(lblCrditos, constraints);

		JLabel lblDineroSolicitado = new JLabel("Dinero Solicitado");
		this.constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		add(lblDineroSolicitado, constraints);

		this.textFieldMoney = new JTextField("");
		constraints.gridx = 2;
		constraints.gridy = 3;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.ipadx= ancho;
		add(textFieldMoney, constraints);

		JLabel lblInterest = new JLabel("Intereses %");
		this.constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.fill = GridBagConstraints.CENTER;
		add(lblInterest, constraints);

		this.textFieldInterest = new JTextField();
		this.constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 4;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.ipadx= ancho;
		add(textFieldInterest, constraints);

		JLabel lblOpenningComission = new JLabel("Comisi\u00F3n apertura");
		this.constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		add(lblOpenningComission, constraints);

		this.textFieldOpenningComission = new JTextField();
		this.constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 5;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.ipadx= ancho;
		
		add(textFieldOpenningComission, constraints);

		JLabel lblStudy = new JLabel("Estudio");
		this.constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		add(lblStudy, constraints);

		this.textFieldStudy = new JTextField();
		this.constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 6;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.ipadx= ancho;
		add(textFieldStudy, constraints);
		
		
		JLabel lblMonths = new JLabel("Meses");
		this.constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		add(lblMonths, constraints);
		
		this.textFieldMonths= new JTextField();
		constraints.gridx = 2;
		constraints.gridy = 7;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.ipadx= ancho;
		add(textFieldMonths, constraints);
		
		

		JLabel lblPaymentType = new JLabel("Tipo de pago");
		this.constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		add(lblPaymentType, constraints);

		comboBox = new JComboBox<PaymentPeriod>();
		comboBox.setModel(new DefaultComboBoxModel<PaymentPeriod>(PaymentPeriod.values()));
	
		
		this.constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 8;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		add(comboBox, constraints);

		this.buttonGroup = new ButtonGroup();
		radioButtonAddToCredit = new JCheckBox("A\u00F1adir al cr\u00E9dito\n");
		radioButtonInHand = new JCheckBox("En el acto");
		
	
		buttonGroup.add(radioButtonAddToCredit);
		constraints.gridx = 0;
		constraints.gridy = 10;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		this.add(radioButtonAddToCredit, constraints);
		
		buttonGroup.add(radioButtonInHand);
		constraints.gridx = 2;
		constraints.gridy = 10;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		
		this.add(radioButtonInHand, constraints);
		
		JLabel lbltipoPago = new JLabel("Tipo de metodo");
		this.constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 9;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		add(lbltipoPago, constraints);
		
		comboBoxPayType = new JComboBox<KindOfMethod>();
		comboBoxPayType.setModel(new DefaultComboBoxModel<KindOfMethod>(KindOfMethod.values()));
		this.constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 9;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		add(comboBoxPayType, constraints);
		
		
		this.constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 11;
		constraints.gridheight = 1;
		constraints.gridwidth = 0;
		constraints.weighty = 3.0;
		constraints.fill = GridBagConstraints.CENTER;
		add(btnCalculate, constraints);
		getPaymentPeriod().getPeriod();

	}
	
	
	
	public void addListenerRadioButtonInHand(ChangeListener listener){
		radioButtonInHand.addChangeListener(listener);
	}
	
	public void addListenerRadioButtonAddToCredit(ChangeListener listener){
		radioButtonAddToCredit.addChangeListener(listener);
	}
	
	public void addListenerbtnCalculate(ActionListener listener){
		this.btnCalculate.addActionListener(listener);
		
		
	}
	
//	return Double.parseDouble(textFieldMoney.getText())+Double.parseDouble(textFieldStudy.getText())+Double.parseDouble(textFieldOpenningComission.getText());
	
	public double getFieldMoney(){
		if(!(textFieldMoney.getText()==(null))){
		
			try {
				return Double.parseDouble(textFieldMoney.getText());
			} catch (Exception e) {
				return 0;
			}
		}else{
			return 0;
		}
	}
	
	public int getFieldMonths(){
		if(!(textFieldMonths.getText()==(null))){
			try {
				return Integer.parseInt(textFieldMonths.getText());
			} catch (Exception e) {
				return 0;
			}
			
		}else{
			return 0;
		}
	}
	
	public double getFieldStudy(){
		if (!(textFieldStudy.getText()==null)) {
			try {
				return Double.parseDouble(textFieldStudy.getText());
			} catch (Exception e) {
				return 0;
			}
			
		} else {
			return 0;
		}
		
	}
	public double gettFieldOpenningComission(){
		if (!(textFieldOpenningComission.getText()==null)) {
			try {
				return Double.parseDouble(textFieldOpenningComission.getText());
			} catch (Exception e) {
				return 0;
			}
			
		} else {
			return 0;
		}
		
	}
	public double getFieldInterest(){
		if (!(textFieldInterest.getText()==null)) {
			return Double.parseDouble(textFieldInterest.getText());
		} else {
			return 0;
		}
	}
	
	public PaymentPeriod getPaymentPeriod(){
		return (PaymentPeriod) this.comboBox.getSelectedItem();
	}	
	

	public KindOfMethod getKindMethod() {
		// TODO Auto-generated method stub
		return (KindOfMethod) this.comboBoxPayType.getSelectedItem();
	}
	
}
