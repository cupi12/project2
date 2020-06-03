package co.yedam.project2.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.worker.WorkerDAO;
import co.yedam.project2.worker.WorkerVO;

public class AdminWorkerInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		/*
		 * dao.getInsert(request.getParameter("wname"));
		 */
		WorkerDAO dao = new WorkerDAO();
		WorkerVO vo = new WorkerVO();


			dao.getInsert(request.getParameter("wname"));
	
		return "AdminWorkerList.do";
	}
}
