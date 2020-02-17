import java.io.*;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/12/03 20:08
 */

public class MyClassLoader extends ClassLoader {

    // 加载器的名称
    private String name;

    // 类存放的路径
    private String path = "/Users/jc/IdeaProjects/jvm/out/production/jvm/";

    public MyClassLoader(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    public MyClassLoader(String name) {
        this.name = name;
    }

    // 重写findClass方法
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = loadClassData(name);
        // 调用ClassLoader中的方法
        return this.defineClass(name, data, 0, data.length);
    }

    public byte[] loadClassData(String name) {
        // 将全限定类名转换为文件的路径
        name = name.replace(".", "/");
        try {
            FileInputStream fis = new FileInputStream(new File(path + name + ".class"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int flag = 0;
            // 将类的.class文件读如到一个byte数组中
            while ((flag = fis.read()) != -1) {
                bos.write(flag);
            }
            return bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
