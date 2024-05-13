//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考



package servlet.account;

import java.io.IOException;

import dao.account.AccountDeleteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteAccount2")
public class DeleteAccount2 extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("button");
    
	//int型に変換する  https://www.javadrive.jp/start/string/index12.html#section1
    int accountID = Integer.parseInt(id);
    
    //データベースに接続。アカウント情報を見つけて取得する。
    AccountDeleteDAO dao = new AccountDeleteDAO();
	if(dao.delete(accountID)) {
		request.setAttribute("Msg", "削除しました。もう一度検索してください。");
	}
	else {
		// P305のコード10-16を参照
		request.setAttribute("errorMsg", "削除できませんでした");	
	}
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_accountEdit.jsp");
    dispatcher.forward(request, response); 

  }
  
}