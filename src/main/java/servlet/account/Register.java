package servlet.account;

import java.io.IOException;
import java.util.Date;

import beans.AccountBean;
import dao.account.RegisterDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doGet(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {
	  RequestDispatcher dispatcher = request1.getRequestDispatcher("WEB-INF/jsp/account/register.jsp");
      dispatcher.forward(request1, response1); 
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメータを取得
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String mailAd = request.getParameter("mailAd");
    String gender = request.getParameter("gender"); 
    
    String birth_year = request.getParameter("birth_year");
    String birth_month = request.getParameter("birth_month");
    String birth_day = request.getParameter("birth_day");
    
    String homeAddress1 = request.getParameter("building1");
    String homeAddress2 = request.getParameter("building2");
    
    //https://www.javadrive.jp/start/string/index17.html#:~:text=%E8%A4%87%E6%95%B0%E3%81%AE%E6%96%87%E5%AD%97%E5%88%97%E3%82%92%E5%8C%BA%E5%88%87%E3%82%8A%E6%96%87%E5%AD%97%E3%82%92%E4%BD%BF%E3%81%A3%E3%81%A6%E9%80%A3%E7%B5%90%E3%81%97%E6%96%B0%E3%81%97%E3%81%84%E6%96%87%E5%AD%97%E5%88%97%E3%82%92%E4%BD%9C%E6%88%90%E3%81%99%E3%82%8B%E3%81%AB%E3%81%AF%20String,%E3%82%AF%E3%83%A9%E3%82%B9%E3%81%AE%20join%20%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89%E3%82%92%E4%BD%BF%E3%81%84%E3%81%BE%E3%81%99%E3%80%82
    //複数の文字列の結合
    String birthday = String.join("-", birth_year, birth_month, birth_day);
    
    //https://www.sejuku.net/blog/19633
    //文字列の結合
    String homeAddress =  homeAddress1.concat(homeAddress2); 
    
    //System.out.println(homeAddress);
    
    //参考サイト：https://qiita.com/ayaka105/items/1a68ed7ad84743dde7d5
    //String型をDate型に変換する。
    Date birthday_ = java.sql.Date.valueOf(birthday);
    
    
    //Accountインスタンスaccountに入力内容を保存
    AccountBean account = new AccountBean(name, password, mailAd, gender, birthday_, homeAddress);
     
    RegisterDAO dao = new RegisterDAO();

    boolean newAccount = dao.create(account);   //dao.create(account)がTrueで、アカウント登録される。
	
    //登録OK
    if(newAccount) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/account/registration_complete.jsp");
        dispatcher.forward(request, response);
	}
	
    //登録できないとき
	else {
		// P305のコード10-16を参照
		request.setAttribute("errorMsg", "アカウント登録できませんでした");
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/account/register.jsp");
        dispatcher.forward(request, response);
    }
	
  }
}