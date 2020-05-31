package co.yedam.project2.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.project2.member.MemberDAO;
import co.yedam.project2.member.MemberVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();

		String pwd = request.getParameter("pwd");
		String id = request.getParameter("id");

		
		vo = dao.getMember(id);
		
		if (vo.getId() == null) {
			response.getWriter().print("잘못된 아이디");
		} else if (!vo.getPwd().equals(pwd)) {
			response.getWriter().print("패스워드 오류");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginId", id);
			session.setAttribute("loginPwd", pwd);
		}

		return "main.do";
	}

}
