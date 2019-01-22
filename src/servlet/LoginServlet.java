package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import dao.UserDao;

public class LoginServlet extends HttpServlet{

		public void doGet(HttpServletRequest request, HttpServletResponse response)	
				throws ServletException, IOException { 
			String username = request.getParameter("username");	
			String password=request.getParameter("password");
			UserDao uDao=new UserDao();
			boolean flag = uDao.login(username, password);
			
			HttpSession session = request.getSession();	
			if(!"".equals(username)&&!"".equals(password)&&flag) {
				session.setAttribute("username", username);  //�û���¼���뵽session��		
				response.sendRedirect("index.jsp");    //��¼�ɹ� ����index.jsp			
			} 
			else {
				response.sendRedirect("login.jsp?error=yes");
			}
	}
		public void doPost(HttpServletRequest request, HttpServletResponse response)		
				throws ServletException, IOException { 	
			this.doGet(request, response);
			}
}
