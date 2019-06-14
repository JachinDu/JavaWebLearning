package util;

import entity.Admin;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class WebUtils {
    /*
    * 处理请求数据的封装
    * */
    public static void copyToBean(HttpServletRequest request, Object obj) {
        try {
            Enumeration<String> enums = request.getParameterNames();
            while (enums.hasMoreElements()) {
                String name = enums.nextElement();
                System.out.println(name);
                String value = request.getParameter(name);
                System.out.println(value);
                BeanUtils.copyProperty(obj,name,value);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
