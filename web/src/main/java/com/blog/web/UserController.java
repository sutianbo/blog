package com.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.model.User;
import com.blog.repo.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/addUser",method = RequestMethod.GET)
	@ResponseBody
	public void add(User user) {
		userRepository.save(user);
	}
	
	@RequestMapping(value = "/findUser",method = RequestMethod.GET)
	@ResponseBody
	public User findOne(Long id) {
		User user = userRepository.findOne(id);
		return user;
	}
}
