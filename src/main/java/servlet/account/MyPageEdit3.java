//マイページ編集処理

package servlet.account;

import java.io.IOException;
import java.util.List;

import beans.AccountBean;
import dao.account.MyPageEditDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MyPageEdit3")
public class MyPageEdit3 extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  request.setCharacterEncoding("UTF-8");
	  String name = request.getParameter("name");
	  String mailAd = request.getParameter("mailAd");	    
	  String homeAd = request.getParameter("building");
	  String id = request.getParameter("button");    
		
	  //int型に変換する  https://www.javadrive.jp/start/string/index12.html#section1   
	  int accountID = Integer.parseInt(id);
	  
	  AccountBean account3 = new AccountBean(accountID, name, mailAd, homeAd);
	  
	  HttpSession session = request.getSession();
  	  session.setAttribute("account3", account3);
	  	
	    @SuppressWarnings("unchecked")
		List<AccountBean> accountList = (List<AccountBean>)session.getAttribute("accountList");
	    
	    System.out.println(accountList);	     
	    MyPageEditDAO dao = new MyPageEditDAO();	    
	    dao.update(account3);
	   
	      //すっきりサーブレットP232参考
		  session.removeAttribute("accountList");
		  
		  request.setAttribute("Msg", "編集しました。もう一度検索してください。");
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_accountEdit.jsp");
        dispatcher.forward(request, response);
	    
  }
  
  
}