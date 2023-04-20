package com.rcpit.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class CoonnectionDB {
	static Connection con=null;
	public static Connection connect()
	{
		try
		{
			if(con== null)
			{
				Class.forName("com.mysql.jdbc.Driver");
				//System.out.println("Driver loaded");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/waste_management","root","");
			//	System.out.println("Connection establish");
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		return con;
	}

}
