package co.yedam.project2.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class OrderInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderVO vo = new OrderVO();
		OrderDAO dao = new OrderDAO();
		
		vo.setId( (String) request.getSession().getAttribute("id"));
		vo.setAmount(Integer.parseInt(request.getParameter("amount")));
		vo.setPrice(Integer.parseInt(request.getParameter("sum")));
		 
		dao.orderInsert(vo);
				
		
		return null;
	}

}
