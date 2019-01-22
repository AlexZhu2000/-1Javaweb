package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {
	public void destroy() {
		} 	
	public void doFilter(ServletRequest servletRequest,	ServletResponse servletResponse, FilterChain filterChain)			throws IOException, ServletException { 	
		HttpServletRequest req = (HttpServletRequest) servletRequest;		
		HttpSession session = req.getSession();		
		String username = (String)session.getAttribute("username");		
		if (username != null&&username!="") {	
			// ������ڴ�����session�����������¼�������		
			filterChain.doFilter(servletRequest, servletResponse);		
			} else {	// ��ת����ʾ��½ҳ��			
				servletRequest.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);	
				}	
		} 
	public void init(FilterConfig filterConfig) throws ServletException {	
		
	}
}
