package cn.demo.controller;

import cn.demo.entity.UserInfo;
import cn.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Atom on 2015/8/31.
 */
@Controller
@RequestMapping("/userController")
public class UserController {

    private UserInfoService userInfoService;

    public UserInfoService getUserInfoService(){
        return userInfoService;
    }

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService){
        this.userInfoService = userInfoService;
    }

    @RequestMapping("/showUser")
    public String showUser(Model model){
        UserInfo userinfo = userInfoService.getByUserId(1);
        model.addAttribute("userinfo", userinfo);
        return "showUser";
    }
}
