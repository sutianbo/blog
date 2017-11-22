package com.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.model.User;
import com.blog.repo.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public void add(User user) {
		userRepository.save(user);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	@ResponseBody
	public User findOne(@PathVariable("id")Long id) {
		if(true) {
			throw new IllegalStateException();
		}
		User user = userRepository.findOne(id);
		return user;
	}
}
