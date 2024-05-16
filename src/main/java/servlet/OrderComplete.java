//マイページ編集処理

package servlet;

import java.io.IOException;
import java.util.List;

import beans.AccountBean;
import beans.PurchaseBean;
import dao.DeleteCartItemDAO;
import dao.PurchaseRecordDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//「注文完了」ボタンを押したとき実行される
@WebServlet("/OrderComplete")
public class OrderComplete extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
      HttpSession session = request.getSession();
	  
	  AccountBean accountInfo = (AccountBean) session.getAttribute("accountInfo");
	  @SuppressWarnings("unchecked")
	  List<PurchaseBean> cart = (List<PurchaseBean>) session.getAttribute("cart");
	  
	  int accountID = accountInfo.getAccountID();
	  
	  //仮注文テーブルから削除
	  DeleteCartItemDAO dao = new DeleteCartItemDAO();
  	  dao.deleteAll(accountID);
  	  

  	  
  	  //購入記録に追加
      for(int i=0; i < cart.size(); i++) {
    	  int itemID = cart.get(i).getItemID();
    	  int kosu = cart.get(i).getNumber();
    	  
    	  
    	  PurchaseBean rec = new PurchaseBean(accountID, itemID, kosu);
    	     
    	  PurchaseRecordDAO dao2 = new PurchaseRecordDAO();
      	  dao2.addRecord(rec);
      }        
  	  
      
  	  
  	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/orderCompleted.jsp");
      dispatcher.forward(request, response); 
	    
  }
}