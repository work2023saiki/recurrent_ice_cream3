//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考



package servlet;

import java.io.IOException;
import java.util.List;

import beans.ItemBean;
import dao.ItemFindDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//管理者が商品検索するとき実行させる
@WebServlet("/ItemFind")
public class ItemFind extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doGet(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {
	  RequestDispatcher dispatcher = request1.getRequestDispatcher("WEB-INF/jsp/admin_accountEdit.jsp");
      dispatcher.forward(request1, response1);   
  }  

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 入力した名前、パスワードを取得
	    request.setCharacterEncoding("UTF-8");
	    String name = request.getParameter("name");
	    
	    
	    //データベースに接続。アカウント情報を見つけて取得する。
	    ItemFindDAO dao = new ItemFindDAO();
		List<ItemBean> ItemList = dao.findItem(name);
		
		
		if (ItemList.isEmpty()) {
			// P305のコード10-16を参照
			request.setAttribute("errorMsg", "商品が見つかりませんでした");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_ItemEdit.jsp");
	        dispatcher.forward(request, response); 
		}   
		
		else {
			
			HttpSession session = request.getSession();
			session.setAttribute("ItemList", ItemList);
			
			// JSPにフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_ItemEdit.jsp");
		    dispatcher.forward(request, response);
		}
		
  }
}