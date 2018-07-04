package trouble.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trouble.domain.Enterprise;
import trouble.exception.EnterpriseException;
import trouble.service.EnterpriseService;

@WebServlet("/findEntInfoServlet")
public class FindEntInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindEntInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		EnterpriseService es = new EnterpriseService();
		
		try {
			Enterprise enterprise = es.findEnterpriseById(id);
			
			request.getSession().setAttribute("e", enterprise);
			request.getRequestDispatcher("/product_info.jsp").forward(request, response);
			return ;
			
		} catch (EnterpriseException e) {
			
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/product_list.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
