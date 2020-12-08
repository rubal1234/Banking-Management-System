package com.rbl.bnkapp.pk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String custid = request.getParameter("custid");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String accno = request.getParameter("accno");
		String bal = request.getParameter("balance");
		int balance = Integer.parseInt(bal);
		try{
			Model m = new Model();
			m.setEmail(email);
			m.setCustid(custid);
			m.setName(name);
			m.setPwd(pwd);
			m.setAccno(accno);
			m.setBalance(balance);
			boolean b = m.register();
			if(b==true){
				response.sendRedirect("succed.html");
			}else{
				response.sendRedirect("failed.html");
			}
			
		}catch(Exception e){
			
		}
		
	}

}
