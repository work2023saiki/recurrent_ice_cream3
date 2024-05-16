//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考



package servlet;

import java.io.IOException;
import java.util.List;

import beans.AccountBean;
import beans.PurchaseBean;
import dao.CartShowDAO;
import dao.DeleteCartItemDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//カート確認画面で、買わない商品を削除する
@WebServlet("/DeleteCartItem")
public class DeleteCartItem extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    //セッションスコープからアカウント情報を取得する。
      request.setCharacterEncoding("UTF-8");
  	  String kariID = request.getParameter("button");
  	  int kariID2 = Integer.parseInt(kariID);
    
    
    //データベースに接続。アカウント情報を見つけて取得する。
    DeleteCartItemDAO dao = new DeleteCartItemDAO();
	dao.delete(kariID2); 
	
	
	HttpSession session = request.getSession();
	
	AccountBean accountInfo = (AccountBean)session.getAttribute("accountInfo");
    int accountID = accountInfo.getAccountID();
    
	CartShowDAO dao2 = new CartShowDAO();
    List<PurchaseBean> cart = dao2.cartInfo(accountID);
    
    	session.setAttribute("cart", cart);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/order_confirmation.jsp");
	    dispatcher.forward(request, response); 
	
	
  }
  
}