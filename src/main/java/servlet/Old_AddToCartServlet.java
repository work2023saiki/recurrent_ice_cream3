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

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Old_AddToCartServlet")
public class Old_AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	/*
    	// カートに追加された商品の情報を取得
        Map<String, Integer> cartItems = new HashMap<>();
        for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
            String paramName = entry.getKey();
            if (paramName.startsWith("quantity_")) {
                String productId = paramName.substring("quantity_".length());
                int quantity = Integer.parseInt(entry.getValue()[0]);
                cartItems.put(productId, quantity);
            }
        }

        // 購入情報をPurchaseBeanにセット
        PurchaseBean purchase = new PurchaseBean();
        purchase.setCartItems(cartItems);

        // PurchaseDAOを使用してデータベースに購入記録を保存
        PurchaseDAO purchaseDAO = new PurchaseDAO();
        boolean purchaseSuccess = purchaseDAO.savePurchase(purchase);

        // 注文完了ページにリダイレクト
        if (purchaseSuccess) {
            response.sendRedirect("order_confirmation.jsp");
        } else {

        }
        
        */
    	
    	
    	
    	
    	
    }
}