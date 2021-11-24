package com.jsp.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.josephoconnell.html.HTMLInputFilter;

public class XSSResolver {
	
	public static void parseXSS(HttpServletRequest request)
								throws IOException, ServletException{
		Enumeration<String> crossParamNames = request.getParameterNames();
		
		while (crossParamNames.hasMoreElements()) {
			
			String paramName = crossParamNames.nextElement();
			String paramValue = request.getParameter(paramName);
			
			request.setAttribute("XSS" + paramName, 
					HTMLInputFilter.htmlSpecialChars(paramValue));
		}
	}

}
