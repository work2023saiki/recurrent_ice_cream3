//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考



package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import beans.DashboardBean;
import dao.BowDashboardDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    // 入力した年代を使う
    request.setCharacterEncoding("UTF-8");
    String nendai = request.getParameter("nendai");
    int nendai1 =  Integer.parseInt(nendai);
    
    //データベースに接続。アカウント情報を見つけて取得する。
    BowDashboardDAO dao = new BowDashboardDAO();
    try {
		List<DashboardBean> a = dao.getAllDashboards(nendai1);
		
		HttpSession session = request.getSession();
	    session.setAttribute("a", a);
	    
	} catch (SQLException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}  

   
  }
  }