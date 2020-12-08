package com.rbl.bnkapp.pk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class transfer
 */
public class transfer extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accno1 = request.getParameter("accno1");
		String s = request.getParameter("amt");
		int amt = Integer.parseInt(s);
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("accno");
		try{
		Model m = new Model();
		m.setAccno(accno);
		m.setBalance(amt);
		m.setAccno1(accno1);
		boolean b = m.transfer();
		if(b==true){
			response.sendRedirect("transferSuccess.html");
		}else{
			response.sendRedirect("transferFail.html");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
