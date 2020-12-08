package com.rbl.bnkapp.pk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class checkBalance
 */
public class checkBalance extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		Object acno = session.getAttribute("accno");
		String accno = (String) acno;
		try{
			Model m = new Model();
			m.setAccno(accno);
			HttpSession session1 = request.getSession();
			boolean check = m.checkBalance();
			if(check == true){
				session1.setAttribute("balance",m.getBalance());
				response.sendRedirect("balanceSuccess.jsp");
			}else{
				response.sendRedirect("balanceFail.html");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
