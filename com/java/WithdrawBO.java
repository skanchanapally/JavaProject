package com.java;

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.kanch.*;


class WithdrawPanel extends JPanel implements ActionListener
{
    private JButton WithdrawButton;
    private JTextField UserNameField, NameField;
    private JTextField AmountField;
    private JComboBox AccBox;
    private String CustomerName, FromAcc, ToAcc = "", Amount, SavingsAccountNumber, CheckingAccountNumber, UName;
    private String CA_Number, SA_Number;


    public WithdrawPanel(String U_Name, String Customer_Name, String CA_Number, String SA_Number)
    {
		UName = U_Name;
		CustomerName = Customer_Name;
		CheckingAccountNumber =  CA_Number;
		SavingsAccountNumber = SA_Number;
        WithdrawButton = new JButton("Withdraw"); //initializing two button references

        AccBox = new JComboBox();
		AccBox.addItem("Choose Account No");
	    AccBox.addItem("Checking..."+ CheckingAccountNumber.substring(4,8));
		AccBox.addItem("Savings..."+SavingsAccountNumber.substring(4,8));

        UserNameField = new JTextField(15);
		UserNameField.setText(UName);
		UserNameField.setEditable(false);
		NameField = new JTextField(CustomerName);
		NameField.setEditable(false);
		AmountField = new JTextField(10);
        AmountField.setText("0.0");

        JLabel NameLabel = new JLabel("Customer Name:");
        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel AmountLabel = new JLabel("Amount to Withdraw:");

        JPanel AccPanel = new JPanel();
        JPanel UsernamePanel = new JPanel();
        JPanel NamePanel = new JPanel();
        JPanel AmountPanel = new JPanel();

        AccPanel.add(AccBox);
        UsernamePanel.add(UsernameLabel);
		UsernamePanel.add(UserNameField);
		NamePanel.add(NameLabel);
        NamePanel.add(NameField);
        AmountPanel.add(AmountLabel);
        AmountPanel.add(AmountField);

        add(AccPanel);
        add(UsernamePanel);
        add(NamePanel);
        add(AmountPanel);

        add(WithdrawButton);  //add the button on to this panel
        WithdrawButton.addActionListener(this); //event listener registration
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        String arg = evt.getActionCommand();
        if (arg.equals("Withdraw")) { //determine which button is clicked
            FromAcc = (String)AccBox.getSelectedItem();
            UName = UserNameField.getText(); //take actions
            CustomerName = NameField.getText();
            Amount = AmountField.getText();
            if (FromAcc.equals("Choose Account No"))
                JOptionPane.showMessageDialog(null, "Please Choose Account Number!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
           		else if (Amount.equals("00.00"))
                     JOptionPane.showMessageDialog(null, "Please Enter Amount to be Withdrawn!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            		else
            		{
						WithdrawControl With_Ctrl = new WithdrawControl(UName, CustomerName, FromAcc, ToAcc, CheckingAccountNumber, SavingsAccountNumber, Amount);
					}
            }
    }
}

public class WithdrawBO extends JFrame
{
    private WithdrawPanel Withdraw_Panel;

    public WithdrawBO(String UName, String CustomerName, String CA_Number, String SA_Number)
    {
        setTitle("Withdraw Amount");
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
         Withdraw_Panel = new WithdrawPanel( UName,  CustomerName,  CA_Number, SA_Number);
         contentPane.add(Withdraw_Panel);
         show();
    }
}