package com.java;

/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.kanch.*;

class TransferPanel extends JPanel implements ActionListener {
    private JButton TransferButton;
    private JTextField UsernameField, CustNameField, AmountField;
    private JComboBox CheckingOrSavingsBox, CheckingOrSavingsBox1;
    private String UName, Amount, FromAccount, ToAccount, SavingsAccountNumber, CheckingAccountNumber, CustomerName;

    public TransferPanel(String U_Name, String Customer_Name, String CA_Number, String SA_Number) {

    	CheckingAccountNumber=CA_Number;
		SavingsAccountNumber=SA_Number;
		UName = U_Name;
        CustomerName = Customer_Name;

        TransferButton = new JButton("Transfer");

        CheckingOrSavingsBox = new JComboBox();
        CheckingOrSavingsBox.addItem("From Account Type");
		CheckingOrSavingsBox.addItem("Checking...."+CheckingAccountNumber.substring(4,8));
        CheckingOrSavingsBox.addItem("Savings...."+SavingsAccountNumber.substring(4,8));

		CheckingOrSavingsBox1 = new JComboBox();
		CheckingOrSavingsBox1.addItem("To Account Type");
	    CheckingOrSavingsBox1.addItem("Checking...."+CheckingAccountNumber.substring(4,8));
	    CheckingOrSavingsBox1.addItem("Savings...."+SavingsAccountNumber.substring(4,8));

        UsernameField = new JTextField(15);
        UsernameField.setText(UName);
        CustNameField = new JTextField(15);
        CustNameField.setText(CustomerName);
        AmountField = new JTextField(15);
        AmountField.setText("0.0");

        JLabel FromAccountTypeLabel = new JLabel("Choose Source Account Type: ");
        JLabel ToAccountTypeLabel = new JLabel("Choose Destination Account Type: ");
        JLabel CustNameLabel = new JLabel("Customer Name:");
        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel AmountLabel = new JLabel("Amount: ");

        JPanel CheckingOrSavingsPanel = new JPanel();
        JPanel CheckingOrSavingsPanel1 = new JPanel();
        JPanel UsernamePanel = new JPanel();
        JPanel CustNamePanel = new JPanel();
        JPanel AmountPanel= new JPanel();

        CheckingOrSavingsPanel.add(FromAccountTypeLabel);
        CheckingOrSavingsPanel.add(CheckingOrSavingsBox);
        CheckingOrSavingsPanel1.add(ToAccountTypeLabel);
        CheckingOrSavingsPanel1.add(CheckingOrSavingsBox1);
        UsernamePanel.add(UsernameLabel);
        UsernamePanel.add(UsernameField);
        CustNamePanel.add(CustNameLabel);
        CustNamePanel.add(CustNameField);
        AmountPanel.add(AmountLabel);
        AmountPanel.add(AmountField);

        add(CheckingOrSavingsPanel);
        add(CheckingOrSavingsPanel1);
        add(UsernamePanel);
        add(CustNamePanel);
        add(AmountPanel);

        add(TransferButton);
        setLayout(new GridLayout(3,2));//add the two buttons on to this panel
        TransferButton.addActionListener(this); //event listener registration
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        if (arg.equals("Transfer")) { //determine which button is clicked
            //UName = UsernameField.getText(); //take actions
            //CustomerName = NameField.getText();
            Amount = AmountField.getText();
            FromAccount = (String)CheckingOrSavingsBox.getSelectedItem();
            //System.out.println("From Account at TBO = " + FromAccount);
            ToAccount = (String)CheckingOrSavingsBox1.getSelectedItem();
            //System.out.println("To Account at TBO = " + ToAccount);
            if (FromAccount.equals("From Account Type"))
                JOptionPane.showMessageDialog(null, "Please Choose To Account Number", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            else if (ToAccount.equals("To Account Type") )
            	JOptionPane.showMessageDialog(null, "Please Choose From Account Number", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            else if (Amount.equals("0.0"))
            	JOptionPane.showMessageDialog(null, "Please Enter Amount to be transferred!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			else {
				TransferControl TC = new TransferControl(CheckingAccountNumber, SavingsAccountNumber, UName, CustomerName, FromAccount, ToAccount, Amount);
				 }
		}
    }
}

public class TransferBO extends JFrame {

    private TransferPanel TB_Panel;

    public TransferBO(String UName, String CustomerName, String CA_Number, String SA_Number) {

        setTitle("Transfer Amount");
        setSize(350, 260);

         //get screen size and set the location of the frame
         Toolkit tk = Toolkit.getDefaultToolkit();
         Dimension d = tk.getScreenSize();
         int screenHeight = d.height;
         int screenWidth = d.width;
         setLocation( screenWidth / 3, screenHeight / 4);

         addWindowListener (new WindowAdapter()  //handle window event
            {
		       public void windowClosing (WindowEvent e)
			                  { System.exit(0);
               }
            });

         Container contentPane = getContentPane(); //add a panel to a frame
         TB_Panel = new TransferPanel(UName, CustomerName, CA_Number, SA_Number);
         contentPane.add(TB_Panel);
         show();
    }
}
