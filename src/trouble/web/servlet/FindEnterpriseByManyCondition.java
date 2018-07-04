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


@WebServlet("/findEnterpriseByManyCondition")
public class FindEnterpriseByManyCondition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FindEnterpriseByManyCondition() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		
		EnterpriseService es = new EnterpriseService();
		try {
			List<Enterprise> conlist = es.findEnterpriseByManyCondition(id,category,name);
			request.getSession().setAttribute("enters", conlist);
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		} catch (EnterpriseException e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
			response.sendRedirect(request.getContextPath()+"/findEnterprise");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
