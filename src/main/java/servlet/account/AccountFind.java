//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考



package servlet.account;

import java.io.IOException;
import java.util.List;

import beans.AccountBean;
import dao.account.AccountFindDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AccountFind")
public class AccountFind extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doGet(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {
	  RequestDispatcher dispatcher = request1.getRequestDispatcher("WEB-INF/jsp/admin_accountEdit.jsp");
      dispatcher.forward(request1, response1);   
  }  

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 入力した名前、パスワードを取得
	    request.setCharacterEncoding("UTF-8");
	    String name = request.getParameter("氏名");
	    
	    //データベースに接続。アカウント情報を見つけて取得する。
	    AccountFindDAO dao = new AccountFindDAO();
		List<AccountBean> accountList = dao.findAccount(name);
		
		if (accountList.isEmpty()) {
			request.setAttribute("errorMsg", "アカウントが見つかりませんでした");
		}   
		
		else {
			HttpSession session = request.getSession();
			session.setAttribute("accountList", accountList);
		}
		
		// JSPにフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_accountEdit.jsp");
	    dispatcher.forward(request, response);
  }
}