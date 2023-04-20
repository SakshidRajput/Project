package com.rcpit.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Rcnd
 */
public class Rcnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rcnd() {
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
		String add=request.getParameter("address");
		String city=request.getParameter("city");
		String title=request.getParameter("title");
		String desc=request.getParameter("desc");
		String status="pending";
		try
		{	
				Connection con=CoonnectionDB.connect();
				PreparedStatement ps1=con.prepareStatement("insert into request values(?,?,?,?,?,?)");
				ps1.setInt(1, id);
				ps1.setString(2, add);
				ps1.setString(3,city);
				ps1.setString(4, title);
				ps1.setString(5, desc);
				ps1.setString(6, status);
				int rs=ps1.executeUpdate();
				if(rs ==0)
				{
					response.sendRedirect("RCNDRequest.html");
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
