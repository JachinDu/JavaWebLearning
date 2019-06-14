package contact_day10;

import org.dom4j.DocumentException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) throws IOException, DocumentException {

        //法1
//        Scanner scanner = new Scanner(System.in);
//        String command = scanner.next();
        //法2 (字节流转为字符流）
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ContactOperatorImpl operator = new ContactOperatorImpl();



        //不断的接受输入
        while (true) {

            //1.看到菜单
            printMenu();

            //2.接受用户输入命令
            String command = br.readLine();

            //3.根据用户输入执行不同操作
            if ("1".equals(command)) {

                //添加联系人
                Contact contact = new Contact();
                System.out.println("请输入编号: ");
                String id = br.readLine();
                System.out.println("请输入姓名: ");
                String name = br.readLine();
                System.out.println("请输入性别: ");
                String gender = br.readLine();
                System.out.println("请输入年龄: ");
                int age = Integer.parseInt(br.readLine());
                System.out.println("请输入手机: ");
                String phone = br.readLine();
                System.out.println("请输入邮箱: ");
                String email = br.readLine();
                System.out.println("请输入qq: ");
                String qq = br.readLine();

                setContact(operator, contact, id, name, gender, age, phone, email, qq);
                operator.addContact(contact);


            } else if ("2".equals(command)) {

                //修改联系人
                Contact contact = new Contact();
                System.out.println("请输入需要修改的联系人编号: ");
                String id = br.readLine();
                System.out.println("请输入需要修改的联系人姓名: ");
                String name = br.readLine();
                System.out.println("请输入需要修改的联系人性别: ");
                String gender = br.readLine();
                System.out.println("请输入需要修改的联系人年龄: ");
                int age = Integer.parseInt(br.readLine());
                System.out.println("请输入需要修改的联系人手机: ");
                String phone = br.readLine();
                System.out.println("请输入需要修改的联系人邮箱: ");
                String email = br.readLine();
                System.out.println("请输入需要修改的联系人qq: ");
                String qq = br.readLine();

                setContact(operator, contact, id, name, gender, age, phone, email, qq);
                operator.updateContact(contact);


            } else if ("3".equals(command)) {

                //删除联系人
                System.out.println("请输入需要删除的联系人id：");
                String id = br.readLine();
                operator.deleteContact(id);

            } else if ("4".equals(command)) {

                //查询所有联系人
                List<Contact> list = operator.findAll();
                for (Contact contact : list) {
                    System.out.println(contact);
                }

            } else if ("Q".equals(command)) {
                break;
            } else {
                System.out.println("输入命令有误！");
            }
        }

    }

    private static void setContact(ContactOperatorImpl operator, Contact contact, String id, String name, String gender, int age, String phone, String email, String qq) throws IOException, DocumentException {
        contact.setQq(qq);
        contact.setEmail(email);
        contact.setPhone(phone);
        contact.setGender(gender);
        contact.setAge(age);
        contact.setName(name);
        contact.setId(id);


    }

    private static void printMenu() {
        System.out.println("============================");
        System.out.println("[1]添加联系人");
        System.out.println("[2]修改联系人");
        System.out.println("[3]删除联系人");
        System.out.println("[4]查看所有联系人");
        System.out.println("[Q]退出系统");
        System.out.println("============================");
    }
}
