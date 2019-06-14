
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

@WebServlet(name = "ServletRequestDemo1", urlPatterns = "/ServletRequestDemo1")
public class ServletRequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取POST提交参数
//        InputStream in = request.getInputStream();   //得到实体内容
//        byte[] buf = new byte[1024];
//        int len = 0;
//        while ((len = in.read(buf)) != -1) {
//            String str = new String(buf, 0, len);
//            System.out.println(str);
//        }

        //统一方便的获取请求参数
        //1、根据参数名得到参数值
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        System.out.println(name+"="+password);
//        System.out.println("=============================================");
//        //2、拿到全部参数
//        Enumeration<String> enums = request.getParameterNames();
//        while (enums.hasMoreElements()) {
//            String paramName = enums.nextElement();
//            String paramValue = request.getParameter(paramName);
//            System.out.println(paramName+"="+paramValue);
//        }
        //调用doGet方式
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置参数查询码表
        request.setCharacterEncoding("utf-8");

        System.out.println(request.getMethod() +"方式");
//        //接受GET提交的参数
//        String value = request.getQueryString();
//        System.out.println(value);

        //统一方便的获取请求参数
        //1、根据参数名得到参数值
        String name = request.getParameter("name"); //只能获取一个值的参数，多选框只能获取第一个

        //手动重新解码（解决标签name属性值为中文的问题）(iso-8859-1字符串->utf-8字符串)
        //name = new String(name.getBytes("iso-8859-1"), "utf-8");

        String password = request.getParameter("password");
        System.out.println(name+"="+password);
        System.out.println("=============================================");
        //2、拿到全部参数
        Enumeration<String> enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paramName = enums.nextElement();
            if ("hobit".equals(paramName)) {
                //根据参数名获取多个同名参数值（适用于多选框）
                String[] hobits = request.getParameterValues("hobit");
                for (String h : hobits) {
                    System.out.println(paramName+":"+h + ",");
                }
            } else {
                String paramValue = request.getParameter(paramName);//只能获取一个值的参数，多选框只能获取第一个
                System.out.println(paramName+"="+paramValue);
            }


        }
    }
}
