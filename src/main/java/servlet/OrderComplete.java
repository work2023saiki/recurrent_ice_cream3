//マイページ編集処理

package servlet;

import java.io.IOException;

import beans.AccountBean;
import dao.DeleteCartItemDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//管理者が商品情報を編集
@WebServlet("/OrderComplete")
public class OrderComplete extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
      HttpSession session = request.getSession();
	  
	  AccountBean accountInfo = (AccountBean) session.getAttribute("accountInfo");
	  
	  DeleteCartItemDAO dao = new DeleteCartItemDAO();
  	  dao.delete(accountInfo.getAccountID());
  	  
  	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/orderCompleted.jsp");
      dispatcher.forward(request, response); 
	    
  }
}