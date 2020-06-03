package co.yedam.project2.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.project2.member.MemberDAO;
import co.yedam.project2.member.MemberVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo = dao.getMember(id);
		if (vo.getId() == null && vo.getId() != id) {
			request.setAttribute("errorMsg", "id오류");
			path = "common/login.jsp";
		} else if (!vo.getPwd().equals(pwd)) {
			request.setAttribute("errorMsg", "pwd오류");
			path = "common/login.jsp";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginId", id);
			session.setAttribute("loginPwd", pwd);
			path = "main.do";
		}

		return path;
	}
   }


}