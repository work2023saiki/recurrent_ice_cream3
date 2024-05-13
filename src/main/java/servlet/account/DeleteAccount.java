//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考



package servlet.account;

import java.io.IOException;

import beans.AccountBean;
import dao.account.AccountDeleteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doGet(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {
	  RequestDispatcher dispatcher = request1.getRequestDispatcher("WEB-INF/jsp/account/mypage/deleteAccount.jsp");
      dispatcher.forward(request1, response1);   //フォワードはjspフォルダ内に置く
  }  

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
  //セッションスコープからアカウント情報を取得する。
    HttpSession session = request.getSession();
    AccountBean accountInfo = (AccountBean)session.getAttribute("accountInfo");
    
    int accountID = accountInfo.getAccountID();
    
    //データベースに接続。アカウント情報を見つけて取得する。
    AccountDeleteDAO dao = new AccountDeleteDAO();
	if(dao.delete(accountID)) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/account/mypage/DeleteCompleted.jsp");
	    dispatcher.forward(request, response); 
	}
	else {
		// P305のコード10-16を参照
		request.setAttribute("errorMsg", "退会できませんでした");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/account/mypage/deleteAccount.jsp");
        dispatcher.forward(request, response); 
	}
  
  }
  
}