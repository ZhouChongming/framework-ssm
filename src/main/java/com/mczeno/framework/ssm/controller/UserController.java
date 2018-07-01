package com.mczeno.framework.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Chongming Zhou
 * @date 2018-06-29
 */
@Controller
public class UserController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(String msg) {
		return "Hello " + msg;
	}

}
