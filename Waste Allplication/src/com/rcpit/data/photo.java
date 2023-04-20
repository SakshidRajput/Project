package com.rcpit.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//import org.omg.CORBA_2_3.portable.InputStream;

/**
 * Servlet implementation class photo
 */
//@WebServlet("/FileUploadDBServlet")
@MultipartConfig(maxFileSize=16177215)
public class photo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public photo() {
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
		//int id=0;
		Connection con=CoonnectionDB.connect();
		java.io.InputStream inputStream=null;
		int id=0;
		Part filePart=request.getPart("photo");
		String add=request.getParameter("address");
		String city=request.getParameter("city");
		String title=request.getParameter("title");
		String desc=request.getParameter("desc");
		String status="pending";
		if(filePart!=null)
		{
			inputStream=filePart.getInputStream();
		}
		try
		{	
				PreparedStatement ps1=con.prepareStatement("insert into request values(?,?,?,?,?,?,?)");
				if(inputStream!=null)
				{
					ps1.setInt(1, id);
					ps1.setString(2, add);
					ps1.setString(3,city);
					ps1.setString(4, title);
					ps1.setString(5, desc);
					ps1.setBlob(6, inputStream);
					ps1.setString(7, status);
				}
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
