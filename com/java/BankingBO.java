package com.java;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.kanch.*;
import java.util.Vector;

 class BankingPanel extends JPanel
   {
	  private JTabbedPane tabbedPane;
      private JPanel tabPanel_1, tabPanel_2, tabPanel_3, tabPanel_4, tabPanel_5, tabPanel_6;


	  public BankingPanel( String U_Name, String Customer_Name, String CA_Number, String SA_Number, float CheckingBalance, float SavingsBalance) {
        tabbedPane = new JTabbedPane(); //initialize a JTabbedPane object
        tabPanel_1 = new TransferPanel(U_Name, Customer_Name, CA_Number, SA_Number);
        tabPanel_2 = new OpenBankAccountPanel(U_Name, Customer_Name);
        tabPanel_3 = new AccountOverviewPanel(U_Name, Customer_Name, CA_Number, SA_Number);
        tabPanel_4 = new DepositPanel(U_Name, Customer_Name, CA_Number, SA_Number);
        tabPanel_5 = new WithdrawPanel(U_Name, Customer_Name, CA_Number, SA_Number);
        tabPanel_6 = new InquireTransactionsPanel(U_Name, Customer_Name);
        tabbedPane.addTab("Transfer", tabPanel_1); //add GUI components to Tabbed Pane
        tabbedPane.setSelectedIndex(0);
        tabbedPane.addTab("Open Bank Account", tabPanel_2);
        tabbedPane.addTab("AccountOverview", tabPanel_3);
        tabbedPane.addTab("Deposit", tabPanel_4);
        tabbedPane.addTab("Withdraw", tabPanel_5);
        tabbedPane.addTab("Transaction History", tabPanel_6);
        add(tabbedPane);
        }

       }

      public class BankingBO extends JFrame {

		   public BankingBO(String U_Name, String Customer_Name, String CA_Number, String SA_Number, float CheckingBalance, float SavingsBalance) {
			   setTitle("Banking View");
			   setSize(350, 260);
                 Toolkit tk = Toolkit.getDefaultToolkit();
				 Dimension d = tk.getScreenSize();
				 int screenHeight = d.height;
				 int screenWidth = d.width;
				 setLocation( screenWidth / 2, screenHeight / 4);
				 addWindowListener (new WindowAdapter()  //handle window event
				     {
				 	    public void windowClosing (WindowEvent e)
				 			                  { System.exit(0);
				                }
            });
            BankingPanel BP_Panel = new BankingPanel(U_Name, Customer_Name, CA_Number, SA_Number, CheckingBalance, SavingsBalance);
            Container contentPane = getContentPane();
            contentPane.add(BP_Panel);
            show();
   }
}



