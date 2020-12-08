package com.rbl.bnkapp.pk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loan
 */
public class loan extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String accno= (String) session.getAttribute("accno");

		try{
			Model m = new Model();
			m.setAccno(accno);
			boolean b = m.applyLoan();
			if(b == true){
				session.setAttribute("name",m.getName());
				session.setAttribute("email",m.getEmail());
				response.sendRedirect("loanprocess.jsp");
			}else{
				response.sendRedirect("loanfail.html");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
