package com.java;

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.kanch.*;

class AccountOverviewPanel extends JPanel implements ActionListener {
		private JButton Refresh, Intrest;
	    private JTextField UserNameField, NameField, CheckingAccountNoField, SavingsAccountNoField,SavingsBalanceField, CheckingBalanceField;
	    private String  UName, CustomerName, CheckingAccountBalance, SavingsAccountBalance, CheckingAccountNumber, SavingsAccountNumber;
	    private String CA_Number, SA_Number;
		SavingsAccount SA;
		CheckingAccount CA;

	    public AccountOverviewPanel(String U_Name, String Customer_Name, String CA_Number, String SA_Number) {
		UName = U_Name;
		CustomerName = Customer_Name;
		CheckingAccountNumber = CA_Number;
		SavingsAccountNumber = SA_Number;
	    SA = new SavingsAccount();
		SA_Number = SA.getAccountNumber(UName);
		CA = new CheckingAccount();
		CA_Number = CA.getAccountNumber(UName);

	    Refresh = new JButton("Refresh");
		Intrest = new JButton("Intrest");

        CheckingAccountNoField = new JTextField(8);
        CheckingAccountNoField.setText("Checking...."+CheckingAccountNumber.substring(4,8));
        CheckingAccountNoField.setEditable(false);

        CheckingBalanceField = new JTextField(8);
        CheckingBalanceField.setText(String.valueOf(CA.getBalance()));
        //CheckingBalanceField.setEditable(false);

        SavingsAccountNoField = new JTextField(8);
        SavingsAccountNoField.setText("Savings...."+SavingsAccountNumber.substring(4,8));
        SavingsAccountNoField.setEditable(false);

        SavingsBalanceField = new JTextField(8);
        SavingsBalanceField.setText(String.valueOf(SA.getBalance()));
        //SavingsBalanceField.setEditable(false);

        UserNameField = new JTextField(15);
        UserNameField.setText(UName);
        UserNameField.setEditable(false);
        NameField = new JTextField(CustomerName);
        NameField.setEditable(false);

        JLabel UserNameLabel = new JLabel("UserName:");
        JLabel NameLabel = new JLabel("CustomerName:");
        JLabel CheckingAccountNoLabel = new JLabel("Checking Account Number:");
        JLabel SavingsAccountNoLabel = new JLabel("Savings Account Number:");
        JLabel CheckingBalanceLabel = new JLabel("Checking Account Balance:");
        JLabel SavingsBalanceLabel = new JLabel("Savings Account Balance:");


        JPanel UserNamePanel = new JPanel();
        JPanel NamePanel = new JPanel();
        JPanel CheckingAccountNoPanel = new JPanel();
        JPanel SavingsAccountNoPanel = new JPanel();
        JPanel CheckingBalancePanel = new JPanel();
        JPanel SavingsBalancePanel = new JPanel();

        UserNamePanel.add(UserNameLabel);
        UserNamePanel.add(UserNameField);
        NamePanel.add(NameLabel);
        NamePanel.add(NameField);
        CheckingAccountNoPanel.add(CheckingAccountNoLabel);
        CheckingAccountNoPanel.add(CheckingAccountNoField);
        SavingsAccountNoPanel.add(SavingsAccountNoLabel);
        SavingsAccountNoPanel.add(SavingsAccountNoField);
        CheckingBalancePanel.add(CheckingBalanceLabel);
        CheckingBalancePanel.add(CheckingBalanceField);
        SavingsBalancePanel.add(SavingsBalanceLabel);
        SavingsBalancePanel.add(SavingsBalanceField);

        add(UserNamePanel);
        add(NamePanel);
        add(CheckingAccountNoPanel);
        add(SavingsAccountNoPanel);
        add(CheckingBalancePanel);
        add(SavingsBalancePanel);

        add(Refresh);
        add(Intrest);

        setLayout(new GridLayout(3,2));
        Refresh.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt)  //event handling
		    {
		       //Object source = evt.getSource(); //get who generates this event
               String arg = evt.getActionCommand();
               if(arg.equals("Refresh")) {
				   //UName = UserNameField.getText();
				   //CustomerName = NameField.getText();
				   //CheckingAccountNumber = CheckingAccountNoField.getText();
				   //SavingsAccountNumber = SavingsAccountNoField.getText();
				   //CheckingAccountBalance = CheckingBalanceField.getText();
				   //SavingsAccountBalance =  SavingsBalanceField.getText();
				   //CheckingBalanceField.setEditable(true);
				   CheckingBalanceField.setText(String.valueOf(CA.getBalance(CheckingAccountNumber)));
				   //CheckingBalanceField.setEditable(false);

				   //SavingsBalanceField.setEditable(true);
				   SavingsBalanceField.setText(String.valueOf(SA.getBalance(SavingsAccountNumber)));
				   //SavingsBalanceField.setEditable(false);


            }
		}
	}
   public class AccountOverviewBO extends JFrame {

	 private AccountOverviewPanel Overview_Panel;

	 	    public AccountOverviewBO(String UName, String CustomerName, String CA_Number, String SA_Number)
	 	    {
	 	        setTitle("Account Overview");
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
	 	         Overview_Panel = new AccountOverviewPanel(UName, CustomerName, CA_Number, SA_Number);
	 	         contentPane.add(Overview_Panel);
	 	         show();
	     }
     }

