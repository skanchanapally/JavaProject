/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: October, 2013													      *
*******************************************************************************/
package com.kanch;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import com.kanch.*;

public class CheckingAccount
{   //Instance Variables
	private String CheckingAccountNumber, CustomerName, UName;
	private float Balance = -1, Amount = -1;

	public CheckingAccount(String CA_Num, String Cust_Name, String C_ID, String Amt) { //Constructor One with three parameters
		CheckingAccountNumber = CA_Num;
		CustomerName = Cust_Name;
		UName = C_ID;
		Amount = Float.parseFloat(Amt);

	}

	public CheckingAccount(String CA_Number) { //Constructor Two with one parameter
		CheckingAccountNumber = CA_Number;
	}

    public CheckingAccount() {
	}

	public CheckingAccount(String CA_Number, String U_Name, String Amo) {
		CheckingAccountNumber = CA_Number;
		UName = U_Name;
		Amount = Float.parseFloat(Amo);
	}


    public boolean openAcct() {
	     boolean done = false;
				try {
				    if (!done) {
				        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				        Connection DBConn = ToDB.openConn();
				        Statement Stmt = DBConn.createStatement();
				        String SQL_Command = "SELECT CheckingAccountNumber FROM CheckingAccount WHERE CheckingAccountNumber ='"+CheckingAccountNumber+"'"; //SQL query command
				        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				        done = !Rslt.next();
				        if (done) {
						    SQL_Command = "INSERT INTO CheckingAccount(CheckingAccountNumber, CustomerName, Balance, CustomerID)"+
						                  " VALUES ('"+CheckingAccountNumber+"','"+CustomerName+"',"+Balance+", '"+UName+"')"; //Save the username, password and Name
						    Stmt.executeUpdate(SQL_Command);
					    }
					    Stmt.close();
					    ToDB.closeConn();
					}
				}
			    catch(java.sql.SQLException e)
			    {         done = false;
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
			    {         done = false;
						 System.out.println("Exception: " + e);
						 e.printStackTrace ();
			    }
	    return done;
	}


	public String getAccountNumber(String C_ID) {
			try {
				   DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				   Connection DBConn = ToDB.openConn();
			       Statement Stmt = DBConn.createStatement();
			       String SQL_Command = "SELECT CheckingAccountNumber from CheckingAccount where CustomerID='"+C_ID+"'";
			       ResultSet Rslt = Stmt.executeQuery(SQL_Command);

			       while (Rslt.next()) {
				       CheckingAccountNumber = Rslt.getString("CheckingAccountNumber");
				   			    }
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
				    return CheckingAccountNumber;
	}


    public float getBalance() {  //Method to return a CheckingAccount balance
		try {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Balance FROM CheckingAccount WHERE CheckingAccountNumber ='"+CheckingAccountNumber+"'"; //SQL query command for Balance
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command);

		        while (Rslt.next()) {
					Balance = Rslt.getFloat(1);
			    }
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
	    return Balance;
	}


    public float getBalance(String ChkAcctNumber) {  //Method to return a CheckingAccount balance
		try {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Balance FROM CheckingAccount WHERE CheckingAccountNumber ='"+ChkAcctNumber+"'"; //SQL query command for Balance
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command);

		        while (Rslt.next()) {
					Balance = Rslt.getFloat(1);
			    }
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
	    return Balance;
	}

	public boolean Withdraw(String C_ID){
		boolean done = !CheckingAccountNumber.equals("") && !C_ID.equals("");
			try{
				if(done){
					DBConnection ToDB = new DBConnection(); //Have a connection to the DB
					Connection DBConn = ToDB.openConn();
		        	Statement Stmt = DBConn.createStatement();
		        	String SQL_Command = "SELECT Balance FROM CheckingAccount WHERE CheckingAccountNumber='"+CheckingAccountNumber+"' and CustomerID='"+C_ID+"'";
		        	ResultSet rslt = Stmt.executeQuery(SQL_Command);
		        	while(rslt.next()) {
		        		Balance = rslt.getFloat(1);
					}
		        	if(Balance >= Amount) {
						Balance = Balance - Amount;
		        		SQL_Command = "UPDATE CheckingAccount SET Balance="+Balance+" WHERE CheckingAccountNumber= '"+CheckingAccountNumber+"'";
		        		Stmt.executeUpdate(SQL_Command);
		        		done = true;
					} else
						done = false;
			   		Stmt.close();
		       		ToDB.closeConn();
		   		}
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
			   	    return done;
	}

	public boolean Deposit(String C_ID){
		boolean done = !CheckingAccountNumber.equals("") && !C_ID.equals("");
		try {
			if(done){
				DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Balance FROM CheckingAccount WHERE CheckingAccountNumber='"+CheckingAccountNumber+"' and CustomerID='"+C_ID+"'";
				ResultSet rslt = Stmt.executeQuery(SQL_Command);
		        while(rslt.next())
						  Balance= rslt.getFloat(1);
				if(done) {
					Balance += Amount;
					SQL_Command = "UPDATE CheckingAccount SET Balance="+Balance+" WHERE CheckingAccountNumber= '"+CheckingAccountNumber+"'";
					Stmt.executeUpdate(SQL_Command);
					done = true;
				} else
					done = false;
				Stmt.close();
		        ToDB.closeConn();
			}
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
		 			   	    return done;
	}






}