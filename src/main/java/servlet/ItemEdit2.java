//マイページ編集処理

package servlet;

import java.io.IOException;
import java.util.List;

import beans.ItemBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//管理者が商品情報を編集
@WebServlet("/ItemEdit2")
public class ItemEdit2 extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
      HttpSession session = request.getSession();
	  
	  @SuppressWarnings("unchecked")
	  List<ItemBean> ItemList = (List<ItemBean>)session.getAttribute("ItemList");
	  
	  request.setCharacterEncoding("UTF-8");
	  String loopindex = request.getParameter("loopIndex");
	  
	//int型に変換する  https://www.javadrive.jp/start/string/index12.html#section1   
	  int index = Integer.parseInt(loopindex);
	  
	  int itemID = ItemList.get(index).getItemID();
	  String itemName = ItemList.get(index).getItemName();
	  int price = ItemList.get(index).getPrice();	    
	  String itemExplain = ItemList.get(index).getItemExplain();
	  
	  ItemBean Item = new ItemBean(itemID, itemName, price, itemExplain);
	  
  	  request.setAttribute("Item", Item);
  	  
  	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ItemEdit2.jsp");
      dispatcher.forward(request, response); 
	    
  }
}