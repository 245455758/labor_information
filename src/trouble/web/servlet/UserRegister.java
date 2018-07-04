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
import trouble.exception.LaborException;
import trouble.service.LaborService;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/register")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理验证码
		String ckcode = request.getParameter("ckcode");
		String Check_code = (String) request.getSession().getAttribute("checkcode_session");
		if(!Check_code.equals(ckcode)) {
			request.setAttribute("ckcode_msg", "验证码错误");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return ;
		}
		//获得表单数据
		Labor labor = new Labor();
		try {
			BeanUtils.populate(labor, request.getParameterMap());
			//调用业务逻辑
			LaborService ls = new LaborService();
			ls.register(labor);
			//分发转向
			request.getSession().setAttribute("labor", labor);
			request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
		}
//		catch(UserException e) {
//			request.setAttribute("user_msg", e.getMessage());
//			request.getRequestDispatcher("/register.jsp").forward(request, response);
//			return;
//		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
