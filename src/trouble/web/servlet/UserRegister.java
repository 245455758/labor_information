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
		//������֤��
		String ckcode = request.getParameter("ckcode");
		String Check_code = (String) request.getSession().getAttribute("checkcode_session");
		if(!Check_code.equals(ckcode)) {
			request.setAttribute("ckcode_msg", "��֤�����");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return ;
		}
		//��ñ�����
		Labor labor = new Labor();
		try {
			BeanUtils.populate(labor, request.getParameterMap());
			//����ҵ���߼�
			LaborService ls = new LaborService();
			ls.register(labor);
			//�ַ�ת��
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
