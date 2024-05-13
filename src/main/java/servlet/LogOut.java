//「スッキリわかるサーブレット＆JSP入門」P239～241、P291～294のコード10-5を参考

package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//商品一覧ページからログアウトするときの処理
@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
  private static final long serialVersionUID = 1L; 

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
	  //セッションスコープとして保存したインスタンスをすべて破棄
	  HttpSession session = request.getSession();
	  session.invalidate();
	  System.out.println("Thanks!");
	  response.sendRedirect("http://localhost:8080/recurrent_ice_cream/top.jsp");
  }
}