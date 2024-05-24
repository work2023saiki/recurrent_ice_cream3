//マイページ編集処理

package servlet;

import java.io.IOException;
import java.util.List;

import beans.ItemBean;
import dao.ItemEditDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//管理者が商品情報を編集
@WebServlet("/ItemEdit")
public class ItemEdit extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  HttpSession session = request.getSession();	     
	  request.setCharacterEncoding("UTF-8");
	  
	  String loopIndex = request.getParameter("LoopIndex");	     
      String ItemID_BySave = request.getParameter("Save");
    
      //int型に変換する  https://www.javadrive.jp/start/string/index12.html#section1   
	  int index = Integer.parseInt(loopIndex);
	 
  
      @SuppressWarnings("unchecked")
	  List<ItemBean> ItemList = (List<ItemBean>)session.getAttribute("ItemList");
	 
	  
      //編集前実行。「編集」ボタン押したとき。
      if(ItemID_BySave == null) {  
		  
		  ItemBean Item = ItemList.get(index); 
	  	  request.setAttribute("Item", Item);
	  	  request.setAttribute("LoopIndex", loopIndex);
  	  
	  	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ItemEdit.jsp");
	      dispatcher.forward(request, response); 
	      
      }
      
      //編集後実行。「保存する」ボタン押したとき。
      else {
    	  String name = request.getParameter("name");
    	  String price = request.getParameter("price");	    
    	  String Explain = request.getParameter("itemExplain");    	  
    	
    	  int itemID = Integer.parseInt(ItemID_BySave);
    	  int itemprice = Integer.parseInt(price);
     	 
    	  ItemBean item = new ItemBean(itemID, name, itemprice, Explain);
    	         
    	  ItemEditDAO dao = new ItemEditDAO();	    
    	  dao.update(item);
    	  
    	  //https://magazine.techacademy.jp/magazine/18607#sec3
    	  ItemList.set(index, item);

    	  
    	  request.setAttribute("Msg", "編集完了!");
    		
    	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_ItemEdit.jsp");
          dispatcher.forward(request, response);
    	  
      }
  }
}