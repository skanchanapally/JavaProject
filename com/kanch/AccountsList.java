package com.kanch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class AccountsList {
	
	private String customerID;
	private Vector<String> accList = new Vector<String>();

	public AccountsList(String Cust_ID) {
		customerID = Cust_ID;
	}
	
    public AccountsList() {
	}

	public Vector<String> getAccounts() {  //Method to return a CheckingAccount balance
		try {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command_Checking = "SELECT CheckingAccountNumber FROM CheckingAccount WHERE CustomerName ='"+customerID+"'"; //SQL query command for Balance
		        ResultSet Rslt_Checking = Stmt.executeQuery(SQL_Command_Checking);
		        while (Rslt_Checking.next()) {
					accList.addElement("Checking - "+Rslt_Checking.getString(1));
			    }
		        String SQL_Command_Saving = "SELECT SavingsAccountNumber FROM SavingsAccount WHERE CustomerName ='"+customerID+"'"; //SQL query command for Balance
		        ResultSet Rslt_Saving = Stmt.executeQuery(SQL_Command_Saving);
		        while (Rslt_Saving.next()) {
					accList.addElement("Savings - "+Rslt_Saving.getString(1));
			    }
//		        Rslt_Checking.next();
//		        Rslt_Checking.getString(1);
			    Stmt.close();
			    ToDB.closeConn();
		}
	    catch(java.sql.SQLException e)
	    {
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return accList;
	}
    
	public Vector<String> getAccountNumber(String accountType, String C_ID) {
		Vector<String> AccountNumber = new Vector<String>();
		try {
			DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			Connection DBConn = ToDB.openConn();
		    Statement Stmt = DBConn.createStatement();
		    String SQL_Command = "SELECT '"+accountType+"'Number from '"+accountType+"' where CustomerID='"+C_ID+"'";
		    ResultSet Rslt = Stmt.executeQuery(SQL_Command);
			while (Rslt.next()) {
				AccountNumber.add(Rslt.getString(accountType+"Number"));
			}
			Stmt.close();
			ToDB.closeConn();
		}
		catch(java.sql.SQLException e) {
			System.out.println("SQLException at "+accountType+" at getAccountNumber: " + e);
			while (e != null) {
				System.out.println("SQLState at "+accountType+" at getAccountNumber: " + e.getSQLState());
				System.out.println("Message at "+accountType+" at getAccountNumber: " + e.getMessage());
				System.out.println("Vendor "+accountType+" at getAccountNumber: " + e.getErrorCode());
				e = e.getNextException();
				System.out.println("");
			}
		}
		catch (java.lang.Exception e) {
			System.out.println("Exception at "+accountType+ " at getAccountNumber: " + e);
			e.printStackTrace ();
		}
		return AccountNumber;
	}
}
