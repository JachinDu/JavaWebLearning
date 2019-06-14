package servlet;

import Dao.IAdminDao;
import entity.Admin;
import exception.UserExistsException;
import org.apache.commons.beanutils.BeanUtils;
import service.IAdminService;
import service.Impl.AdminServiceImpl;
import util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ServletAdmin",urlPatterns = "/ServletAdmin")
public class ServletAdmin extends HttpServlet {

    private IAdminService adminService = new AdminServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method1");
        if ("register".equals(method)) {
            register(request,response);
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String userName = request.getParameter("userName");
//        String pwd = request.getParameter("pwd");
//        Admin admin = new Admin();
//        admin.setUserName(userName);
//        admin.setPassword(pwd);

        Admin admin = new Admin();
        WebUtils.copyToBean(request,admin);

        try {
            adminService.register(admin);
            request.getRequestDispatcher("/register.jsp").forward(request,response);


        } catch (UserExistsException e) {
            request.setAttribute("message","用户名已经存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath()+"/error/error.jsp");
        }
    }
}
