//package com.java;
//
//import java.lang.*; //including Java packages used by this program
//import javax.swing.*;
//import com.kanch.*;
//
//public class EnquireTransactioControl
//{
//	private EnquireTransaction ET;
//	public EnquireTransactionControl(String UName, String StartDate, String EndDate) {
//		ET = new EnquireTransaction(UName, StartDate, EndDate);
//		String ABC = ET.FetchTransaction();
//		JOptionPane.showMessageDialog(null, "ETC Successful", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
//		EnquireTransactionBO ETCBO = new EnquireTransactionBO();
//	}