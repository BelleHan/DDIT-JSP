package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getParameter")
public class GetParameterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/WEB-INF/views/forward.jsp";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
