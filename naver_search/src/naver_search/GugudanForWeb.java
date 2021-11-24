package naver_search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GugudanForWeb extends Gugudan {

	public void inputDataByWeb(HttpServletRequest request, 
									HttpServletResponse response) 
									throws ServletException, IOException {
		
		setDan(Integer.parseInt(request.getParameter("dan")));		
		setGop(Integer.parseInt(request.getParameter("gop")));
		
	}

	
	public void outputDataByWeb(HttpServletRequest request, 
									HttpServletResponse response) 
									throws ServletException, IOException {
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(getResult()); // 그냥 result변수를 꺼내올 수 없기 대문에
	}

	
}
