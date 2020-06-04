package co.yedam.project2.memo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class MemoInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemoDAO dao = new MemoDAO();

		dao.getInsert(request.getParameter("memo"));

		return "MemoList.do";

	}

}
