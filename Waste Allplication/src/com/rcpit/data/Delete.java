package com.rcpit.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String vehicleno=request.getParameter("vehicleno");
		try
		{
			 Connection con=CoonnectionDB.connect();
			 PreparedStatement ps1=con.prepareStatement("select * from vehicle where vno=?");
			 ps1.setString(1,vehicleno);
			 ResultSet rs=ps1.executeQuery();
			 while(rs.next())
			 {
					 PreparedStatement ps2=con.prepareStatement("delete from vehicle where vno=?");
				 	 ps2.setString(1,vehicleno);
					 int rs1=ps2.executeUpdate();
				 	if(rs1==0)
					{
				 		response.sendRedirect("deletleVehicle.html");
					}
					else
					{
						response.sendRedirect("view.jsp");
					}
			 } 
			
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}

}
