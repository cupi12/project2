package co.yedam.project2.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.menu.MenuDAO;
import co.yedam.project2.menu.MenuVO;

public class AdminMenuUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//수정 처리
		String mName = request.getParameter("mName"); 
//		String mPri = request.getParameter("mPrice");
		int mPrice = Integer.parseInt(request.getParameter("mPrice").trim());
		
//		int mPrice=Integer.parseInt(mPri);
		
		//2.서비스 로직
		MenuDAO dao = new MenuDAO();
		MenuVO vo = new MenuVO();
		vo.setmName(mName);
		vo.setmPrice(mPrice);
		dao.menuUpdate(vo);
	
		
		
		
		
		return "AdminMenu.do";
	}

}
