package com.java;

/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.kanch.*;

public class OpenBankAccountControl
{

    public OpenBankAccountControl(String AccountType, String  AccountNumber, String  Name, String  UName, String  Balance) {
		//Use CheckingAccount object to invoke method openAcct()
		if (AccountType.equals("Checking")) {
			CheckingAccount CA = new CheckingAccount(AccountNumber, Name, UName, Balance);
            if (CA.openAcct()) {
            //System.out.println("successful!");
                JOptionPane.showMessageDialog(null, "Opening a Checking Account is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                Transactions TN = new Transactions(AccountType, UName, Balance);
				String TransactionNumber = TN.recordTransaction();
				if (!TransactionNumber.equals("")) {
				//system.out.println("successful!");
			    JOptionPane.showMessageDialog(null, "Transaction Recorded Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				} else {
				   //system.out.println("fail!");
					JOptionPane.showMessageDialog(null, "Transaction Fail!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
         } else{
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Opening a Checking Account failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}
	}
		else{
			SavingsAccount SA= new SavingsAccount(AccountNumber, Name, UName, Balance);
			if(SA.OpenAcct()){
				//System.out.println("successful!");
			     JOptionPane.showMessageDialog(null, "Opening a Savings Account is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			     Transactions TN = new Transactions(AccountType, UName, Balance);
				 String TransactionNumber = TN.recordTransaction();
				 if (!TransactionNumber.equals("")) {
				 //system.out.println("successful!");
		         JOptionPane.showMessageDialog(null, "Transaction Recorded Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				 } else {
				 	//system.out.println("fail!");
				 	 JOptionPane.showMessageDialog(null, "Transaction Fail!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		    }
		  }else {
				//System.out.println("fail!");
			 	JOptionPane.showMessageDialog(null, "Opening a Savings Account failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}