package co.yedam.project2.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.memo.MemoDAO;
import co.yedam.project2.memo.MemoVO;

public class AdminMemoEdit implements Command {

	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Memo = request.getParameter("Memo");
		MemoDAO dao = new MemoDAO();
		MemoVO vo = new MemoVO();
		
		request.setAttribute("getMemo", vo);

		return "admin/adminMemoEdit.jsp";
	}

	
}
