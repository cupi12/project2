package co.yedam.project2.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.memo.MemoDAO;
import co.yedam.project2.memo.MemoVO;

public class AdminMemo implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemoDAO dao = new MemoDAO();
		List<MemoVO> list = dao.getMemoList();
		request.setAttribute("vo", list);
	
		return "admin/adminMemo.jsp";
	}
	
}
