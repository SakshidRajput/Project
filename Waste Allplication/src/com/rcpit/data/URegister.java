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
 * Servlet implementation class URegister
 */
public class URegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public URegister() {
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
		String uname=request.getParameter("name");
		String umob=request.getParameter("contact");
		String uemail=request.getParameter("email");
		String upass=request.getParameter("pass");
		String uprof=request.getParameter("profession");
		String uadd=request.getParameter("address");
		String status="pending";
		try
		{	
				Connection con=CoonnectionDB.connect();
				PreparedStatement ps1=con.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
				ps1.setInt(1,id);
				ps1.setString(2, uname);
				ps1.setString(3, umob);
				ps1.setString(4, uemail);
				ps1.setString(5, upass);
				ps1.setString(6, uprof);
				ps1.setString(7, uadd);
				ps1.setString(8, status);
				
				int rs=ps1.executeUpdate();
				if(rs ==0)
				{
					response.sendRedirect("UserRegistration.html");
				}
				else
				{
					response.sendRedirect("userLogin.html");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
