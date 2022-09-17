package protrack.com.frame.util;

import java.sql.*;

public class DatabaseReader{

	Connection conn=null;
	PropertyFileReader prop=new PropertyFileReader();
	Object [] colValue=new Object[100];

	public synchronized  void getConnectToDB()throws SQLException {
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//Connect to the database
			conn=DriverManager.getConnection(prop.getPropertyData("db_Url"),prop.getPropertyData("db_Username"),prop.getPropertyData("db_Password"));
			if(conn!=null)
                  System.out.println("Database successfully connected");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized ResultSet getResultSetFromQuery(String db_Query) throws SQLException {
		if(conn==null) {getConnectToDB();}
		//Create statement
		Statement stmt=conn.createStatement();
		//Execute queries and storing result in the result-set
		ResultSet rset=stmt.executeQuery(db_Query);
		return rset;
	}

	public Object [] getColumnValueFromResultSet(String db_Query ) throws SQLException {
		ResultSet rset = getResultSetFromQuery(prop.getPropertyData(db_Query));
		ResultSetMetaData metaData = rset.getMetaData();
		int count = metaData.getColumnCount();
		while (rset.next()) 	
		{
			for (int i = 1; i <= count; i++)
			{
				String columnName = metaData.getColumnName(i);
				int type = metaData.getColumnType(i);
				switch(type){
					
					case Types.VARCHAR:
					case Types.CHAR:
						System.out.print(rset.getString(columnName)+"\t");
						colValue[i]= rset.getString(columnName);
						break;
					
					case Types.INTEGER:	
						System.out.print(rset.getInt(columnName)+"\t");
						colValue[i]= rset.getInt(columnName);
						break;
						
					case Types.DATE:
						System.out.print(rset.getDate(columnName)+"\t");
						colValue[i]= rset.getDate(columnName);
						break;
						
					default:
						System.out.print(rset.getString(columnName)+"\t");
						colValue[i]= rset.getString(columnName);
				}
			}
		}
			return colValue;
		}

	public synchronized void closeDBConnection() {
		// Closing the database connection
	      try {
	    	if(conn!=null)
			conn.close();
			 if (conn.isClosed()) 
			  System.out.println("Connection closed.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	} 
}
