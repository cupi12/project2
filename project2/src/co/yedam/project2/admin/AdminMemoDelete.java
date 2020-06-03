package co.yedam.project2.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.memo.MemoDAO;
import co.yedam.project2.memo.MemoVO;

public class AdminMemoDelete implements Command {
	
	
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");

		MemoDAO dao = new MemoDAO();
		MemoVO memovo = new MemoVO();
			
		dao.memoDelete(memovo);
			
		return "MemoList.jsp";

}
}