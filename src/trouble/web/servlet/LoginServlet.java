package trouble.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trouble.domain.Labor;
import trouble.exception.LaborException;
import trouble.service.LaborService;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LaborService ls = new LaborService();
		try {
			Labor labor = ls.login(username,password);
			String path = "/index.jsp";
			System.out.println(labor.getPassword());
			if("'admin'".equals(labor.getRole())) {
				path = "/admin/login/home.jsp";
			}
			request.getSession().setAttribute("labor", labor);
			request.getRequestDispatcher(path).forward(request, response);
		} catch (LaborException e) {
			e.printStackTrace();
			request.setAttribute("labor_msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
