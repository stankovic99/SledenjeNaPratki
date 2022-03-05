package com.stefan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginApi")
public class LoginApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("usernamelogin");
		String pass = request.getParameter("passwordlogin");

		UserManagement mng = new UserManagement();
		
		if(mng.checkUserLogin(uname, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			session.setAttribute("fullname", mng.getFullName(uname));
			response.sendRedirect("home.jsp");
		}else{
		response.sendRedirect("errorlogin.jsp");
		}
	}
}
