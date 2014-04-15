package es.unileon.assets.gui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import es.unileon.assets.prueba.Model;
import es.unileon.assets.strategy.loan.GermanMethod;
import es.unileon.assets.strategy.loan.ScheduledPayment;

/**
 *
 * @author amdiaz8
 */
public class PanelMonthlyPaymentLoan extends JPanel {
	
	DefaultListModel<String> listModel1,listModel2,listModel3,listModel4,listModel5;
	           Model model;
	
    public PanelMonthlyPaymentLoan(Model model) {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        
       
        listModel1 = new DefaultListModel<String>();
         listModel2 = new DefaultListModel<String>();
         listModel3 = new DefaultListModel<String>();
         listModel4 = new DefaultListModel<String>();
        listModel5 = new DefaultListModel<String>();
       
        
        setLayout(new java.awt.GridBagLayout());

        jList1.setModel(listModel1);
        jScrollPane1.setViewportView(jList1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane1, gridBagConstraints);

        jList2.setModel(listModel2);
        jScrollPane2.setViewportView(jList2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        jList3.setModel(listModel3);
        jScrollPane3.setViewportView(jList3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane3, gridBagConstraints);

        jList4.setModel(listModel4);
        jScrollPane4.setViewportView(jList4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane4, gridBagConstraints);

        jList5.setModel(listModel5);
        jScrollPane5.setViewportView(jList5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane5, gridBagConstraints);

        jLabel1.setText("Fecha vencimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("Amortización ");
        add(jLabel2, new java.awt.GridBagConstraints());

        jLabel3.setText("Importe plazo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel3, gridBagConstraints);

        jLabel4.setText("Intereses");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel4, gridBagConstraints);

        jLabel5.setText("Capital pendiente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel5, gridBagConstraints);
    }

    public void resetPlannedPayments(Model model){
    	this.model=model;
    	ArrayList<ScheduledPayment> payments = model.getPayments();
    	System.out.println(payments);
        if(!(payments==null)){
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        listModel1.removeAllElements();
        listModel2.removeAllElements();
        listModel3.removeAllElements();
        listModel4.removeAllElements();
        listModel5.removeAllElements();
        
        for(ScheduledPayment payment : payments){
        	
        	listModel1.addElement(form.format(payment.getExpiration()));
        	listModel2.addElement(payment.getAmortization()+"");
        	listModel3.addElement(payment.getImportOfTerm()+"");
        	listModel4.addElement(payment.getInterests()+"");
        	listModel5.addElement(payment.getOutstandingCapital()+"");
        	
        }
        }
    }
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JList jList4;
    private javax.swing.JList jList5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
}
