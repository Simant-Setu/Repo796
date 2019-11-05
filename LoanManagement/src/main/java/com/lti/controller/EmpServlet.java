package com.lti.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
     public EmpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int eid=Integer.parseInt(request.getParameter("txtEmpId"));
			String ename=request.getParameter("txtEmpName");
			
			PrintWriter out=response.getWriter();
			out.println(eid+"  "+ename);
			
InputStream is=
getClass().getClassLoader().getResourceAsStream("config.properties");
			Properties prop=new Properties ();
				prop.load (is);
			
			String driver=(String)prop.get("db.driver");				
			String url=(String)prop.get("db.url");
			String user=(String)prop.get("db.user");
			String pass=(String)prop.get("db.pass");
			
			try {
				Class.forName(driver);
				Connection con=DriverManager.getConnection(url,user,pass);
				
					out.println("Connection established");
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				out.println(e.toString());
				e.printStackTrace();
			}
		
	}

}
