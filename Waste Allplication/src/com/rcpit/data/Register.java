package com.rcpit.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rcpit.data.CoonnectionDB;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		int id=0;
		int latitude=0;
		int longitude=0;
		String vehiclename=request.getParameter("vehiclename");
		String drivername=request.getParameter("drivername");
		String drivercontact=request.getParameter("drivercontact");
		try
		{
				Connection con=CoonnectionDB.connect();
				PreparedStatement ps1=con.prepareStatement("insert into vehicle values(?,?,?,?,?,?)");
				ps1.setInt(1,id);
				ps1.setString(2, vehiclename);
				ps1.setString(3, drivername);
				ps1.setString(4, drivercontact);
				ps1.setInt(5,latitude);
				ps1.setInt(6,longitude);
				int rs=ps1.executeUpdate();
				if(rs == 0)
				{
					response.sendRedirect("addVehicle.html");
				}
				else
				{
					response.sendRedirect("welcome.html");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
