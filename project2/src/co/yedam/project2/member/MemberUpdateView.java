package co.yedam.project2.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class MemberUpdateView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		vo = dao.getMember(request.getParameter("id"));
		
		request.setAttribute("member", vo);

		return "member/memberUpdate.jsp";
	}

}
