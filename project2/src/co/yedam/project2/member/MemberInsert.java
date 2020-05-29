package co.yedam.project2.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class MemberInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id =request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String regdt = request.getParameter("regdt");
		
		MemberDAO dao = new MemberDAO();
		MemberVO membervo = new MemberVO();
		membervo.setId(id);
		membervo.setPwd(pwd);
		membervo.setName(name);
		membervo.setAge(age);
		membervo.setGender(gender);
		membervo.setPhone(phone);
		membervo.setRegdt(regdt);
		
	
		dao.getSelectInsert(membervo); //jsp에쓰는거 이름 , 돌려주는 객체
		return "member/memberInsert.jsp";
	}

}
