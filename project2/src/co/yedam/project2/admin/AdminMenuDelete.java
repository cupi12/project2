package co.yedam.project2.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.menu.MenuDAO;
import co.yedam.project2.menu.MenuVO;

public class AdminMenuDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String mName = request.getParameter("mName");
		
		MenuDAO dao = new MenuDAO();
		
		
		try {
			dao.menuDelete(mName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return "AdminMenu.do";
	}

}
