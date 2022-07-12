package com.arikaran.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.arikaran.DAO.UserDAO;
import com.arikaran.module.User;

@Controller
public class IndexServletController {
  
	@Autowired
	UserDAO userdao;
	
	@RequestMapping("index")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("addUser")
	public String addUser(User user) {
		userdao.save(user);
		return "index.jsp";
	}
	@RequestMapping("getUser")
	public ModelAndView getUser(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("ShowUser.jsp");
		User user = userdao.findById(id).orElse(new User());
		
	mav.addObject(user);
	return mav;
	}
	@RequestMapping("DeleteUser")
	public ModelAndView DeleteUser(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("DeleteUser.jsp");
	User user = userdao.findById(id).orElse(new User());
		userdao.deleteById(id);
		mav.addObject(user);
		return mav;
	
	}
	@RequestMapping("UpdateUser")
	public ModelAndView UpdateUser(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("UpdateUser.jsp");
		User user = userdao.findById(id).orElse(new User());
		mav.addObject(user);
		userdao.deleteById(id);
		return mav;
		
	}
}
