package com.rbl.bnkapp.pk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class changePwd
 */
public class changePwd extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cupwd = request.getParameter("cupwd");
		String npwd = request.getParameter("npwd");
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("accno");
		try{
			Model m = new Model();
			m.setAccno(accno);
			m.setPwd(cupwd);
			m.setPwd1(npwd);
			boolean b = m.changePwd();
			if(b== true){
				response.sendRedirect("changePwdSuccess.html");
			}else{
				response.sendRedirect("changePwdFail.html");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
