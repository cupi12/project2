package co.yedam.project2.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.memo.MemoDAO;
import co.yedam.project2.memo.MemoVO;

public abstract class AdminMemoUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	MemoDAO dao = new MemoDAO();
	MemoVO vo = new MemoVO();
	vo.setMemo(request.getParameter("memo"));
	
	dao.getUpdate(vo);
	
	return "adminMemoEdit.jdp";
		
} 
}