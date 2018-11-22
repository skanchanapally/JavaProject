package com.java;

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.kanch.*;

public class DepositControl {

	private String  ToAcc, FromAcc, C_ID;


	public DepositControl(String UName, String CustomerName, String FromAcc, String ToAcc, String CA_Number, String SA_Number, String Amount) {
		System.out.println(ToAcc);
		if(ToAcc.equals("Checking...." + CA_Number.substring(4,8))) {
			CheckingAccount CA = new CheckingAccount(CA_Number, CustomerName, UName, Amount);
			if(CA.Deposit(UName)) {
				Transactions TZ = new Transactions(UName, Amount, FromAcc, ToAcc);
				String TransactionNumber = TZ.recordTransaction();
				if(!TransactionNumber.equals(""))
					JOptionPane.showMessageDialog(null, "Deposit Transaction Recorded Successful at Checking!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Deposit Transaction Failed at Checking!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "Deposit Failed at Checking!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		} else if(ToAcc.equals("Savings...." + SA_Number.substring(4,8))) {
			SavingsAccount SA = new SavingsAccount(SA_Number, CustomerName, UName, Amount);
			if(SA.Deposit(UName)) {
				Transactions TZ = new Transactions(UName, Amount, FromAcc, ToAcc);
				String TransactionNumber = TZ.recordTransaction();
				if(!TransactionNumber.equals(""))
					JOptionPane.showMessageDialog(null, "Transaction Recorded Successful at Savings!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Transaction Recorded Failed at Savings!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "Deposit Failed at Savings!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "Not Having Values!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	}
}