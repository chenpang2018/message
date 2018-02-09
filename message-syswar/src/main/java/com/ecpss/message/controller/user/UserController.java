package com.ecpss.message.controller.user;

import com.ecpss.message.domain.user.BootUser;
import com.ecpss.message.infrastructure.rptimpl.user.UserRepository;
import com.ecpss.message.service.user.UserService;
import com.google.common.collect.Lists;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenpang on 2018/2/5.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserService userService;

    @RequestMapping(value = "saveUser", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveUser(String userName, String userNo) {
//        String userName = "ecpss001";
//        String userNo = "00009998";
//        BootUser user = new BootUser(userName, userNo);
//
//        userRepository.save(user);

        try {
            userService.saveUser(userName, userNo);
        } catch (RuntimeException e) {
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        }


        return "success";
    }

    @RequestMapping(value = "getUser.action", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getBootUserByName(String userName) {
        if (userName == null || userName == "") {
            return "failure";
        }
        BootUser user = userRepository.findByUserName(userName);
        if (user == null) {
            return "failure";
        }
        return "userNo:" + user.getUserNo() + ",userName:" + user.getUserName();
    }

    @RequestMapping(value = "userList.action", produces = "text/html;charset=UTF-8")
    public ModelAndView getUserList() {

        ModelAndView view = new ModelAndView();

        List<BootUser> userList = Lists.newArrayList();
        for (BootUser user : userRepository.findAll()) {
            userList.add(user);
        }

        view.addObject("userList", userList);
        view.setViewName("user/user");
        return view;
    }

}
