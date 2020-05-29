package co.yedam.project2.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class BoardDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String id = request.getParameter("id");
		
		BoardDAO dao = new BoardDAO();
		BoardVO boardvo = new BoardVO();
		
		boardvo.setId(id);
		
		dao.getSelectDelete(boardvo);		
		return "board/boardrUpdate.jsp";
		
	}

}
