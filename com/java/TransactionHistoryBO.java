package com.java;

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.kanch.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

class InquireTransactionsPanel extends JPanel implements ActionListener
{
	private JButton InquireTransactionButton;

	private JTextField UsernameField, NameField, StartdateField, EnddateField;
	private JTable table;
	private String UName, Name, Startdate, Enddate;

	private Vector TransactionStore = new Vector();
	private Vector Column_Names =  new Vector();

	public InquireTransactionsPanel(String UName, String CustomerName)
	 {
		 InquireTransactionButton = new JButton("Inquire Transaction");
		 UsernameField = new JTextField(15);
		 UsernameField.setText(UName);
		 NameField = new JTextField(CustomerName);
		 StartdateField = new JTextField(10);
		 StartdateField.setText(Startdate);
		 EnddateField = new JTextField(10);
		 EnddateField.setText(Enddate);
		 EnddateField.setActionCommand("InquireTransaction");

		JLabel InfoLabel = new JLabel("Enter Startdate and Enddate in YYYY-DD-MM format  ");
		JLabel StartdateLabel = new JLabel(" Start Date:");
		JLabel EnddateLabel = new JLabel(" End Date: ");
		JLabel NameLabel = new JLabel("Customer Name:");
        JLabel UsernameLabel = new JLabel("Username: ");

        JPanel InfoPanel = new JPanel();
        JPanel StartdatePanel = new JPanel();
		JPanel EnddatePanel = new JPanel();
		JPanel UsernamePanel = new JPanel();
		JPanel NamePanel = new JPanel();

		InfoPanel.add(InfoLabel);
		StartdatePanel.add(StartdateLabel);
		StartdatePanel.add(StartdateField);
		EnddatePanel.add(EnddateLabel);
		EnddatePanel.add(EnddateField);
		UsernamePanel.add(UsernameLabel);
		UsernamePanel.add(UsernameField);
		NamePanel.add(NameLabel);
		NamePanel.add(NameField);

		add(InfoPanel);
		add(StartdatePanel);
		add(EnddatePanel);
		add(UsernamePanel);
		add(NamePanel);
		add(InquireTransactionButton);  //add the two buttons on to this panel

        Column_Names.add(0, "Transaction Number");
        Column_Names.add(1, "Transaction Amount");
	    Column_Names.add(2, "Transaction Type");
        Column_Names.add(3, "Transaction Time");
        Column_Names.add(4, "Transaction Date");
        Column_Names.add(5, "From Account");
        Column_Names.add(6, "To Account");


 	  	table = new JTable(TransactionStore,Column_Names);
		JScrollPane sp = new JScrollPane(table);
		add(sp);

		//setLayout(new GridLayout(3,1));
       	InquireTransactionButton.addActionListener(this); //event listener registration
		EnddateField.addActionListener(this);

	}


	public void actionPerformed(ActionEvent evt)  //event handling
	{


	        String arg = evt.getActionCommand();
	        if (arg.equals("Inquire Transaction"))
	        {
	            UName = UsernameField.getText(); //take actions
	            Name = NameField.getText();
	            Startdate = StartdateField.getText();
	            Enddate = EnddateField.getText();


	            if (Startdate.equals(""))
				   JOptionPane.showMessageDialog(null, "Please enter start date!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				if (Enddate.equals(""))
				        JOptionPane.showMessageDialog(null, "Please enter End date!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

				else
				{
				  		Transactions TA = new Transactions(Startdate, Enddate);
				  		TransactionStore = TA.searchTransaction(UName);
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        for (Object Column_Names : TransactionStore){
                         	model.addRow((Vector)Column_Names);
						}
				}
			}
	  }
}

public class TransactionHistoryBO extends JFrame
{
    private InquireTransactionsPanel INQTRS_Panel;

    public TransactionHistoryBO(String UName, String CustomerName) //, String CheckingAccountNumber, String SavingsAccountNumber)
    {
        setTitle("Transaction History");
        setSize(370, 300);

         //get screen size and set the location of the frame
         Toolkit tk = Toolkit.getDefaultToolkit();
         Dimension d = tk.getScreenSize();
         int screenHeight = d.height;
         int screenWidth = d.width;
         setLocation( screenWidth / 3, screenHeight / 4);

         addWindowListener (new WindowAdapter()  //handle window event
         {
		       public void windowClosing (WindowEvent e)
			   {
								  System.exit(0);
               }
         });

         Container contentPane = getContentPane(); //add a panel to a frame
         INQTRS_Panel = new InquireTransactionsPanel(UName, CustomerName);//, CheckingAccountNumber, SavingsAccountNumber);
         contentPane.add(INQTRS_Panel);
         show();

	}
}