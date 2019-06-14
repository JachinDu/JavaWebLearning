package c_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 案例：用户上次访问时间
* */

@WebServlet(name = "ServletHistory",urlPatterns = "/ServletHistory")
public class ServletHistory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        response.setContentType("text/html;charset=utf-8");//解决中文问题
//        //获取当前时间
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String curTime = format.format(new Date());
//
//        //取得cookie
//        Cookie[] cookies = request.getCookies();
//        String lastTime = null;
//
//        //第n次访问
//        if (cookies != null) {
//            System.out.println("cookies not null");
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("lastTime")) {
//                    //有lastTime,已经是第n次访问
//                    lastTime = cookie.getValue();
//                    response.getWriter().write("欢迎回来，你上次访问到时间为："+lastTime+",当前时间为："+curTime);
//                    //更新
//                    cookie.setValue(curTime);
//                    cookie.setMaxAge(1*30*24*60*60);//保存一个月
//                    //发送
//                    response.addCookie(cookie);
//                    break;
//                }
//            }
//        }
//
//        /*
//         * 第一次访问（没有cookie或没有名为lastTime的cookie
//         * */
//        if (cookies == null || lastTime == null) {
//            System.out.println("first time");
//            //1.显示当前时间到浏览器
//            response.getWriter().write("你是首次访问本网站，当前时间为："+curTime);
//            //2.创建cookie
//            Cookie cookie = new Cookie("lastTime", curTime);
//           cookie.setMaxAge(1*30*24*60*60);//保存一个月
//            //3.发送到浏览器
//            response.addCookie(cookie);
//        }
        response.setContentType("text/html;charset=utf-8");

        //获取当前时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");//不能有空格
        String curTime = format.format(new Date());


        //取得cookie
        Cookie[] cookies = request.getCookies();
        String lastTime = null;
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("lastTime")){
                    //有lastTime的cookie，已经是第n次访问
                    lastTime = cookie.getValue();//上次访问的时间
                    //第n次访问
                    //1.把上次显示时间显示到浏览器
                    response.getWriter().write("欢迎回来，你上次访问的时间为："+lastTime+",当前时间为："+curTime);
                    //2.更新cookie
                    cookie.setValue(curTime);
                    cookie.setMaxAge(1*30*24*60*60);
                    //3.把更新后的cookie发送到浏览器
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        /**
         * 第一次访问（没有cookie 或 有cookie，但没有名为lastTime的cookie）
         */
        if(cookies==null || lastTime==null){
            try {
                //1.显示当前时间到浏览器
                response.getWriter().write("你是首次访问本网站，当前时间为："+curTime);
                System.out.println(curTime);
                //2.创建Cookie对象
                Cookie cookie = new Cookie("lastTime",curTime);
                cookie.setMaxAge(1*30*24*60*60);//保存一个月
                //3.把cookie发送到浏览器保存
                response.addCookie(cookie);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
