package co.yedam.project2.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class BoardView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq")) ;
		
		
		BoardDAO dao = new BoardDAO();
		BoardVO boardvo = new BoardVO();
		
		
		dao.getBoard(seq);
		return "board/boardView.jsp";
	}

}
