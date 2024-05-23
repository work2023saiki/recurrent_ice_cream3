//package servlet;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@WebServlet("/AddToCartServlet")
//public class AddToCartServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // フォームからの入力を取得
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        String productName = request.getParameter("productName");
//        int price = 1000; // 商品の価格（固定値）
//        int totalPrice = quantity * price;
//
//        // 注文時間を取得
//        LocalDateTime orderTime = LocalDateTime.now();
//
//        // 日時フォーマッターを作成
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        // フォーマットした注文時間をセッションに保存
//        String formattedOrderTime = orderTime.format(formatter);
//
//        // セッションを取得または新規作成
//        HttpSession session = request.getSession(true);
//
//        // カート情報をセッションに保存
//        session.setAttribute("totalPrice", totalPrice);
//        session.setAttribute("selectedQuantity", quantity);
//        session.setAttribute("productName", productName);
//        session.setAttribute("orderTime", formattedOrderTime);
//
//        // 注文内容確認画面にリダイレクト
//        response.sendRedirect("order_confirmation.jsp");
//    }
//}

package servlet;

import java.io.IOException;
import java.util.List;

import beans.AccountBean;
import beans.Product;
import beans.PurchaseBean;
import dao.CartShowDAO;
import dao.PurchaseDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	HttpSession session = request.getSession();
    	
    	
        @SuppressWarnings("unchecked")
		List<Product> productList = (List<Product>)session.getAttribute("products");
       
        
        AccountBean accountInfo = (AccountBean)session.getAttribute("accountInfo");
        int accountID = accountInfo.getAccountID();
        
        
        // リクエストパラメータを取得
        request.setCharacterEncoding("UTF-8");
        
        
        //https://www.sejuku.net/blog/15715#index_id0
        //https://style.potepan.com/articles/18052.html#JavaintString
        for(int i=0; i < productList.size(); i++) {
           String kosu = request.getParameter(String.valueOf(i));
           int kosu2 = Integer.parseInt(kosu);
           
           //もし、1個以上だったら仮注文に追加
           if(kosu2>0) {
        	   PurchaseDAO dao = new PurchaseDAO();
        	   dao.create(accountID, productList.get(i).getId(), kosu2);
           }
           
        }
        
        
        CartShowDAO dao = new CartShowDAO();
        List<PurchaseBean> cart = dao.cartInfo(accountID);
        
        
   		session.setAttribute("cart", cart);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/order_confirmation.jsp");
    	dispatcher.forward(request, response);
    	
    	
    }
}