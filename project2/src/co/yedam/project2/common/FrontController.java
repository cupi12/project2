package co.yedam.project2.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.member.MemberList;
import co.yedam.project2.menu.Menu;




public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> comm = null;


	public void init(ServletConfig config) throws ServletException {
	comm = new HashMap<String,Command>();
	comm.put("/main.do", new Main());   //컨트롤러 밑에 추가해주세요^^
	comm.put("/Menu.do", new Menu());
	comm.put("/MemberList.do", new MemberList());
	comm.put("/Login.do", new Login());
	
	
	
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		Command subCommand = comm.get(path);
		
		String viewPage = subCommand.exec(request, response);
		RequestDispatcher dispacher = request.getRequestDispatcher(viewPage);
		dispacher.forward(request, response);
	}

}
