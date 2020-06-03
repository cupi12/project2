package co.yedam.project2.deadLine;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


@WebServlet("/DeadLine")
public class DeadLine extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
	  
	  
	  List<Map<String, Object>> list = DeadLineDAO.getInstance().DeadLine();
	  
	  String result = JSONArray.fromObject(list).toString();
	  
	  response.getWriter().print(result);
	  
	  

	  }
	
	
}

