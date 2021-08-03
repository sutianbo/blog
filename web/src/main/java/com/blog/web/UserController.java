package com.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.core.cache.RedisService;
import com.blog.model.User;
import com.blog.model.dto.UserModel;
import com.blog.repo.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RedisService<String> redisService;
	
	@RequestMapping(value = "/addUser",method = RequestMethod.GET)
	@ResponseBody
	public void add(User user) {
		userRepository.save(user);
	}
	
	@RequestMapping(value = "/findUser",method = RequestMethod.GET)
	@ResponseBody
	public void findOne(Long id) {
		UserModel userModel = userRepository.findDtoByUsername("su");
		String a = "23";
		System.out.println(userModel);
	}
}
