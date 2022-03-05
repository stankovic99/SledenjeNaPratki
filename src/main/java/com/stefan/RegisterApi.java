package com.stefan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterApi")
public class RegisterApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		String surname = request.getParameter("surname");
		String confpass = request.getParameter("confirmpassword");
		
		UserManagement mng = new UserManagement();
		
		if(pass.equals(confpass) == true) {
			if(!mng.checkUsername(uname)) {
				mng.createUser(uname, pass, name, surname);
				response.sendRedirect("home.jsp");
			}else {
				response.sendRedirect("errorregister.jsp");
			}
		}else {
			response.sendRedirect("errorregister.jsp");
		}
	}

}
