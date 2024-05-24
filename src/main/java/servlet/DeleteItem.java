//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考
package servlet;

import java.io.IOException;
import java.util.List;

import beans.ItemBean;
import dao.ItemDeleteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DeleteItem")
public class DeleteItem extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	request.setCharacterEncoding("UTF-8");
	String loopIndex = request.getParameter("LoopIndex");
	
	//int型に変換する  https://www.javadrive.jp/start/string/index12.html#section1   
	int index = Integer.parseInt(loopIndex);
	
    
    HttpSession session = request.getSession();
    @SuppressWarnings("unchecked")
	List<ItemBean> ItemList = (List<ItemBean>)session.getAttribute("ItemList");
    
    int itemID = ItemList.get(index).getItemID();
    
    ItemDeleteDAO dao = new ItemDeleteDAO();
    
	if(dao.delete(itemID)) { request.setAttribute("Msg", "削除しました!"); }
	else { request.setAttribute("errorMsg", "削除できませんでした"); }
	
	//https://magazine.techacademy.jp/magazine/18607#sec3
    ItemList.remove(index);
		
	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_ItemEdit.jsp");
    dispatcher.forward(request, response); 

  }
  
}