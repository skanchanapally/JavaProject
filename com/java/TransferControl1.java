package com.java;

/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import java.util.Vector;

import javax.swing.*;
import com.kanch.*;

public class TransferControl1 {
	
	public Vector<String> accList;

	public TransferControl1(String Cust_ID) {
		AccountsList AL = new AccountsList(Cust_ID);
		accList = AL.getAccounts();
	}
}