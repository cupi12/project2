package co.yedam.project2.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.worker.WorkerDAO;
import co.yedam.project2.worker.WorkerVO;

public class AdminWorkerWend {
	
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		WorkerDAO dao = new WorkerDAO();
		WorkerVO vo = new WorkerVO();
		
		dao.getInsert(request.getParameter("wend"));
		
		return "AdminWorkerEdit.jsp";
	}

}
