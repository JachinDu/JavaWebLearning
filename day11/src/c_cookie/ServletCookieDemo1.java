package c_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCookieDemo1",urlPatterns = "/ServletCookieDemo1")
public class ServletCookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建cookie对象
        Cookie cookie1 = new Cookie("name", "eric");
        //Cookie cookie2 = new Cookie("email", "jiachegn@fjds.com");


        /*
         * 1）设置cookie有效路径。
         *    默认在当前web应用下：/day11
         * */
       // cookie2.setPath("/day12");

        /*
        * 设置cookie有效时间
        * */
        //cookie1.setMaxAge(5);//20s：从最后不调用cookie开始计算


        //2.把cookie数据发送到浏览器
        //通过响应头发送：set-cookie名称
        response.addCookie(cookie1);
        //response.addCookie(cookie2);


        //3.接收浏览器发送到cookie信息
        Cookie[] cookies = request.getCookies();
        //判断null
        if (cookies != null) {
            for (Cookie c : cookies) {
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name + "=" + value);
            }
        } else {
            System.out.println("没有接收到cookie数据");
        }
    }
}
