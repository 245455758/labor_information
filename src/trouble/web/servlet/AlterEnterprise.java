package trouble.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import trouble.domain.Enterprise;
import trouble.exception.EnterpriseException;
import trouble.service.EnterpriseService;

@WebServlet("/alterEnterprise")
public class AlterEnterprise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlterEnterprise() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enterprise enterprise = new Enterprise();
		
		try {
			BeanUtils.populate(enterprise, request.getParameterMap());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		EnterpriseService es = new EnterpriseService();
		try {
			es.updateEnterprise(enterprise);
			request.getRequestDispatcher("/findEnterprise").forward(request, response);
		} catch (EnterpriseException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/admin/login/home.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
