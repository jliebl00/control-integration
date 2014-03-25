//Implementar en el boton manejo de acciones de VariableAccount
package es.unileon.ulebank.GUI.variableAccount;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class StockManagerGUI extends JFrame {

private JPanel contentPane;
private JTextField textField;


public StockManagerGUI() {
	JPanel auxPane = (JPanel) getContentPane();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1276, 840);
	contentPane = new JPanel();

	int width = this.getToolkit().getScreenSize().width;
        int height = this.getToolkit().getScreenSize().height;
        setSize( width , height );
        JScrollPane scrollpane = new JScrollPane(contentPane);

        GridBagLayout locatoionContentPane = new GridBagLayout();
        locatoionContentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        locatoionContentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        GridBagConstraints location = new GridBagConstraints();

        location.gridx = 0;
        location.gridy = 0;
        location.fill = GridBagConstraints.BOTH ;
        location.weightx = 1.0 ;
        location.weighty = 1.0 ;
        locatoionContentPane.setConstraints(scrollpane,location) ;

        contentPane.setLayout(locatoionContentPane);
        auxPane.add(scrollpane);

        JTextPane stockTitle = new JTextPane();
        GridBagConstraints gbc_stockTitle = new GridBagConstraints();
        gbc_stockTitle.insets = new Insets(0, 0, 5, 5);
        gbc_stockTitle.gridx = 1;
        gbc_stockTitle.gridy = 0;
		contentPane.add(stockTitle, gbc_stockTitle);
		stockTitle.setText("ACCIONES DISPONIBLES");
		stockTitle.setFont(new Font("Lucida Grande", Font.BOLD, 37));

		JButton variableAccount = new JButton("Cuenta Variable");
		GridBagConstraints locationVariableAccount = new GridBagConstraints();
		locationVariableAccount.insets = new Insets(0, 0, 5, 0);
		locationVariableAccount.gridx = 15;
		locationVariableAccount.gridy = 3;
		contentPane.add(variableAccount, locationVariableAccount);
		
		JButton stockBuyButton = new JButton("  Comprar  ");
		stockBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StockGUI nextWindow = new StockGUI();
				setVisible(true);
			}
		});
		GridBagConstraints gbc_stockBuyButton = new GridBagConstraints();
		gbc_stockBuyButton.insets = new Insets(0, 0, 5, 0);
		gbc_stockBuyButton.gridx = 15;
		gbc_stockBuyButton.gridy = 4;
		contentPane.add(stockBuyButton, gbc_stockBuyButton);
		
		JButton stockSalesButton = new JButton("   Vender   ");
		stockSalesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockSalesGUI anotherWindow = new StockSalesGUI();
				setVisible(true);
			}
			
		});
		GridBagConstraints gbc_stockSalesButton = new GridBagConstraints();
		gbc_stockSalesButton.insets = new Insets(0, 0, 5, 0);
		gbc_stockSalesButton.gridx = 15;
		gbc_stockSalesButton.gridy = 5;
		contentPane.add(stockSalesButton, gbc_stockSalesButton);

		variableAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VariableAccountGUI nextWindow = new VariableAccountGUI();
				nextWindow.setVisible(true);
				setVisible(false);	
			}
		});

		for (int i=1; i<5;i++){
			GridBagConstraints locationPanel = new GridBagConstraints();
			locationPanel.insets = new Insets(0, 0, 10, 0);
			locationPanel.fill = GridBagConstraints.HORIZONTAL;
			locationPanel.gridx = 1;
			locationPanel.gridy = i;
			JPanel panelaux= newPanel();
			panelaux.setSize(100,50);
			contentPane.add(panelaux, locationPanel);
		}

}

	public JPanel newPanel(){
		JPanel investmentPanel = new JPanel();
		investmentPanel.setBackground(Color.WHITE);	

		GridBagLayout locationInvestmentPanel = new GridBagLayout();
		locationInvestmentPanel.columnWidths = new int[]{130, 30, 300, 50, 50, 50, 50, 50, 50,50};
		locationInvestmentPanel.rowHeights = new int[]{34, 34, 34, 34};
		investmentPanel.setLayout(locationInvestmentPanel);

		JTextPane investmentFound = new JTextPane();
		investmentFound.setText("ID:");
		GridBagConstraints locationInvestmentFound = new GridBagConstraints();
		locationInvestmentFound.anchor = GridBagConstraints.NORTH;
		locationInvestmentFound.fill = GridBagConstraints.HORIZONTAL;
		locationInvestmentFound.insets = new Insets(0, 0, 5, 5);
		locationInvestmentFound.gridx = 0;
		locationInvestmentFound.gridy = 0;
		investmentPanel.add(investmentFound, locationInvestmentFound);

		JTextPane dataID = new JTextPane();
		dataID.setText("");
		GridBagConstraints locationDataID = new GridBagConstraints();
		locationDataID.insets = new Insets(0, 0, 5, 5);
		locationDataID.fill = GridBagConstraints.BOTH;
		locationDataID.gridx = 2;
		locationDataID.gridy = 0;
		investmentPanel.add(dataID, locationDataID);

		JTextPane participations = new JTextPane();
		participations.setText("Participaciones:");
		GridBagConstraints locationParticipations = new GridBagConstraints();
		locationParticipations.anchor = GridBagConstraints.NORTH;
		locationParticipations.fill = GridBagConstraints.HORIZONTAL;
		locationParticipations.insets = new Insets(0, 0, 5, 5);
		locationParticipations.gridx = 0;
		locationParticipations.gridy = 1;
		investmentPanel.add(participations, locationParticipations);

		JTextPane dataParticipations = new JTextPane();
		dataParticipations.setText("");
		GridBagConstraints locationDataParticipations = new GridBagConstraints();
		locationDataParticipations.insets = new Insets(0, 0, 5, 5);
		locationDataParticipations.fill = GridBagConstraints.BOTH;
		locationDataParticipations.gridx = 2;
		locationDataParticipations.gridy = 1;
		investmentPanel.add(dataParticipations, locationDataParticipations);	

		JTextPane price = new JTextPane();
		price.setText("Precio");
		GridBagConstraints locationPrice = new GridBagConstraints();
		locationPrice.insets = new Insets(0, 0, 5, 5);
		locationPrice.anchor = GridBagConstraints.NORTHWEST;
		locationPrice.gridx = 0;
		locationPrice.gridy = 2;
		investmentPanel.add(price, locationPrice);

		JTextPane dataPrice = new JTextPane();
		dataPrice.setText("");
		GridBagConstraints locationDataPrice = new GridBagConstraints();
		locationDataPrice.insets = new Insets(0, 0, 5, 5);
		locationDataPrice.fill = GridBagConstraints.BOTH;
		locationDataPrice.gridx = 2;
		locationDataPrice.gridy = 2;
		investmentPanel.add(dataPrice, locationDataPrice);

		JTextPane fee = new JTextPane();
		fee.setText("Tasa por anulacion: ");
		GridBagConstraints locationFee = new GridBagConstraints();
		locationFee.insets = new Insets(0, 0, 0, 5);
		locationFee.anchor = GridBagConstraints.NORTH;
		locationFee.fill = GridBagConstraints.HORIZONTAL;
		locationFee.gridx = 0;
		locationFee.gridy = 3;
		investmentPanel.add(fee, locationFee);

		JTextPane dataFee = new JTextPane();
		dataFee.setText(" ");
		GridBagConstraints locationDataFee = new GridBagConstraints();
		locationDataFee.insets = new Insets(0, 0, 0, 5);
		locationDataFee.fill = GridBagConstraints.BOTH;
		locationDataFee.gridx = 2;
		locationDataFee.gridy = 3;
		investmentPanel.add(dataFee, locationDataFee);

		
	

	return investmentPanel;
	}

}