//マイページ編集処理

package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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


//管理者が商品情報を編集
@WebServlet("/OrderComplete")
public class OrderComplete extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
      HttpSession session = request.getSession();
	  
	  AccountBean accountInfo = (AccountBean) session.getAttribute("accountInfo");
	  @SuppressWarnings("unchecked")
	  List<PurchaseBean> cart = (List<PurchaseBean>) session.getAttribute("cart");
	  
	  int accountID = accountInfo.getAccountID();
	  
  	  
	  // 現在日時を取得
      LocalDateTime nowDate = LocalDateTime.now();
      // 表示形式を指定
      DateTimeFormatter dtf =
          DateTimeFormatter.ofPattern("yyyy-MM-dd");
              String NowDate1 = dtf.format(nowDate);
              
              java.sql.Date buyDate = java.sql.Date.valueOf(NowDate1);
	  
      for(int i=0; i < cart.size(); i++) {
    	  int itemID = cart.get(i).getItemID();
    	  int kosu = cart.get(i).getNumber();
    	  
    	  PurchaseBean rec = new PurchaseBean(accountID, itemID, kosu, buyDate);
    	     
    	  PurchaseRecordDAO dao2 = new PurchaseRecordDAO();
      	  dao2.addRecord(rec);
      }        
  	  
  	  
      DeleteCartItemDAO dao = new DeleteCartItemDAO();
  	  dao.delete(accountID);
  	  
  	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/orderCompleted.jsp");
      dispatcher.forward(request, response); 
	    
  }
}