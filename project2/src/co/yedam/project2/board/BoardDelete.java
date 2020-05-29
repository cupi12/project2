package co.yedam.project2.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.member.MemberDAO;
import co.yedam.project2.member.MemberVO;

public class BoardDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		MemberVO boardvo = new MemberVO();
		
		boardvo.setId(id);
		
		dao.getDelete(boardvo);
		return "board/boardrUpdate.jsp";
		
	}

}
