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


//管理者がアカウント情報を編集するときに実行される
@WebServlet("/MyPageEdit2")
public class MyPageEdit2 extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
      HttpSession session = request.getSession();
	  
      //アカウント検索で表示されたアカウントのリスト
	  @SuppressWarnings("unchecked")
	  List<AccountBean> accountList = (List<AccountBean>)session.getAttribute("accountList");
	  
	  request.setCharacterEncoding("UTF-8");
	  String loopIndex = request.getParameter("LoopIndex");
	  String accountID_BySave = request.getParameter("Save");
	    
	  
	//int型に変換する  https://www.javadrive.jp/start/string/index12.html#section1   
	  int index = Integer.parseInt(loopIndex);
	  
	  AccountBean account = accountList.get(index);
	  
	  //「編集」ボタンを押したとき
	  if(accountID_BySave == null) {
		  
	  	  request.setAttribute("account", account);
	  	  request.setAttribute("LoopIndex", loopIndex);
		  
		  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/account/mypage/MyPageEdit2.jsp");
	      dispatcher.forward(request, response); 
      }
	  
	  //「保存する」を押したとき
	  else {
		  String name = request.getParameter("name");
		  String mailAd = request.getParameter("mailAd");	    
		  String homeAd = request.getParameter("building");
		  
		  //アカウント編集画面に戻ったとき、変更分を表示させる。
		  account.setName(name);
		  account.setMailAd(mailAd);
		  account.setHomeAddress(homeAd);		  
		  accountList.set(index, account);
		  
		  //データベースのアカウント情報を更新する  
		  MyPageEditDAO dao = new MyPageEditDAO();	    
		  dao.update(account);	  
		  request.setAttribute("Msg", "編集しました!");
	    	
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_accountEdit.jsp");
	      dispatcher.forward(request, response);
			
	  }
	  
  }
}