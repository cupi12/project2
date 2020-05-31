package co.yedam.project2.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.yedam.project2.common.Command;

public class MemberList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		MemberDAO dao = new MemberDAO();
		 List<MemberVO> list = dao.getMemberList(); 
		request.setAttribute("Member", list); //jsp에쓰는거 이름 , 돌려주는 객체
		return "member/memberList.jsp";
	}

}
