package co.yedam.project2.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.member.MemberDAO;
import co.yedam.project2.member.MemberVO;

public class OrderView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderDAO dao = new OrderDAO();
		
		
		List<OrderVO> list = dao.getorder(request.getParameter("id"));
		
		request.setAttribute("list", list );
		
		return "order/orderView.jsp";
	}

}
