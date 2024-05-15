package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import beans.Product;
import dao.ProductDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
    	// リクエストの処理
    	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recurrent_ice_cream", "root", "adminadmin")) {
    	    ProductDAO productDAO = new ProductDAO(connection);

    	    // 商品情報の取得
    	    List<Product> products = productDAO.getAllProducts();

    	    // 商品情報をリクエスト属性に設定
    	    HttpSession session = request.getSession();
        	
        	session.setAttribute("products", products);
    	    
    	    // JSPにフォワード
    	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/products.jsp");
    	    dispatcher.forward(request, response);
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	}
    }
}