//マイページ編集処理

package servlet.account;

import java.io.IOException;

import beans.AccountBean;
import dao.account.MyPageEditDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MyPageEdit")
public class MyPageEdit extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doGet(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException { 
	  
	  RequestDispatcher dispatcher = request1.getRequestDispatcher("WEB-INF/jsp/account/mypage/MyPageEdit.jsp");
      dispatcher.forward(request1, response1);   
  }  

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// リクエストパラメータを取得
	    request.setCharacterEncoding("UTF-8");
	    String name = request.getParameter("name");
	    String mailAd = request.getParameter("mailAd");	    
	    String homeAd = request.getParameter("building");
	    
	    //セッションスコープからアカウントIDを取得する。
	    HttpSession session = request.getSession();
	    AccountBean accountInfo = (AccountBean)session.getAttribute("accountInfo");
	    
	    int accountID = accountInfo.getAccountID();
	    
	  //accountに入力内容を保存
	    AccountBean account = new AccountBean(accountID, name, mailAd, homeAd);
	     
	    MyPageEditDAO dao = new MyPageEditDAO();	    
	    dao.update(account);

    	//user_mypage.jspに更新内容を表示
    	accountInfo.setName(name);
    	accountInfo.setMailAd(mailAd);
    	accountInfo.setHomeAddress(homeAd);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/account/mypage/user_mypage.jsp");
        dispatcher.forward(request, response);
	    
  }
}