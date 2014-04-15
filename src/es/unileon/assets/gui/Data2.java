package es.unileon.assets.gui;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeListener;

import es.unileon.assets.KindOfMethod;
import es.unileon.assets.PaymentPeriod;
import es.unileon.assets.prueba.Model;

public class Data2 extends JFrame implements View{
	
	private Model model;
	public PanelPrestamos panelloans;
	JTabbedPane tabbedPane;
	public PanelMonthlyPaymentLoan panelMonthly;
	
	
	public Data2(Model model) {
		this.model =model;
		
		initialize();
	}

	private void initialize() {
		tabbedPane=new JTabbedPane();
		this.setResizable(true);
		this.setBounds(300, 400, 400, 400);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		this.getContentPane().setLayout(new CardLayout());
		
		
		
		this.panelloans=new PanelPrestamos();
		this.panelMonthly=new PanelMonthlyPaymentLoan(this.model);
		tabbedPane.addTab("PanelPrestamos", panelloans);
		tabbedPane.addTab("Panel MonthlyPayments", panelMonthly);
		
		this.getContentPane().add(tabbedPane);
		
		pack();
		
	}
	
	public void addListenerRadioButtonInHand(ChangeListener listener){
		this.panelloans.addListenerRadioButtonInHand(listener);
	}
	
	public void addListenerRadioButtonAddToCredit(ChangeListener listener){
		this.panelloans.addListenerRadioButtonAddToCredit(listener);
	}
	public void addListenerbtnCalculate(ActionListener listener){
		this.panelloans.addListenerbtnCalculate(listener);
	}
	
	public double getFieldMoney(){
		return this.panelloans.getFieldMoney();
	}
	public double getFieldInterest(){
		return this.panelloans.getFieldInterest();
	}
	public double getFieldStudy(){
		return this.panelloans.getFieldStudy();
	}
	public double getFieldOpenningComission(){
		return this.panelloans.gettFieldOpenningComission();
	}
	public PaymentPeriod getPaymentPeriod(){
		return this.panelloans.getPaymentPeriod();
	}

	@Override
	public void resetPlannedPayments(Model model) {
		this.panelMonthly.resetPlannedPayments(model);
		
	}

	@Override
	public int getFieldMonths() {
		// TODO Auto-generated method stub
		return this.panelloans.getFieldMonths();
	}

	
	@Override
	public KindOfMethod getKindMethod() {
		
		return this.panelloans.getKindMethod();
	}

	@Override
	public String getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
}
