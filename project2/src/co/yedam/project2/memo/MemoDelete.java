package co.yedam.project2.memo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.member.MemberDAO;

public class MemoDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		MemoDAO dao = new MemoDAO();
		
		dao.memoDelete(seq);
		
		return "MemoList.do";
	}
}
