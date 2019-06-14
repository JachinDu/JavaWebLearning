package a_tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/*
* 通过用户权限控制页面显示的信息
* */
public class DemoTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("执行了DemoTag");

        /*
        * 1.控制标签体内容输出
        *   输出：调用JspFragment.invoke
        *   不输出：不调用即可
        * */
        //1.1得到标签体内容
        JspFragment jspBody = this.getJspBody();
        /*
        * 执行invoke方法：把标签体内容输出到指定Writer中
        * */
        //1.2往浏览器输出
        JspWriter out = this.getJspContext().getOut();
        jspBody.invoke(out);
//        jspBody.invoke(null);等价与上面代码（默认王浏览器输出）


        /*
         * 3.重复输出标签体内容
         * */
        for (int i = 1; i < 5; i++) {
            jspBody.invoke(null);
        }

        /*
        * 4.改变标签体内容
        * */
        //4.1创建StringWriter临时容器
        StringWriter sw = new StringWriter();
        //4.2把标签体内容拷贝到临时容器
        jspBody.invoke(sw);
        //4.3从临时容器中得到标签体内容
        String content = sw.toString();
        //4.4改变内容
        content = content.toLowerCase();
        //4.5改变后的内容输出到浏览器
        this.getJspContext().getOut().write(content);

        /*
        * 2.控制标签余下内容输出
        *   输出：什么都不干
        *   不输出：抛出SkipPageException异常：
        * */
        throw new SkipPageException();


    }
}
