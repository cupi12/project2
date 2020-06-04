 package co.yedam.project2.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class MemberUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setName(name);
		vo.setPwd(pwd);
		vo.setAge(age);
		vo.setPhone(phone);
		vo.setId(id);
		
		
		dao.memberUpdate(vo); //jsp에쓰는거 이름 , 돌려주는 객체
		return "MemberUpdateView.do";
	}

}
