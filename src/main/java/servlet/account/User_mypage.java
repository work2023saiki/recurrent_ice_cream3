//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考



package servlet.account;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/User_mypage")
public class User_mypage extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  //「会員情報編集」をクリックしたら実行
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/account/mypage/user_mypage.jsp");
      dispatcher.forward(request, response);   
  }
  //「戻る」ボタン押したとき実行
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/account/mypage/user_mypage.jsp");
      dispatcher.forward(request, response);   
  }
}  
