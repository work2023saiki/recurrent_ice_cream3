package servlet;

import java.io.IOException;

import beans.ItemBean;
import dao.ItemRegisterDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ItemRegist")
public class ItemRegist extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doGet(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {
	  RequestDispatcher dispatcher = request1.getRequestDispatcher("WEB-INF/jsp/admin_ItemEdit.jsp");
      dispatcher.forward(request1, response1); 
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメータを取得
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("itemName");
    String price = request.getParameter("price");
    String explain = request.getParameter("itemExplain");
    
    int price1 = Integer.valueOf(price);
    System.out.println(name);
    System.out.println(price1);
    System.out.println(explain);
    //Accountインスタンスaccountに入力内容を保存
    ItemBean item = new ItemBean(name, price1, explain);
     
    ItemRegisterDAO dao = new ItemRegisterDAO();

    boolean newItem = dao.itemRegist(item);   //dao.create(account)がTrueで、アカウント登録される。
	
    //登録OK
    if(newItem) {
    	request.setAttribute("Msg", "登録しました！もう一度検索してください");
    	
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_ItemEdit.jsp");
        dispatcher.forward(request, response);
	}
	
    //登録できないとき
	else {
		// P305のコード10-16を参照
		request.setAttribute("errorMsg", "商品登録できませんでした");
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_ItemEdit.jsp");
        dispatcher.forward(request, response);
    }
	
  }
}