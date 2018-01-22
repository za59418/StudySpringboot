package com.zxl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxl.domain.User;
import com.zxl.domain.UserRepository;
import com.zxl.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@Resource
	private IUserService userService;
	
	/***************Service********************/
	@RequestMapping("/")
    public String index() {
        return "redirect:/user/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users=userService.getAllUsers();
        model.addAttribute("users", users);
        return "user/list";
    }
    
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }
    
    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/user/list";
    }
    
    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        User user=userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/user/list";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/user/list";
    } 
	
	/***************************************/
	
	/**************Repository*************/
	@RequestMapping("/getUserByName")
	User getUserByName() {
		User user = userRepository.findByUserName("aa");
        return user;
    }
	
	@RequestMapping("/getAllUsers")
	List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@RequestMapping("/addUser")
	User addUser() {
		User user = new User();

		user.setUserName("nice");
		user.setPassWord("nice");
		user.setNickName("nice");
		user.setRegTime("2018-01-16");
		userRepository.save(user);
		return user;
	}
	/**********************************/
	
}
