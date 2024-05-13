//マイページ編集処理

package servlet;

import java.io.IOException;

import beans.ItemBean;
import dao.ItemEditDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ItemEdit3")
public class ItemEdit3 extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  request.setCharacterEncoding("UTF-8");
	  String name = request.getParameter("name");
	  String price = request.getParameter("price");	    
	  String itemExplain = request.getParameter("itemExplain");
	  String id = request.getParameter("button");    
	
	  //int型に変換する  https://www.javadrive.jp/start/string/index12.html#section1   
	  int itemprice = Integer.parseInt(price);
	  int itemID = Integer.parseInt(id);
	  
	  ItemBean item3 = new ItemBean(itemID, name, itemprice, itemExplain);
	         
	  ItemEditDAO dao = new ItemEditDAO();	    
	  dao.update(item3);

	  HttpSession session = request.getSession();
      //すっきりサーブレットP232参考
	  session.removeAttribute("accountList");
	  
	  request.setAttribute("Msg", "編集しました。もう一度検索してください。");
	
      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_ItemEdit.jsp");
      dispatcher.forward(request, response);
	    
  }
}