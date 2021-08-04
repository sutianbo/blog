package com.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index() {
		String s = "9";
		return "index";
	}

	public void test2(){
		int b = 13;
	}
}
