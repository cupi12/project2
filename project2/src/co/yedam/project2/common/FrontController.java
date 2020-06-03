package co.yedam.project2.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.admin.AdminMenu;
import co.yedam.project2.admin.AdminMenuDelete;
import co.yedam.project2.admin.AdminMenuEdit;
import co.yedam.project2.admin.AdminMenuInsert;
import co.yedam.project2.admin.AdminMenuUpdate;
import co.yedam.project2.admin.StoreManage;
import co.yedam.project2.board.BoardContents;
import co.yedam.project2.board.BoardDelete;
import co.yedam.project2.board.BoardInsert;
import co.yedam.project2.board.BoardInsertMenu;
import co.yedam.project2.board.BoardList;
import co.yedam.project2.board.BoardView;
import co.yedam.project2.deadLine.Chart;
import co.yedam.project2.deadLine.DeadLine;
import co.yedam.project2.member.MemberDelete;
import co.yedam.project2.member.MemberInsert;
import co.yedam.project2.member.MemberInsertMenu;
import co.yedam.project2.member.MemberList;
import co.yedam.project2.member.MemberUpdate;
import co.yedam.project2.menu.Menu;




public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> comm = null;


	public void init(ServletConfig config) throws ServletException {
	comm = new HashMap<String,Command>();
	//Common 
	comm.put("/main.do", new Main());   //컨트롤러 밑에 추가해주세요^^
	comm.put("/Menu.do", new Menu());
	comm.put("/Login.do", new Login());
	comm.put("/Logout.do", new Logout());
	comm.put("/Pay.do", new Pay());
	
	//Member
	comm.put("/MemberList.do", new MemberList());
	comm.put("/MemberInsert.do", new MemberInsert());
	comm.put("/MemberDelete.do", new MemberDelete());
	comm.put("/MemberUpdate.do", new MemberUpdate());
	comm.put("/MemberInsertMenu.do", new MemberInsertMenu());
	
	//Admin
	comm.put("/AdminMenu.do", new AdminMenu());
	comm.put("/AdminMenuEdit.do", new AdminMenuEdit());
	comm.put("/AdminMenuDelete.do", new AdminMenuDelete());
	comm.put("/AdminMenuUpdate.do", new AdminMenuUpdate());
	comm.put("/AdminMenuInsert.do", new AdminMenuInsert());
	comm.put("/StoreManage.do", new StoreManage());
	
	//Chart
	comm.put("/Chart.do", new Chart());
	//Board
	comm.put("/BoardList.do",new BoardList());
	comm.put("/BoardInsert.do", new BoardInsert());
	comm.put("/BoardInsertMenu.do", new BoardInsertMenu());
	comm.put("/BoardDelete.do", new BoardDelete());
	comm.put("/BoardView.do", new BoardView());	
	comm.put("/BoardContents.do", new BoardContents());	
	
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
