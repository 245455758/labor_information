package trouble.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trouble.exception.EnterpriseException;
import trouble.service.EnterpriseService;

@WebServlet("/deleteEnterprise")
public class DeleteEnterprise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteEnterprise() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		EnterpriseService es = new EnterpriseService();
		try {
			es.deleteEnterpriseById(id);
			request.getRequestDispatcher("/findEnterprise").forward(request, response);
		} catch (EnterpriseException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
