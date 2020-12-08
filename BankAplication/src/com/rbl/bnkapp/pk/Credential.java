package com.rbl.bnkapp.pk;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Credential extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		HttpSession session2 = request.getSession(true);
		session2.setAttribute("email", email);
		String fromEmail=PwdDetail.fromEmail; //sender's mail id.
		String pwd=PwdDetail.pwd;		//sender's mail pwd.
		String toEmail=email;  //reciever's mail id.
		
		String subject="Mail from BankApplication"; // mail subject line
		String msg="http://localhost:8080/BankAplication/NPwdChange.html"; //mail body
		
		//Creating Session Object
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
				return new PasswordAuthentication(fromEmail, pwd);
			}
		});

		
		//Composing the Mail
		
		MimeMessage mesg = new MimeMessage(session);
		try {
		mesg.setFrom(new InternetAddress(fromEmail));
		mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
		mesg.setSubject(subject);  
		mesg.setText(msg);  
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//Sending the Mail
		try {
			Transport.send(mesg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Mail Sent!!");

		
	}

}