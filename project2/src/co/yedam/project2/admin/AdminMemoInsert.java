package co.yedam.project2.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.memo.MemoDAO;
import co.yedam.project2.memo.MemoVO;

public class AdminMemoInsert implements Command {

	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			MemoDAO dao = new MemoDAO();
			MemoVO vo = new MemoVO();
			vo.setMemo(request.getParameter("Memo"));
				
			dao.getInsert(vo);
		
			return "AdminMemo.do";
		
		//파라미터 받기
		
/*		MemoDAO dao = new MemoDAO();
		String memo = request.getParameter("memo");*/
		
		
		//첨무파일 처리
/*		MemoDAO $dao = new MemoDAO();
		MemoVO memovo = new MemoVO();
		memovo.setMemo(memo);*/
		
		
	/*	dao.getInsert(memovo);  //jsp입력값 돌려주는 객체
		return "memo/memoInsert.jsp";*/
		//서비스 로직 처리
		
		//등록처리
		
		//목록페이지 이동
		
		//리턴
	
}
}