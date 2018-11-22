package com.kanch;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import com.kanch.*;

public class SavingsAccount{
	private String SavingsAccountNumber, CustomerName, UName;
	private float Balance = -1, Amount = -1;

	public SavingsAccount(String SA_Number, String Cust_Name, String C_ID, String Amt) { //Constructor One with three parameters
		SavingsAccountNumber = SA_Number;
		CustomerName = Cust_Name;
		UName = C_ID;
		Amount = Float.parseFloat(Amt);
		//IntrestRate = Float.parseFloat(Intrest_Rate);
	}

	public SavingsAccount(String SA_Number) { //Constructor Two with one parameter
		SavingsAccountNumber = SA_Number;
	}

	public SavingsAccount() {
	}

	public SavingsAccount(String SA_Number, String U_Name, String Amo) {
    	SavingsAccountNumber = SA_Number;
    	UName = U_Name;
    	Amount = Float.parseFloat(Amo);
    }


	public boolean OpenAcct() {
		boolean done = false;
			try {
				if (!done) {
					DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				    Connection DBConn = ToDB.openConn();
				    Statement Stmt = DBConn.createStatement();
				    String SQL_Command = "SELECT SavingsAccountNumber FROM SavingsAccount WHERE SavingsAccountNumber ='"+SavingsAccountNumber+"'"; //SQL query command
				    ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				    done = !Rslt.next();
				    if (done) {
					SQL_Command = "INSERT INTO SavingsAccount(SavingsAccountNumber, CustomerName, Balance, CustomerID)"+
						          " VALUES ('"+SavingsAccountNumber+"','"+CustomerName+"',"+Balance+", '"+UName+"')"; //Save the username, password and Name
					Stmt.executeUpdate(SQL_Command);
					}
					Stmt.close();
					ToDB.closeConn();
				}
			}
			catch(java.sql.SQLException e) {
				done = false;
				System.out.println("SQLException at Saving at OpenAcct: " + e);
				while (e != null) {
					System.out.println("SQLState at Saving at OpenAcct: " + e.getSQLState());
					System.out.println("Message at Saving at OpenAcct: " + e.getMessage());
					System.out.println("Vendor at Saving at OpenAcct: " + e.getErrorCode());
					e = e.getNextException();
					System.out.println("");
				}
			}
			catch (java.lang.Exception e) {
				done = false;
				System.out.println("Exception at Saving at OpenAcct: " + e);
				e.printStackTrace ();
			}
	    	return done;
	}


	public String getAccountNumber(String C_ID) {
		try {
			DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			Connection DBConn = ToDB.openConn();
		    Statement Stmt = DBConn.createStatement();
		    String SQL_Command = "SELECT SavingsAccountNumber from SavingsAccount where CustomerID='"+C_ID+"'";
		    ResultSet Rslt = Stmt.executeQuery(SQL_Command);
			while (Rslt.next()) {
				SavingsAccountNumber = Rslt.getString("SavingsAccountNumber");
			}
			Stmt.close();
			ToDB.closeConn();
		}
		catch(java.sql.SQLException e) {
			System.out.println("SQLException at Saving at getAccountNumber: " + e);
			while (e != null) {
				System.out.println("SQLState at Saving at getAccountNumber: " + e.getSQLState());
				System.out.println("Message at Saving at getAccountNumber: " + e.getMessage());
				System.out.println("Vendor Saving at getAccountNumber: " + e.getErrorCode());
				e = e.getNextException();
				System.out.println("");
			}
		}
		catch (java.lang.Exception e) {
			System.out.println("Exception at Saving at getAccountNumber: " + e);
			e.printStackTrace ();
		}
		return SavingsAccountNumber;
	}


    public float getBalance() {  //Method to return a CheckingAccount balance
		try {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber ='"+SavingsAccountNumber+"'"; //SQL query command for Balance
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command);

		        while (Rslt.next()) {
					Balance = Rslt.getFloat(1);
			    }
			    Stmt.close();
			    ToDB.closeConn();
		}
	    catch(java.sql.SQLException e)
	    {
				 System.out.println("SQLException at Saving at getBalance: " + e);
				 while (e != null)
				 {   System.out.println("SQLState at Saving at getBalance: " + e.getSQLState());
					 System.out.println("Message at Saving at getBalance: " + e.getMessage());
					 System.out.println("Vendor at Saving at getBalance: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {
				 System.out.println("Exception at Saving at getBalance: " + e);
				 e.printStackTrace ();
	    }
	    return Balance;
	}

    public float getBalance(String SavAcctNumber) {  //Method to return a CheckingAccount balance
		try {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber ='"+SavAcctNumber+"'"; //SQL query command for Balance
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command);

		        while (Rslt.next()) {
					Balance = Rslt.getFloat(1);
			    }
			    Stmt.close();
			    ToDB.closeConn();
		}
	    catch(java.sql.SQLException e)
	    {
				 System.out.println("SQLException at Saving at getBalance(): " + e);
				 while (e != null)
				 {   System.out.println("SQLState at Saving at getBalance(): " + e.getSQLState());
					 System.out.println("Message at Saving at getBalance(): " + e.getMessage());
					 System.out.println("Vendor at Saving at getBalance(): " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {
				 System.out.println("Exception at Saving at getBalance(): " + e);
				 e.printStackTrace ();
	    }
	    return Balance;
	}


	public boolean Withdraw(String C_ID){
				boolean done = !SavingsAccountNumber.equals("") && !C_ID.equals("");
				try{
					if(done){
					DBConnection ToDB = new DBConnection(); //Have a connection to the DB
					Connection DBConn = ToDB.openConn();
			        Statement Stmt = DBConn.createStatement();
			        String SQL_Command = "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber='"+SavingsAccountNumber+"' and CustomerID='"+C_ID+"'";
			        ResultSet rslt = Stmt.executeQuery(SQL_Command);
			        while(rslt.next())
			        	Balance = rslt.getFloat(1);
			        if(Balance >= Amount) {
			        	Balance -= Amount;
			        	SQL_Command = "UPDATE SavingsAccount SET Balance="+Balance+" WHERE SavingsAccountNumber= '"+SavingsAccountNumber+"'";
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
				   				 System.out.println("SQLException at Saving at withdraw: " + e);
				   				 while (e != null)
				   				 {   System.out.println("SQLState at Saving at withdraw: " + e.getSQLState());
				   					 System.out.println("Message at Saving at withdraw: " + e.getMessage());
				   					 System.out.println("Vendor at Saving at withdraw: " + e.getErrorCode());
				   					 e = e.getNextException();
				   					 System.out.println("");
				   				 }
				   	    }
				   	    catch (java.lang.Exception e)
				   	    {
				   				 System.out.println("Exception at Saving at withdraw: " + e);
				   				 e.printStackTrace ();
				   	    }
				   	    return done;
		}

		// ----- Function Deposit ---------- Function Deposit -----

		public boolean Deposit(String C_ID){
			System.out.println("Saving Account Number = " + SavingsAccountNumber);
			boolean done = !SavingsAccountNumber.equals("") && !C_ID.equals("");
			try {
				if(done){
						  DBConnection ToDB = new DBConnection(); //Have a connection to the DB
						  Connection DBConn = ToDB.openConn();
			              Statement Stmt = DBConn.createStatement();
			              String SQL_Command = "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber='"+SavingsAccountNumber+"' and CustomerID='"+C_ID+"'";
						  ResultSet rslt = Stmt.executeQuery(SQL_Command);
			              while(rslt.next())
							  Balance = rslt.getFloat(1);
						if(done) {
							Balance += Amount;
							SQL_Command = "UPDATE SavingsAccount SET Balance="+Balance+" WHERE SavingsAccountNumber= '"+SavingsAccountNumber+"'";
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
			 			   				 System.out.println("SQLException at Saving at deposit: " + e);
			 			   				 while (e != null)
			 			   				 {   System.out.println("SQLState at Saving at deposit: " + e.getSQLState());
			 			   					 System.out.println("Message at Saving at deposit: " + e.getMessage());
			 			   					 System.out.println("Vendor at Saving at deposit: " + e.getErrorCode());
			 			   					 e = e.getNextException();
			 			   					 System.out.println("");
			 			   				 }
			 			   	    }
			 			   	    catch (java.lang.Exception e)
			 			   	    {
			 			   				 System.out.println("Exception at Saving at deposit: " + e);
			 			   				 e.printStackTrace ();
			 			   	    }
			 			   	    return done;
	}
}