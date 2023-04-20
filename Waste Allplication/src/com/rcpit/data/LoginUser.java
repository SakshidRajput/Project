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
 * Servlet implementation class LoginUser
 */
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
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
		String name=request.getParameter("email");
		String pass=request.getParameter("pass");
		try
		{
			Connection con=CoonnectionDB.connect();
			PreparedStatement ps1=con.prepareStatement("select * from user where uemail=? and upass=?");
			ps1.setString(1, name);
			ps1.setString(2, pass);
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
				response.sendRedirect("welcome.html");
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
