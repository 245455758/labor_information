package trouble.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import trouble.domain.Labor;
import trouble.service.LaborService;

@WebServlet("/modifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Labor labor = new Labor();
		try {
			BeanUtils.populate(labor, request.getParameterMap());
			LaborService ls = new LaborService();
			
			ls.modifyLabor(labor);
			
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/modifyUserInfoSuccess.jsp");
			
		} catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
