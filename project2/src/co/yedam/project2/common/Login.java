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

		// 1. 파라미터
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				
				// 2. 서비스 로직
				MemberDAO dao = new MemberDAO();
				MemberVO vo = dao.getSelect(id);
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
					// ID 조회
					if (vo.getId() == null) { // ID 오류
						request.getRequestDispatcher("/common/menu.jsp").include(request, response);
						out.print("ID 오류");
					} else if (!vo.getPwd().equals(pwd)) { // Password 오류
						request.getRequestDispatcher("/common/menu.jsp").include(request, response);
						out.print("Password 오류");
					} else { // Login OK
						//세션에 로그인 여부를 저장
						HttpSession session = request.getSession();
						session.setAttribute("login_ID", id);
						session.setAttribute("loginMember", vo);
						request.getRequestDispatcher("/common/menu.jsp").include(request, response);
						out.print("로그인 성공");
					}
		
		
		



		
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
