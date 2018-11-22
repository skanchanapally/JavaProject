//package com.java;
//
//import java.util.*;
//import java.sql.*;
//
//public class EnquireTransaction {
//	private String UName, StartDate, EndDate;
//	public String FetchTransaction(Uname, StartDate, EndDate) {
//		try {
//			  DBConnection ToDB = new DBConnection();
//			  Connection DBConn = ToDB.openConn();
//			  Statement stmt = DBConn.createStatement();
//			  String SQL_Command = " SELECT * FROM Transactions WHERE CustomerID = '"+UName+"' AND TransactionDate BETWEEN '"+StartDate+"' AND '"+EndDate+"'";
//	          ResultSet rslt = stmt.executeQuery(SQL_Command);
//		  }
//		  Stmt.close();
//		  ToDB.closeConn();
//	  }
//	  catch ( Exception e ) {
//	              e.printStackTrace();
//	              connection = null;
//        }
//
//	 public Vector getNextRow(ResultSet rslt, ResultSetMetadata rsmd) throws SQLException
//	 {
//		public Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException
//	 {
//	     Vector currentRow = new Vector();
//
//	     for(int i=1;i<=rsmd.getColumnCount();i++)
//	         switch(rsmd.getColumnType(i))
//	         {
//	              case Types.VARCHAR:
//	              case Types.LONGVARCHAR:
//	                   currentRow.addElement(rslt.getString(i));
//	                   break;
//	              case Types.INTEGER:
//	                   currentRow.addElement(new Long(rslt.getLong(i)));
//	                   break;
//	              case Types.DOUBLE:
//	              	   currentRow.addElement(new Double(rslt.getDouble(i)));
//	                   break;
//	              case Types.FLOAT:
//	              	   currentRow.addElement(new Float(rslt.getFloat(i)));
//	                   break;
//	              default:
//	                   System.out.println("Type was: "+ rsmd.getColumnTypeName(i));
//	          }
//
//	          return currentRow;
//    }
//}