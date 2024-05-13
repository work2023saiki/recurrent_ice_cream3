package filter;

import java.io.IOException;

import beans.AccountBean;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//ログインしているか確認するフィルター
//P501の強制的ブラウジングに対処する
@WebFilter( {"/DeleteAccount", "/MyPageEdit", "/User_mypage"} )
public class LoginCheck implements Filter {
  public void init(FilterConfig fConfig) throws ServletException { }
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  throws IOException, ServletException {
    
    //https://design.nagomi-reha.com/filterlogin/#toc12  
	HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    
    HttpSession session = req.getSession();
    AccountBean accountInfo = (AccountBean)session.getAttribute("accountInfo");
    
    if (accountInfo == null) {
		// P305のコード10-16を参照
		req.setAttribute("errorMsg", "ログインしてください");
		
		//「((ServletRequest) request)」で型を変換
		RequestDispatcher dispatcher = ((ServletRequest) request).getRequestDispatcher("WEB-INF/jsp/account/login.jsp");
        dispatcher.forward(req, res); 
	}   
    
    chain.doFilter(request, response);
  }
  public void destroy() { }
}
