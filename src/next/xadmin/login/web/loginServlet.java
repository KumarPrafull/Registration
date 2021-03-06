package next.xadmin.login.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import next.xadmin.login.bean.LoginBean;
import next.xadmin.login.database.LoginDao;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 String phone=request.getParameter("phone");
 String password=request.getParameter("password");
 
 LoginBean loginBean = new LoginBean();
 loginBean.setPhone(phone);
 loginBean.setPassword(password) ;
 
 LoginDao loginDao = new LoginDao();
 
 if(loginDao.validate(loginBean) ) 
 	{
	 HttpSession session = request.getSession();
	 session.setAttribute(phone, phone);
	 response.sendRedirect("viewmember?phone=" + phone);
 	}
 else
	 {
		 response.sendRedirect("login.jsp");
	 }
 
	}

}
