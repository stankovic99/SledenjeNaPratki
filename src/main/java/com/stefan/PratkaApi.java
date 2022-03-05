package com.stefan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PratkaApi")
public class PratkaApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String datumOd = request.getParameter("datumod");
		String datumDo = request.getParameter("datumdo");
		String lokacija = request.getParameter("lokacija");
		
		PratkaMenagement mng = new PratkaMenagement();
		
		mng.newShipment(datumOd, datumDo, lokacija);
		response.sendRedirect("home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String lokacija = request.getParameter("lokacija");
		String status = request.getParameter("status");
		String datumDo = request.getParameter("datumDo");
		PratkaMenagement mng = new PratkaMenagement();
		
		mng.changeShipment(id,lokacija,status,datumDo);
		response.sendRedirect("home.jsp");
	}
}
