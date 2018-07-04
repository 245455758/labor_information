package trouble.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trouble.domain.JobOffers;
import trouble.exception.JobOffersException;
import trouble.service.EnterpriseService;
import trouble.service.JobOffersService;

/**
 * Servlet implementation class FindJobInfo
 */
@WebServlet("/findJobInfo")
public class FindJobInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FindJobInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enter_id = request.getParameter("id");
		JobOffersService jos = new JobOffersService();
		try {
			List<JobOffers> list = jos.findOffersByEnterId(enter_id);
			request.getSession().setAttribute("l", list);
//			System.out.println(list);
			request.getRequestDispatcher("/cart.jsp").forward(request, response);
			return ;
		} catch (JobOffersException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/product_info.jsp");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
