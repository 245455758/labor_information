package trouble.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trouble.domain.PageBean;
import trouble.service.EnterpriseService;

@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//导航按钮的查询条件
		String category = request.getParameter("category");
		if(category==null){
			category="";
		}
		//初始化每页显示的记录数
		int pageSize = 4;
		
		int currentPage = 1;//当前页
		String currPage = request.getParameter("currentPage");//从上一页或下一页得到的数据
		if(currPage!=null&&!"".equals(currPage)){//第一次访问资源时，currPage可能是null
			currentPage = Integer.parseInt(currPage);
		}
		
		EnterpriseService es = new EnterpriseService();
		//分页查询，并返回PageBean对象
		PageBean pb = es.findEnterprisePage(currentPage,pageSize,category);
		
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
