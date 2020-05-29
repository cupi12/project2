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
		String regdt = request.getParameter("regdt");
		String star = request.getParameter("star");
		int recommand = Integer.parseInt(request.getParameter("recommand"));
		
		BoardDAO dao = new BoardDAO();
		BoardVO boardvo = new BoardVO();
		
		boardvo.setId(id);
		boardvo.setTitle(title);
		boardvo.setContents(contents);
		boardvo.setRegdt(regdt);
		boardvo.setStar(star);
		boardvo.setRecommand(recommand);
		
		dao.getSelectInsert(boardvo);
		return "board/boardInsert.jsp";
	}

}
