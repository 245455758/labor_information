package trouble.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trouble.domain.Labor;
import trouble.exception.LaborException;
import trouble.service.LaborService;

@WebServlet("/findLabors")
public class FindLabors extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindLabors() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LaborService ls  = new LaborService();
		try {
			List<Labor> list = ls.findLabors();
			request.getSession().setAttribute("labors", list);
			request.getRequestDispatcher("/admin/labor/list.jsp").forward(request, response);
		} catch (LaborException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/admin/home.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
