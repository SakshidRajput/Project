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
 * Servlet implementation class UpdateVeh
 */
public class UpdateVeh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVeh() {
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
		int num=0;
		String name=request.getParameter("drivername");
		String contact=request.getParameter("drivercontact");
		int id=Integer.parseInt(request.getParameter("id"));
		try
		{
			Connection con=CoonnectionDB.connect();
			PreparedStatement ps1=con.prepareStatement("select * from vehicle where id=?");
			ps1.setInt(1, id);
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				num=rs.getInt("id"); 
			}
			
			 PreparedStatement ps2=con.prepareStatement("update vehicle set dname=?,dcontact=? where id=?");
			 ps2.setString(1, name);
			 ps2.setString(2,contact);
			 ps2.setInt(3, num);
			 int rs1=ps2.executeUpdate();
			 if(rs1 ==0)
			{
				response.sendRedirect("update.html");
			}
			else
			{
				response.sendRedirect("success.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
