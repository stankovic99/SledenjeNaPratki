package com.stefan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/IznemiPratkaApi")
public class IznemiPratkaApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String datumOd = request.getParameter("datumOd");
		String datumDo = request.getParameter("datumDo");
		HttpSession sessi = request.getSession();
		sessi.setAttribute("id", id);
		sessi.setAttribute("datumOd", datumOd);
		sessi.setAttribute("datumDo", datumDo);
		response.sendRedirect("izmenipratka.jsp");
	}
}
