package co.yedam.project2.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pay implements Command {

   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String money = request.getParameter("price");
      
      
      request.setAttribute("money", money);
      
      return "common/pay.jsp";
   }

}