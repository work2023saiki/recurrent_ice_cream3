//「スッキリわかるサーブレット＆JSP入門」P279のコード10-5を参考



package servlet;

import java.io.IOException;

import dao.DashboardDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
  private static final long serialVersionUID = 1L; 
  
//  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    // 入力した名前、パスワードを取得
//    request.setCharacterEncoding("UTF-8");
//    String number = request.getParameter("number");
//    String gender = request.getParameter("gender");
    
    //入力情報をdashboardインスタンスに保存。
  // DashboardBean dashboard = new DashboardBean(number,gender);
    
    //データベースに接続。アカウント情報を見つけて取得する。
    DashboardDAO dao = new DashboardDAO();
    
    //HttpSession session = request.getSession();

    public class Myservlet extends HttpServlet{
    	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
  }
  }