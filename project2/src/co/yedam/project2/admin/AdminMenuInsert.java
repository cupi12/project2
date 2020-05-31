package co.yedam.project2.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.menu.MenuDAO;
import co.yedam.project2.menu.MenuVO;

public class AdminMenuInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		MenuDAO dao = new MenuDAO();
		MenuVO vo = new MenuVO();
		vo.setmName(request.getParameter("mName"));
		vo.setmPrice(Integer.parseInt(request.getParameter("mPrice")));
		
			try {			
				dao.menuInsert(vo);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		return "AdminMenu.do";
	}

}
