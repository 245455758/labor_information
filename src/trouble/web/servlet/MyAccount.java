package trouble.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trouble.domain.Labor;

@WebServlet("/myAccount")
public class MyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Labor labor = (Labor) request.getSession().getAttribute("labor");
		if(labor==null) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else {
			String path = "/myAccount.jsp";
			if("'admin'".equals(labor.getRole())) {
				path = "/admin/login/home.jsp";
			}
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
