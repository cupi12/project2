package co.yedam.project2.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class OrderView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderDAO dao = new OrderDAO();
		OrderVO vo = new OrderVO();		
		
		vo = dao.getorder(request.getParameter("id"));
		
		request.getSession().setAttribute("vo", vo );
		
		return "order/orderView.jsp";
	}

}
