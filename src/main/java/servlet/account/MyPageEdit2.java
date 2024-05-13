//マイページ編集処理

package servlet.account;

import java.io.IOException;
import java.util.List;

import beans.AccountBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MyPageEdit2")
public class MyPageEdit2 extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
      HttpSession session = request.getSession();
	  
	  @SuppressWarnings("unchecked")
	  List<AccountBean> accountList = (List<AccountBean>)session.getAttribute("accountList");
	  
	  request.setCharacterEncoding("UTF-8");
	  String loopindex = request.getParameter("loopIndex");
	  
	//int型に変換する  https://www.javadrive.jp/start/string/index12.html#section1   
	  int index = Integer.parseInt(loopindex);
	  
	  int accountID = accountList.get(index).getAccountID();
	  String name = accountList.get(index).getName();
	  String mailAd = accountList.get(index).getMailAd();	    
	  String homeAd = accountList.get(index).getHomeAddress();
	  
	  AccountBean account2 = new AccountBean(accountID, name, mailAd, homeAd);
	  
  	  session.setAttribute("account2", account2);
	  
	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/account/mypage/MyPageEdit2.jsp");
      dispatcher.forward(request, response); 
	    
  }
}