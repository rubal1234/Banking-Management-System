package com.rbl.bnkapp.pk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Validation1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String npwd = request.getParameter("npwd");
		String cpwd = request.getParameter("cpwd");
		if(npwd.equals(cpwd)){
			request.getServletContext().getRequestDispatcher("/ChangeNPwd").forward(request,response);
		}else{
			response.sendRedirect("failure.html");
		}
		
	}

}
