package ssm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.domain.Account;
import ssm.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
* 账户web层（控制器）
* */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层：查询所有账户。。。");
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        return "list";
    }
    @RequestMapping("/save")
    public void save(Account account, HttpServletResponse response, HttpServletRequest request) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"findAll");
        return;
    }
}
