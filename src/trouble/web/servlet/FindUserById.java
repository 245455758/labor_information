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

@WebServlet("/findUserById")
public class FindUserById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindUserById() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		LaborService ls = new LaborService();
		try {
			Labor labor = ls.findLaborById(id);
			request.setAttribute("labor", labor);
			request.getRequestDispatcher("/modifyuserinfo.jsp").forward(request, response);
		} catch (LaborException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
