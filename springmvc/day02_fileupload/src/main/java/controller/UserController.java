package controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    /*
    * 传统文件上传
    * */
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");
        //使用fileupload组件完成文件上传
        //上传的位置
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(realPath);
        if (!file.exists()) {
            //不存在，则创建该文件夹
            file.mkdirs();
        }

        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request，List中全是文件项
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //判断当前item是否是上传文件项
            if (item.isFormField()) {
                //说明是普通表单项
            } else {
                //说明是上传文件项
                //获取上传文件名称
                String filename = item.getName();
                //把文件名设置成唯一值,以便上传相同文件名称不覆盖
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                //上传
                item.write(new File(realPath,filename));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /*
     * springmvc文件上传
     * MultipartFile类型参数名称必须和表单中上传文件框中的name属性的名称一样
     * */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传");
        //使用fileupload组件完成文件上传
        //上传的位置
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(realPath);
        //判断该路径是否存在
        File file = new File(realPath);
        if (!file.exists()) {
            //不存在，则创建该文件夹
            file.mkdirs();
        }

        //说明是上传文件项
        //获取上传文件名称
        String filename = upload.getOriginalFilename();
        //把文件名设置成唯一值,以便上传相同文件名称不覆盖
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //上传
        upload.transferTo(new File(realPath,filename));

        return "success";
    }

    /*
     * springmvc跨服务器文件上传
     * MultipartFile类型参数名称必须和表单中上传文件框中的name属性的名称一样
     * */
    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception {
        System.out.println("springmvc跨服务器文件上传");
        //定义上传服务器路径
        String path = "http://localhost:9090/uploads/";

        //说明是上传文件项
        //获取上传文件名称
        String filename = upload.getOriginalFilename();
        //把文件名设置成唯一值,以便上传相同文件名称不覆盖
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        //创建客户端的对象
        Client client = Client.create();
        //和图片服务器连接
        WebResource webResource = client.resource(path + filename);  //上面的服务器路径如果最后没有/，则这里要拼进去/
        //跨服务器上传
        webResource.put(upload.getBytes());

        return "success";
    }
}
