package co.yedam.project2.admin;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import co.yedam.project2.common.Command;
import co.yedam.project2.common.FileRenamePolicy;
import co.yedam.project2.menu.MenuDAO;
import co.yedam.project2.menu.MenuVO;

@WebServlet("/AdminMenuInsert.do")
@MultipartConfig(location = "d:/upload") // request.getParts()
public class AdminMenuInsert extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 응답결과 인코딩
		response.setContentType("text/html; charset=UTF-8");
		// 요청 정보 인코딩 post방식일때는 request해줘야함
		request.setCharacterEncoding("utf-8");
		int price = Integer.parseInt(request.getParameter("mPrice"));
		String mName = request.getParameter("mName");
		String fileNames = request.getParameter("fileName");
		
		

		MenuDAO dao = new MenuDAO();
		MenuVO vo = new MenuVO();
		vo.setmName(mName);
		vo.setmPrice(price);
		vo.setFileName(fileNames);

		// 첨부파일 처리
		Part part = request.getPart("fileName");
		String fileName = getFileName(part);
		String path = "C:/Users/cupi1/git/project2/project2/WebContent/menu/image";
		if (fileName != null && !fileName.isEmpty()) {
			// 주복 파일명 처리
			File f = FileRenamePolicy.rename(new File(path, fileName));
			part.write(f.getAbsolutePath()); // 업로드 폴더에 파일 저장
			vo.setFileName(f.getName()); // 파일명을 vo에 담기
		}

		try {
			dao.menuInsert(vo);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("vo", vo);

		response.sendRedirect("AdminMenu.do");
	}

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		return "";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/admin/adminMenu.jsp").forward(request, response);
	}

	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("fileName")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
