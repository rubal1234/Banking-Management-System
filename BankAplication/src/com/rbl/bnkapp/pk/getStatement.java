package com.rbl.bnkapp.pk;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class getStatement extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("accno");
		try{
			Model m = new Model();
			m.setAccno(accno);
			ArrayList al = m.getStatement();
			if(al.isEmpty() == true){
				response.sendRedirect("failureStatement.html");
			}else{
				session.setAttribute("al",m.al);
				session.setAttribute("al1",m.al1);
				session.setAttribute("al2",m.al2);
				response.sendRedirect("successStatement.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

}
