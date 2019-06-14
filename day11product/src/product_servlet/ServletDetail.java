package product_servlet;

import product_dao.ProductDao;
import product_entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

@WebServlet(name = "ServletDetail",urlPatterns = "/ServletDetail")
public class ServletDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        //1.获取编号(获取传递到参数)
        String id = request.getParameter("id");

        //2.到数据库中查询对应编号到商品
        ProductDao dao = new ProductDao();
        Product product = dao.findById(id);

        //3.显示到浏览器
        PrintWriter writer = response.getWriter();
        String html = "";
        html += "<html>";
        html += "<head>";
        html += "<title>显示商品详细</title>";
        html += "</head>";
        html += "<body>";
        html += "<table border='1' align='center' width='600px'>";
        if (product != null) {
            html += "<tr><th>编号：</th><td>" + product.getId() + "</td></tr>";
            html += "<tr><th>商品名称：</th><td>" + product.getProName() + "</td></tr>";
            html += "<tr><th>商品型号：</th><td>" + product.getProType() + "</td></tr>";
            html += "<tr><th>商品价格：</th><td>" + product.getPrice() + "</td></tr>";
        }
        html += "</table>";
        html += "<center><a href='"+request.getContextPath()+"/ServletList'>[返回列表]</center>";
        html += "</body>";
        html += "</html>";

        writer.write(html);

        /*
        * 创建cookie,并发送
        * */
        //1.创建
        Cookie cookie = new Cookie("prodHist", createValue(request,id));
        cookie.setMaxAge(1*30*24*60*60);
        //2.发送
        response.addCookie(cookie);

    }

    /*
     * 生成cookie的值
     *           当前cookie值        传入商品id      最终cookie值(默认长度不超过3个)
     *        null或没有prodHist        1               1
     *               1                 2               2,1
     *               2,1               1               1,2
     *               2,1               3               3,2,1
     *               3,2,1             2               2,3,1
     *               3,2,1             4               4,3,2
     * */
    private String createValue(HttpServletRequest request,String id) {
        Cookie[] cookies = request.getCookies();
        String prodHist = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("prodHist")) {
                    prodHist = cookie.getValue();
                    System.out.println("pre send prodhist:"+prodHist);
                    break;
                }
            }
        }

        //null或无prodHist
        if (cookies == null || prodHist == null) {
            //直接返回传入id
            return id;
        }

        //String -> String[] -> Collection：
        // 因为字符串用contain会出现3,21，   2包含在内的错误判断
        String[] ids = prodHist.split("-");
        Collection colls = Arrays.asList(ids);
        //LinkedList方便（增删改）
        //Collection -> LinkedList
        LinkedList list = new LinkedList(colls);

        //不超过3个
        if (list.size() < 3) {
            //id重复
            if (list.contains(id)) {
                //去掉重复id，把传入的id放在最前面
                list.remove(id);
                list.addFirst(id);
            } else {
                //直接把传入id放最前面
                list.addFirst(id);
            }
        } else {
            //等于三个，id重复
            if (list.contains(id)) {
                //去除重复id，把传入的id放在最前面
                list.remove(id);
                list.addFirst(id);
            } else {
                //去除最后的id，把传入的id放在最前面
                list.removeLast();
                list.addFirst(id);
            }
        }
        //LinkedList -> String
        StringBuffer sb = new StringBuffer();
        for (Object object : list) {
            sb.append(object + "-");
        }
        //去掉最后的逗号
        String result = sb.toString();
        result = result.substring(0, result.length() - 1);
        System.out.println("prodHist send:"+result);
        return result;
    }
}
