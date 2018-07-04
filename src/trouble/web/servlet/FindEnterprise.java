package trouble.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trouble.domain.Enterprise;
import trouble.exception.EnterpriseException;
import trouble.service.EnterpriseService;

@WebServlet("/findEnterprise")
public class FindEnterprise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindEnterprise() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnterpriseService es = new EnterpriseService();
		try {
			List<Enterprise> list = es.findEnterprise();
			request.getSession().setAttribute("enters", list);
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);;
			
		} catch (EnterpriseException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/admin/login/home.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
