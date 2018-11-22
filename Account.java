/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/

package com.kanch;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import com.kanch.*;

public class Account
{
	private String Username, Password, Password1, Name;

	public Account(String UN, String PassW, String PassW1, String NM) {
		Username = UN;
		Password = PassW;
		Password1 = PassW1;
		Name = NM;
	}

    public boolean signUp() {
		boolean done = !Username.equals("") && !Password.equals("") && !Password1.equals("") && Password.equals(Password1);
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Username FROM Account WHERE Username ='"+Username+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Account(Username, Password, Name) VALUES ('"+Username+ "','"+Password+"','"+Name+"')"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
			    }
			    Stmt.close();
			    ToDB.closeConn();
			}
		}
	    catch(java.sql.SQLException e)
	    {         done = false;
				 System.out.println("SQLException at Account: " + e);
				 while (e != null)
				 {   System.out.println("SQLState at Account: " + e.getSQLState());
					 System.out.println("Message at Account: " + e.getMessage());
					 System.out.println("Vendor at Account: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {         done = false;
				 System.out.println("Exception at Account: " + e);
				 e.printStackTrace ();
	    }
	    return done;
	}
	    public String signIn(){
				    String name = "";
					boolean done = !Username.equals("") && !Password.equals("");
					try{
						if(done){
							DBConnection ToDB = new DBConnection(); //Have a connection to the DB
					        Connection DBConn = ToDB.openConn();
					        Statement Stmt = DBConn.createStatement();
						    String SQL_Command = "SELECT * FROM Account WHERE Username ='"+Username+ "'AND Password ='"+Password+"'";
					        ResultSet Rslt = Stmt.executeQuery(SQL_Command);
					        done = done && Rslt.next();
					        if(done){
								name = Rslt.getString("Name");
							}
					 }
				 }
				 catch(java.sql.SQLException e){
				           done=false;
				           System.out.println("SQLException at Account: " + e);
				           while (e != null)
						   				 {   System.out.println("SQLState at Account: " + e.getSQLState());
						   					 System.out.println("Message at Account: " + e.getMessage());
						   					 System.out.println("Vendor at Account: " + e.getErrorCode());
						   					 e = e.getNextException();
						   					 System.out.println("");
						   				 }
							}
				return name;
				   	}
        public boolean changePassword(String NewPassword) {	//5
		boolean done = false;
		try {		//20
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT * FROM Account WHERE Username ='"+Username+ "'AND Password ='"+Password+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        if (Rslt.next()) {
				    SQL_Command = "UPDATE Account SET Password='"+NewPassword+"' WHERE Username ='"+Username+"'"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
			        Stmt.close();
			        ToDB.closeConn();
                    done=true;
				}
		}
	    catch(java.sql.SQLException e)		//5
	    {         done = false;
				 System.out.println("SQLException at Account: " + e);
				 while (e != null)
				 {   System.out.println("SQLState at Account: " + e.getSQLState());
					 System.out.println("Message at Account: " + e.getMessage());
					 System.out.println("Vendor at Account: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {         done = false;
				 System.out.println("Exception at Account: " + e);
				 e.printStackTrace ();
	    }
	    return done;
	}
}