package servlet;

import entity.Employee;
import service.IEmployeeService;
import service.impl.EmployeeService;
import utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletIndex",urlPatterns = "/ServletIndex")
public class ServletIndex extends HttpServlet {

    //创建Service实例
    private IEmployeeService employeeService = new EmployeeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1,获取当前页参数，（第一次访问，当前页为null）
            String currPage = request.getParameter("currentPage");
            if (currPage == null ) {
                currPage = "1";  //设置当前页为1；
            }
            //转换
            int currentPage = Integer.parseInt(currPage);
            //2,创建PageBean对象，设置当前页参数，传入service方法参数
            PageBean<Employee> pageBean = new PageBean<>();
            pageBean.setCurrentPage(currentPage);
            //3,调用service
            employeeService.getAll(pageBean);
            //4，保存PageBean到request中
            request.setAttribute("pageBean",pageBean);

            //5,跳转
            request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request,response);
        } catch (Exception e) {
            //出现错误，跳转到错误页面
            e.printStackTrace();
        }
//        finally {
//            request.getRequestDispatcher("/error/error.jsp").forward(request,response);
//        }
    }
}
