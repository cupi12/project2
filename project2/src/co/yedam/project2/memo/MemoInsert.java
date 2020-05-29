package co.yedam.project2.wmemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class MemoInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		WmemoDAO dao = new WmemoDAO();
		
		//파라미터 받기
		
		//첨무파일 처리
		
		//서비스 로직 처리
		
		//등록처리
		
		//목록페이지 이동
		
		//리턴
		return "wmemo/wmemoInsert.jsp";
	}

}
