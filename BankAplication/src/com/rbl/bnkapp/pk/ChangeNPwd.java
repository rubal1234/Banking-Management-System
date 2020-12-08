package com.rbl.bnkapp.pk;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ChangeNPwd extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String npwd = request.getParameter("npwd");
		HttpSession session = request.getSession();
		String email =(String) session.getAttribute("email");
		try {
			Model m=new Model();
			m.setEmail(email);
			m.setPwd(npwd);
			boolean b=m.forgotPwd();
			if(b==true) {
				response.sendRedirect("success.html");
			}else {
				response.sendRedirect("failure.html");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
