package co.yedam.project2.memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class MemoUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memo = request.getParameter("memo");
		
		MemoDAO dao = new MemoDAO();
		MemoVO vo = new MemoVO();
		
		vo.setMemo(memo);
		
		dao.getUpdate(vo);
		
		return "memo/memoUpdate.jsp";
	}

}
