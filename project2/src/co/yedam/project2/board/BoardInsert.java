package co.yedam.project2.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class BoardInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		int star = Integer.parseInt(request.getParameter("star").trim());
		
		BoardVO boardvo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		
		boardvo.setId(id);
		boardvo.setTitle(title);
		boardvo.setContents(contents);
		boardvo.setStar(star);
		
		dao.boardInsert(boardvo);
		
		
		return "BoardList.do";
	}

}
