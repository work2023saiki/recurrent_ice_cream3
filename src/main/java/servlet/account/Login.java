//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考



package servlet.account;

import java.io.IOException;

import beans.AccountBean;
import dao.account.LoginDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.SHA256;

@WebServlet("/Login")
public class Login extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doGet(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {
	  RequestDispatcher dispatcher = request1.getRequestDispatcher("WEB-INF/jsp/account/login.jsp");
      dispatcher.forward(request1, response1);   //フォワードはjspフォルダ内に置く
      
      /*
      KeisanAgeDAO dao = new KeisanAgeDAO();
      List<AccountBean> test = dao.findAccount();
      System.out.println(test);
      System.out.println(test.get(0).getAge());
      */
      
  }  

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 入力した名前、パスワードを取得
    //request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    
    //パスワードをハッシュ化する
    SHA256 pass = new SHA256();
    String hashpass = pass.createHash(password);
    
    //入力情報をaccountインスタンスに保存。
    AccountBean account = new AccountBean(name, hashpass);
    
    //データベースに接続。アカウント情報を見つけて取得する。
    LoginDAO dao = new LoginDAO();
	AccountBean accountInfo = dao.findAccount(account);
	
	// アカウント情報が見つからなかったとき。
	// ログイン失敗
	if (accountInfo == null) {
		// P305のコード10-16を参照
		request.setAttribute("errorMsg", "アカウントが見つかりませんでした");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/account/login.jsp");
        dispatcher.forward(request, response); 
	}   
	
	//見つかったとき
    //ログイン成功
    else {
    	
    	
    	//セッションスコープに保存。マイページに表示するため
    	HttpSession session = request.getSession();
    	
    	
    	session.setAttribute("accountInfo", accountInfo);
    	
    	//System.out.println(accountInfo.getName());
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/ProductServlet");
    	dispatcher.forward(request, response);
    }
	
  }
}