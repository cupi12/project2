package co.yedam.project2.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.admin.AdminMemo;
import co.yedam.project2.admin.AdminMemoDelete;
import co.yedam.project2.admin.AdminMemoEdit;
import co.yedam.project2.admin.AdminMemoInsert;
import co.yedam.project2.admin.AdminMemoList;
import co.yedam.project2.admin.AdminMenu;
import co.yedam.project2.admin.AdminMenuDelete;
import co.yedam.project2.admin.AdminMenuEdit;
import co.yedam.project2.admin.AdminMenuInsert;
import co.yedam.project2.admin.AdminMenuUpdate;
import co.yedam.project2.admin.AdminWorker;
import co.yedam.project2.admin.AdminWorkerDelete;
import co.yedam.project2.admin.AdminWorkerEdit;
import co.yedam.project2.admin.AdminWorkerInsert;
import co.yedam.project2.admin.AdminWorkerList;
import co.yedam.project2.admin.StoreManage;
import co.yedam.project2.board.BoardContents;
import co.yedam.project2.board.BoardDelete;
import co.yedam.project2.board.BoardInsert;
import co.yedam.project2.board.BoardInsertMenu;
import co.yedam.project2.board.BoardInsertPath;
import co.yedam.project2.board.BoardList;
import co.yedam.project2.board.BoardView;
import co.yedam.project2.board.Recommand;
import co.yedam.project2.deadLine.Chart;
import co.yedam.project2.member.MemberDelete;
import co.yedam.project2.member.MemberInsert;
import co.yedam.project2.member.MemberInsertMenu;
import co.yedam.project2.member.MemberList;
import co.yedam.project2.member.MemberUpdate;
import co.yedam.project2.member.MemberUpdateView;
import co.yedam.project2.menu.Menu;
import co.yedam.project2.order.OrderInsert;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> comm = null;

	public void init(ServletConfig config) throws ServletException {
		comm = new HashMap<String, Command>();
		// Common
		comm.put("/main.do", new Main()); // 컨트롤러 밑에 추가해주세요^^
		comm.put("/Menu.do", new Menu());
		comm.put("/Login.do", new Login());
		comm.put("/LoginForm.do", new LoginForm());
		comm.put("/Logout.do", new Logout());
		comm.put("/Pay.do", new Pay());

		// Member
		comm.put("/MemberList.do", new MemberList());
		comm.put("/MemberInsert.do", new MemberInsert());
		comm.put("/MemberDelete.do", new MemberDelete());
		comm.put("/MemberUpdate.do", new MemberUpdate());
		comm.put("/MemberInsertMenu.do", new MemberInsertMenu());
		comm.put("/MemberUpdateView.do", new MemberUpdateView());

		// Admin
		comm.put("/AdminMenu.do", new AdminMenu());
		comm.put("/AdminMenuEdit.do", new AdminMenuEdit());
		comm.put("/AdminMenuDelete.do", new AdminMenuDelete());
		comm.put("/AdminMenuUpdate.do", new AdminMenuUpdate());
		comm.put("/AdminMenuInsert.do", new AdminMenuInsert());
		comm.put("/StoreManage.do", new StoreManage());

		// Admin Worker
		comm.put("/AdminWorker.do", new AdminWorker());
		comm.put("/AdminWorkerDelete.do", new AdminWorkerDelete());
		comm.put("/AdminWorkerEdit.do", new AdminWorkerEdit());
		comm.put("/AdminWorkerInsert.do", new AdminWorkerInsert());
		comm.put("/AdminWorkerList.do", new AdminWorkerList());

		// Admin Memo
		comm.put("/AdminMemo.do", new AdminMemo());
		comm.put("/AdminMemoDelete.do", new AdminMemoDelete());
		comm.put("/AdminMemoEdit.do", new AdminMemoEdit());
		comm.put("/AdminMemoInsert.do", new AdminMemoInsert());
		comm.put("/AdminMemoList.do", new AdminMemoList());

		// Chart
		comm.put("/Chart.do", new Chart());
		// Board
		comm.put("/BoardList.do", new BoardList());
		comm.put("/BoardInsertPath.do", new BoardInsertPath());
		comm.put("/BoardInsert.do", new BoardInsert());
		comm.put("/BoardInsertMenu.do", new BoardInsertMenu());
		comm.put("/BoardDelete.do", new BoardDelete());
		comm.put("/BoardView.do", new BoardView());
		comm.put("/BoardContents.do", new BoardContents());
		comm.put("/Recommand.do", new Recommand());
		
		//Order
		comm.put("/OrderInsert.do", new OrderInsert());

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
