//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考



package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import beans.DashboardBean;
import dao.DashboardDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 入力した名前、パスワードを取得
    request.setCharacterEncoding("UTF-8");
    String birth = request.getParameter("birth");
    String gender = request.getParameter("gender");
    
    Date birth1 = java.sql.Date.valueOf(birth);
    
    //パスワードをハッシュ化する
    //HashWithSHA256 pass = new HashWithSHA256();
    //String hashpassword = pass.createHash(name, password);
    
    //入力情報をdashboardインスタンスに保存。
    DashboardBean dashboard = new DashboardBean(birth1,gender);
    
    //データベースに接続。アカウント情報を見つけて取得する。
    DashboardDAO dao = new DashboardDAO();
    //List<DashboardBean> dashboardInfo;
	
    List<DashboardBean> dashboardInfo = null;
    
    
    for (DashboardBean dash : dashboardInfo) {
    	System.out.print("商品ID=1を購入した個数:" + dash.getNumber() );
    }
    
	try {
		dashboardInfo = dao.getAllDashboards();
	} catch (SQLException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
  }
  }