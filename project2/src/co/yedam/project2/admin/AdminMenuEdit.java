package co.yedam.project2.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.menu.MenuDAO;
import co.yedam.project2.menu.MenuVO;

public class AdminMenuEdit implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mName = request.getParameter("mName");
		MenuDAO dao = new MenuDAO();
		MenuVO vo = new MenuVO();
		try {
			vo = dao.getMenu(mName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("getMenu", vo);

		return "admin/adminMenuEdit.jsp";
	}

}
