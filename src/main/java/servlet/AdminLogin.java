package servlet;

import java.io.IOException;

import beans.AdminAccountBean;
import dao.AdminLoginDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//import model.SHA256;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
  private static final long serialVersionUID = 1L;

  
  protected void doGet(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {
	 
	  /*
	  DashboardDAO dao = new DashboardDAO();
	  
	  try {
		List<DashboardBean> adminInfo = dao.getAllDashboards();
		System.out.println(adminInfo);
		System.out.println(adminInfo.get(0).getNumber());
		System.out.println(adminInfo.get(0).getGender());
		
		
	} catch (SQLException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
	 
	  */
	  
	  RequestDispatcher dispatcher = request1.getRequestDispatcher("WEB-INF/jsp/admin_login.jsp");
      dispatcher.forward(request1, response1);   //フォワードはjspフォルダ内に置く
  }  

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 入力した名前、パスワードを取得
	  	request.setCharacterEncoding("UTF-8");
	    String AdminName = request.getParameter("AdminName");
	    String AdminPassword = request.getParameter("AdminPassword"); 
	    
	    
	    //パスワードをハッシュ化する
	    //SHA256 pass = new SHA256();
	    //String hashpassword = pass.createHash(adminPassword);
    
	    //入力情報をaccountインスタンスに保存。
	    AdminAccountBean account = new AdminAccountBean(AdminName, AdminPassword);
	    //データベースに接続。アカウントIDを見つけて取得する。
	    AdminLoginDAO dao = new AdminLoginDAO();
		AdminAccountBean adminInfo = dao.findadminInfo(account);
		

		// アカウントIDが見つからなかったとき。
		// ログイン失敗
		if (adminInfo == null) {
			// P305のコード10-16を参照
			request.setAttribute("errorMsg", "アカウントが見つかりませんでした");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_login.jsp");
	        dispatcher.forward(request, response); 
		}   
		
		//見つかったとき
	    //ログイン成功
	    else {
	    	//セッションスコープに保存。マイページに表示するため
	    	HttpSession session = request.getSession();
	    	
     		String[] myArray = { "10代","20代","30代","40代","50代"};
    		request.setAttribute("myArray",myArray);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("admin_page.jsp");
    		dispatcher.forward(request,response);
    	
    		session.setAttribute("adminInfo", adminInfo);
	    
	    	response.sendRedirect("http://localhost:8080/recurrent_ice_cream/admin_page.jsp"); 
	    }
	  }

}
