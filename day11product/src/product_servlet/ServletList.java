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
import java.util.List;

/*
* 查询所有商品的servlet
* */
@WebServlet(name = "ServletList",urlPatterns = "/ServletList")
public class ServletList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        //1.读取数据库，查询商品列表
        ProductDao dao = new ProductDao();
        List<Product> list = dao.finaAll();

        //2.把商品显示到浏览器
        PrintWriter writer = response.getWriter();
        String html = "";
        html += "<html>";
        html += "<head>";
        html += "<title>显示商品列表</title>";
        html += "</head>";
        html += "<body>";
        html += "<table border='1' align='center' width='600px'>";
        html += "<tr>";
        html += "<th>编号</th><th>商品名称</th><th>商品型号</th><th>商品价格</th>";
        html += "</tr>";
        //遍历商品
        if (list != null) {
            for (Product p : list) {
                html += "<tr>";
                //?id为传参*******************
                html += "<td>"+p.getId()+"</td><td><a href='"+request.getContextPath()+"/ServletDetail?id="+p.getId()+"'>"+p.getProName()+"</td><td>"+p.getProType()+"</td><td>"+p.getPrice()+"</td>";
                html += "</tr>";
            }
        }
        html += "</table>";

        /*
        * 显示浏览历史
        * */
        html += "最近浏览过的商品：<br/>";
        //取出prodHist的cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("prodHist")) {
                    String prodHist = cookie.getValue();//3,2,1
                    System.out.println("prodHist receive:"+prodHist);
                    String[] ids = prodHist.split("-");//切分
                    //遍历浏览过的商品
                    for (String id : ids) {
                        //查询数据库，
                        System.out.println("for id:"+id);
                        Product p = dao.findById(id);
                        //显示到浏览器
                        html += "" + p.getId() + "&nbsp;" + p.getProName() + "&nbsp;" + p.getProType() + "&nbsp;" + p.getPrice() + "<br/>";
                    }
                }
            }
        }

        html += "</body>";
        html += "</html>";

        writer.write(html);
    }
}
