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

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender;
		if (request.getParameter("gender") == "f") {
			gender = "여자";
		} else {
			gender = "남자";
		}

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

//		dao.memberInsert(membervo);
		return "member/memberInsert.jsp";
	}

}
