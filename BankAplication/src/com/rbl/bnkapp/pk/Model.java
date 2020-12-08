package com.rbl.bnkapp.pk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {
	
	ArrayList al = new ArrayList();
	ArrayList al1 = new ArrayList();
	ArrayList al2 = new ArrayList();
	private String accno;
	private String accno1;
	private String custid;
	private String name;
	private int balance;
	private String email;
	private String pwd;
	private String pwd1;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	
	
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	
	public String getAccno1() {
		return accno1;
	}
	public void setAccno1(String accno1) {
		this.accno1 = accno1;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd1() {
		return pwd1;
	}
	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
	public Model(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","SYSTEM","system");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public boolean login() {
		try{
			pstmt = con.prepareStatement("Select accno from BankApp where custid = ? and pwd =?");
			pstmt.setString(1,custid);
			pstmt.setString(2,pwd);
			res = pstmt.executeQuery();
			while(res.next() == true){
				accno = res.getString(1);
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	
	}
	public boolean checkBalance() throws SQLException {
		pstmt = con.prepareStatement("select balance from BankApp where accno = ?");
		pstmt.setString(1,accno);
		res = pstmt.executeQuery();
		while(res.next() == true){
			balance = res.getInt("balance");
			return true;
		}
		return false;
	}
	public boolean applyLoan() throws SQLException {

		String s = "select * from BankApp where accno = ?";
		pstmt = con.prepareStatement(s);
		pstmt.setString(1,accno);
		res = pstmt.executeQuery();
		while(res.next() == true){
			name = res.getString(3);
			email = res.getString(5);
			return true;
		}
		
		return false;
	}
	public boolean changePwd() throws SQLException {
		String s = "update BankApp set pwd = ? where accno = ? and pwd = ?";
		pstmt = con.prepareStatement(s);
		pstmt.setString(1,pwd1);
		pstmt.setString(2,accno);
		pstmt.setString(3,pwd);
		int x = pstmt.executeUpdate();
		if(x>0){
			return true;
		}
		
		return false;
	}
	public boolean transfer() throws SQLException {
		
		String s = "select * from BankApp where accno = ?";
		pstmt = con.prepareStatement(s);
		pstmt.setString(1,accno1);
		res = pstmt.executeQuery();
		while(res.next() == true){
			String s1 = "update BankApp set balance = balance - ? where accno = ?";
			pstmt = con.prepareStatement(s1);
			pstmt.setInt(1,balance);
			pstmt.setString(2,accno);
			int x = pstmt.executeUpdate();
			if(x > 0){
				String s2 = "update BankApp set balance = balance + ? where accno = ?";
				pstmt = con.prepareStatement(s2);
				pstmt.setInt(1,balance);
				pstmt.setString(2,accno1);
				int y = pstmt.executeUpdate();
				if(y>0){
					String s3 = "insert into getStatement values(?,?,?)";
					pstmt = con.prepareStatement(s3);
					pstmt.setString(1,accno);
					pstmt.setString(2,accno1);
					pstmt.setInt(3,balance);
					int z = pstmt.executeUpdate();
					if(z>0){
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
		return false;
	}
	public ArrayList getStatement() throws SQLException {
		String s = "select * from getStatement where sender_accno = ?";
		pstmt = con.prepareStatement(s);
		pstmt.setString(1,accno);
		res = pstmt.executeQuery();
		while(res.next() == true){
			al.add(res.getString(1));
			al1.add(res.getString(2));
			al2.add(res.getInt(3));
		}
		
		return al;
	}
	
		
		public boolean forgotPwd() throws Exception {
			String s="Update BankApp set pwd=? where email=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, pwd);
			pstmt.setString(2, email);
			int a=pstmt.executeUpdate();
			if(a>0) {
				return true;
			}
			
			return false;
		
	}
		public boolean register() throws SQLException {
			
			String s = "insert into BankApp values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1,accno);
			pstmt.setString(2,custid);
			pstmt.setString(3,name);
			pstmt.setInt(4,balance);
			pstmt.setString(5,email);
			pstmt.setString(6,pwd);
			int x =  pstmt.executeUpdate();
			if(x>0){
				return true;
			}
			
			return false;
		}
		
	
	

}
