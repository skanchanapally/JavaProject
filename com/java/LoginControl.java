package com.java;

/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.kanch.*;

public class LoginControl
{
    private Account Acct;
    private float CheckingBalance, SavingsBalance;

    public LoginControl(String UName, String PWord) {
		Acct = new Account(UName, PWord);
		String CustomerName = Acct.signIn();
        if (!CustomerName.equals("")) {
            System.out.println("successful!");
            JOptionPane.showMessageDialog(null, "Login is successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            //OpenBankAccountBO OpenAcctBO = new OpenBankAccountBO(UName, CustomerName);
            CheckingAccount CA= new CheckingAccount(UName);
            String CheckingAccountNumber = CA.getAccountNumber(UName);
            CheckingBalance = CA.getBalance(CheckingAccountNumber);
            SavingsAccount SA = new SavingsAccount(UName);
            String SavingsAccountNumber = SA.getAccountNumber(UName);
            SavingsBalance = SA.getBalance(SavingsAccountNumber);
            //System.out.println("Checking...." + CA_Number);
    		//System.out.println("Savings...." + SA_Number);
    		BankingBO BBO = new BankingBO(UName, CustomerName, CheckingAccountNumber, SavingsAccountNumber, CheckingBalance, SavingsBalance);
            //TransferBO TBO = new TransferBO(UName, CustomerName, CheckingAccountNumber, SavingsAccountNumber);
            //WithdrawBO WBO = new WithdrawBO(UName, CustomerName, CheckingAccountNumber, SavingsAccountNumber);
        } else{
            System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	}
}
}