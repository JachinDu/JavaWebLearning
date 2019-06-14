package a_servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;

@WebServlet(name = "ServletConfigDemo", urlPatterns = "/ServletConfigDemo")
public class ServletConfigDemo extends HttpServlet {

   // private ServletConfig config;
    /*
    * 1)tomcat把这些参数在加载web应用时，封装到ServletConfig对象中
    * 2)tomcat调用init方法传入ServletConfig对象
    * */
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        this.config = config;
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        * 读取servlet参数
        * 常用api：
        *       String getInitParameter(String name)：根据参数名获取参数值
        *       Enumeration getInitParameterNames()：获取所有参数
        *       String getServletName()：得到此Servlet名称
        * */
        String path = this.getServletConfig().getInitParameter("path");
        File file = new File(path);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = null;
        while((str = br.readLine())!=null){
            System.out.println(str);
        }

        //查询当前servlet所有初始化参数
        Enumeration<String> enums = this.getServletConfig().getInitParameterNames();
        while (enums.hasMoreElements()) {
            String paramName = enums.nextElement();
            String paramValue = this.getServletConfig().getInitParameter(paramName);
            System.out.println(paramName +"="+paramValue);
        }

        //得到servlet名称
        String servletName = this.getServletConfig().getServletName();
        System.out.println(servletName);
    }
}
