package a_tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/*
* 标签处理器类
* 1.继承SimpleTagSupport,需要导入jsp-api.jar
*
* */

public class ShowIPTag extends SimpleTagSupport {

    /*
    * 2.覆盖doTag方法
    * */

    @Override
    public void doTag() throws JspException, IOException {
        //向浏览器输出客户ip地址
        //拿到pageContext对象就可以拿到其他8个内置对象
        PageContext pageContext = (PageContext)this.getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String ip = request.getRemoteHost();
        JspWriter out = pageContext.getOut();
        out.write("客户ip地址："+ip);


    }
}
