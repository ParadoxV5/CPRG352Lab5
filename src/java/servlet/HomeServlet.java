package servlet;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends xyz.paradoxv5.servlet.MyServlet {
  private static final long serialVersionUID = 1;
  
  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    javax.servlet.http.HttpSession session = request.getSession(false);
    if(session == null) {
      // Not logged-in: Kick ’em outta here
      response.sendRedirect("login");
      return;
    }
    forward("/WEB-INF/home.jsp", request, response);
  }
  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}