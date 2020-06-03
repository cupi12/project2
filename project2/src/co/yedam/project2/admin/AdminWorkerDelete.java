package co.yedam.project2.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;
import co.yedam.project2.worker.WorkerDAO;
import co.yedam.project2.worker.WorkerVO;

public class AdminWorkerDelete implements Command {

	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String seq = request.getParameter("seq");

		WorkerDAO dao = new WorkerDAO();

		dao.getDelete(seq);

		return "AdminWorker.do";
	}
}
