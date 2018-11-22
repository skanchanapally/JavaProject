package com.java;

/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.kanch.*;

public class TransferControl {

	public TransferControl(String CheckingAccountNumber, String SavingsAccountNumber, String UName, String CustomerName, String FromAccount, String ToAccount, String Amount) {

		if (FromAccount.equals("Checking...." + CheckingAccountNumber.substring(4,8)) && ToAccount.equals("Savings...." + SavingsAccountNumber.substring(4,8))) {
			CheckingAccount CA = new CheckingAccount(CheckingAccountNumber, UName, Amount);
			if(CA.Withdraw(UName)) {
				SavingsAccount SA = new SavingsAccount(SavingsAccountNumber, UName, Amount);
				if(SA.Deposit(UName)) {
                	Transactions TZ = new Transactions(UName, Amount, FromAccount, ToAccount);
                	String TransactionNumber = TZ.recordTransaction();
                	if(!TransactionNumber.equals(""))
		          		JOptionPane.showMessageDialog(null, "Transaction Recorded Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		        	else
		           		JOptionPane.showMessageDialog(null, "Transaction Recorded UnSuccessful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			    } else
			    	JOptionPane.showMessageDialog(null, "Deposit Failed!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			} else
			   	JOptionPane.showMessageDialog(null, "Withdraw Failed due to less amount of balance!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

		} else if (FromAccount.equals("Savings...."+SavingsAccountNumber.substring(4,8)) && ToAccount.equals("Checking...."+CheckingAccountNumber.substring(4,8))) {
			SavingsAccount SA = new SavingsAccount(SavingsAccountNumber, UName, Amount);
			if (SA.Withdraw(UName)) {
				CheckingAccount CA = new CheckingAccount(CheckingAccountNumber, UName, Amount);
				if(CA.Deposit(UName)) {
					Transactions TZ = new Transactions(UName, Amount, FromAccount, ToAccount);
					String TransactionNumber = TZ.recordTransaction();
					if(!TransactionNumber.equals(""))
						JOptionPane.showMessageDialog(null, "Transaction successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Transaction failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	      		}else
					JOptionPane.showMessageDialog(null, "Withdraw failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}else
				JOptionPane.showMessageDialog(null, "Deposite failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Error.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	}
}
