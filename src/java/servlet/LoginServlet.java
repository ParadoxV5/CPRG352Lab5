package servlet;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends xyz.paradoxv5.servlet.MyServlet {
  private static final long serialVersionUID = 1;
  
  protected service.AccountService accountService = new service.AccountService();
  
  protected void showPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    forward("/WEB-INF/login.jsp", request, response);
  }
  protected static void goHome(HttpServletResponse response) throws IOException {
    response.sendRedirect("home");
  }
  
  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("message", null);
    
    HttpSession session = request.getSession(false);
    if(session != null) {
      // Already logged-in
      if(request.getParameter("logout") == null) {
        // Not logging out: Go Home
        goHome(response);
        return;
      }
      session.invalidate();
      request.setAttribute("message", "You have successfully logged out.");
    }
    
    showPage(request, response);
  }
  
  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username"),
           password = request.getParameter("password");
    model.User user = accountService.login(username, password);
    if(user == null) {
      // Log-in denied
      request.setAttribute("username", username);
      request.setAttribute("password", password);
      request.setAttribute("message", "Invalid login");
      showPage(request, response);
      return;
    }
    // Log-in successful
    HttpSession session = request.getSession();
    session.setAttribute("user", user);
    goHome(response);
  }
}