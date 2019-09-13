package com.alpha.springbootweb.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import  com.alpha.springbootweb.model.User;
import com.alpha.springbootweb.service.Userservice;
import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
   Userservice userservice;


    @RequestMapping ( "/" )
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping ( "/list" )
    public String list(Model model) {

        List<User> users = userservice.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping ( "/toAdd" )
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping ( "/add" )
    public String add(User user) {
        userservice.save(user);
        return "redirect:/list";
    }

    @RequestMapping ( "/toEdit" )
    public String toEdit(Model model, Long id) {
        User user = userservice.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping ( "/edit" )
    public String edit(User user) {
        userservice.edit(user);
        return "redirect:/list";
    }


    @RequestMapping ( "/delete" )
    public String delete(Long id) {
        userservice.delete(id);
        return "redirect:/list";
    }
}
