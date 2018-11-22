package com.java;

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.kanch.*;

public class WithdrawControl
{

	private String  ToAcc, FromAcc, C_ID;

	public WithdrawControl(String UName, String CustomerName, String FromAcc, String ToAcc, String CA_Number, String SA_Number, String Amount) {
		System.out.println("Checking at Withdrawcontrol: " + CA_Number);
		System.out.println("Saving at Withdrawcontrol: " +SA_Number);
		if(FromAcc.equals("Checking..."+CA_Number.substring(4,8))) {
			CheckingAccount CA = new CheckingAccount(CA_Number, CustomerName, UName, Amount);
			if (CA.Withdraw(UName)) {
			  Transactions TZ = new Transactions(UName, Amount, FromAcc, ToAcc);
			  String TransactionNumber = TZ.recordTransaction();
			  if (!TransactionNumber.equals(""))
			 	 JOptionPane.showMessageDialog(null, "Transaction Recorded Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			  else
			 	 JOptionPane.showMessageDialog(null, "Withdraw failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			  } else
			       JOptionPane.showMessageDialog(null, "Withdraw Failed at Checking!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		   } else if (FromAcc.equals("Savings..."+ SA_Number.substring(4,8))) {
			   SavingsAccount SA = new SavingsAccount(SA_Number, CustomerName, UName, Amount);
			   if (SA.Withdraw(UName)) {
			   Transactions TZ = new Transactions(UName, Amount, FromAcc, ToAcc);
			   String TransactionNumber = TZ.recordTransaction();
			   if (!TransactionNumber.equals(""))
			 	 JOptionPane.showMessageDialog(null, "Transaction Recorded Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			  else
			 	 JOptionPane.showMessageDialog(null, "Withdraw failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		  } else
			 	   JOptionPane.showMessageDialog(null, "Withdraw Failed at Savings", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		} else
		    JOptionPane.showMessageDialog(null, "Not Having Values!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	}
}

