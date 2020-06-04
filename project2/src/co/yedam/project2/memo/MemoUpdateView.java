package co.yedam.project2.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class MemoUpdateView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemoVO vo = new MemoVO();
		MemoDAO dao = new MemoDAO();
		
		vo = dao.getMemo(Integer.parseInt(request.getParameter("seq")));
		request.setAttribute("memo", vo);
		return "/memo/memoUpdate.jsp";
	}

}
