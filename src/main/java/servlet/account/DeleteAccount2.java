//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考

package servlet.account;

import java.io.IOException;
import java.util.List;

import beans.AccountBean;
import dao.account.AccountDeleteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DeleteAccount2")
public class DeleteAccount2 extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	request.setCharacterEncoding("UTF-8");
    String loopIndex = request.getParameter("LoopIndex");
    
	//int型に変換する  https://www.javadrive.jp/start/string/index12.html#section1   
	int index = Integer.parseInt(loopIndex);
	
	HttpSession session = request.getSession();	
	@SuppressWarnings("unchecked")
	List<AccountBean> accountList = (List<AccountBean>)session.getAttribute("accountList");
    
	//int型に変換する  https://www.javadrive.jp/start/string/index12.html#section1
    int accountID = accountList.get(index).getAccountID();
    
    //データベースに接続。アカウント情報を見つけて取得する。
    AccountDeleteDAO dao = new AccountDeleteDAO();
	
    if(dao.delete(accountID)) {	request.setAttribute("Msg", "削除しました。もう一度検索してください。"); }
	
    else { request.setAttribute("errorMsg", "削除できませんでした"); }
	
    //https://magazine.techacademy.jp/magazine/18607#sec3
    accountList.remove(index);
    
	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_accountEdit.jsp");
    dispatcher.forward(request, response); 

  }
  
}