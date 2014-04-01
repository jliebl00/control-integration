package es.unileon.assets.gui;

import java.awt.event.ActionListener;

import javax.swing.event.ChangeListener;

import es.unileon.assets.KindOfMethod;
import es.unileon.assets.PaymentPeriod;
import es.unileon.assets.prueba.Model;

public interface View {
	public double getFieldMoney();
	public double getFieldInterest();
	public double getFieldStudy();
	public double getFieldOpenningComission();
	public int getFieldMonths();
	public String getMethod();
	public PaymentPeriod getPaymentPeriod();
	public void resetPlannedPayments(Model model);
	
	public void addListenerRadioButtonInHand(ChangeListener listener);
	public void addListenerRadioButtonAddToCredit(ChangeListener listener);
	public void addListenerbtnCalculate(ActionListener listener);
	public KindOfMethod getKindMethod();
}
