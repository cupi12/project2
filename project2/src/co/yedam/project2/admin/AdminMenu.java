package co.yedam.project2.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.menu.MenuDAO;
import co.yedam.project2.menu.MenuVO;

public class AdminMenu implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuDAO dao = new MenuDAO();
		List<MenuVO> list = dao.getList();
		request.setAttribute("vo", list);
	
		return "admin/adminMenu.jsp";
	}

}
