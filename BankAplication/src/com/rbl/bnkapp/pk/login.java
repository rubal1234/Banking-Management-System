package com.rbl.bnkapp.pk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String custid = request.getParameter("cust id");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		try{
			Model m = new Model();
			m.setCustid(custid);
			m.setPwd(pwd);
			boolean b = m.login();
			if(b==true){
				session.setAttribute("accno",m.getAccno());
				response.sendRedirect("home.html");
			}else{
				response.sendRedirect("error.html");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
