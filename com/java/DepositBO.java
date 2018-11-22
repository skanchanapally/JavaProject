package com.java;

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.kanch.*;

class DepositPanel extends JPanel implements ActionListener {
	private JButton DepositButton;
	private JTextField UserNameField, NameField, AmountField;
	private JComboBox AccBox;
	private String CustomerName, ToAcc,FromAcc = "", UName, SavingsAccountNumber, CheckingAccountNumber, Name, Amount;


	public DepositPanel(String U_Name, String Customer_Name, String CA_Number, String SA_Number) {
		CustomerName=Customer_Name;
		UName=U_Name;
	    CheckingAccountNumber = CA_Number;
	    SavingsAccountNumber = SA_Number;

		//CheckingAccount CA = new CheckingAccount();
		//CA_Number = CA.getAccountNumber(UName);
		//SavingsAccount SA = new SavingsAccount();
		//SA_Number = SA.getAccountNumber(UName);

        DepositButton = new JButton("Deposit");

        AccBox = new JComboBox();
        AccBox.addItem("Choose Account Type");
        AccBox.addItem("Checking...."+CA_Number);
        AccBox.addItem("Savings...."+SA_Number);


		UserNameField = new JTextField(15);
        UserNameField.setText(UName);
        UserNameField.setEditable(false);
        NameField = new JTextField(CustomerName);
        NameField.setEditable(false);
        AmountField = new JTextField(10);
        AmountField.setText("0.0");


        JLabel NameLabel = new JLabel("Customer Name:");
		JLabel UserNameLabel = new JLabel("Username: ");
		JLabel AmountLabel = new JLabel("Amount to Withdraw:");

		JPanel AccPanel = new JPanel();
		JPanel UserNamePanel = new JPanel();
		JPanel NamePanel = new JPanel();
		JPanel AmountPanel = new JPanel();

		 AccPanel.add(AccBox);
		 UserNamePanel.add(UserNameLabel);
	     UserNamePanel.add(UserNameField);
	     NamePanel.add(NameLabel);
		 NamePanel.add(NameField);
		 AmountPanel.add(AmountLabel);
		 AmountPanel.add(AmountField);

		 add(AccPanel);
		 add(UserNamePanel);
		 add(NamePanel);
		 add(AmountPanel);

		 add(DepositButton);  //add the button on to this panel
		 //setLayout(new GridLayout(3,2));
		 DepositButton.addActionListener(this); //event listener registration
    }
		public void actionPerformed(ActionEvent evt)  //event handling
		    {
               String arg = evt.getActionCommand();
               if(arg.equals("Deposit")) {
				   ToAcc = (String)AccBox.getSelectedItem();
				   UName = UserNameField.getText();
				   CustomerName = NameField.getText();
				   Amount = AmountField.getText();
				   if(ToAcc.equals("Choose Account Type"))
				      JOptionPane.showMessageDialog(null, "Please Choose Account Number!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				      else if (Amount.equals("0.0"))
				         JOptionPane.showMessageDialog(null, "Please enter Amount!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				          else
				            {
				              DepositControl DC = new DepositControl(UName, CustomerName, FromAcc,ToAcc, CheckingAccountNumber, SavingsAccountNumber, Amount);
						     }
						 }
					 }
				 }
public class DepositBO extends JFrame
{
    private DepositPanel Deposit_Panel;

		public DepositBO(String UName, String CustomerName, String CA_Number, String SA_Number)
		    {
		        setTitle("Deposit Amount");
		        setSize(400, 300);

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
		         Deposit_Panel = new DepositPanel(UName, CustomerName, CA_Number, SA_Number);
		         contentPane.add(Deposit_Panel);
		         show();
		    }
		}



