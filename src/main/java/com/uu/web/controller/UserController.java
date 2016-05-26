package com.uu.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uu.web.entity.User;

@Controller
@RequestMapping(value = "/user")
public class UserController
{
	@RequestMapping(value = "/")
	@ResponseBody
	public void index(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		
	}
	
	@RequestMapping(value = "/string")
	@ResponseBody
	public String string(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		return "string";
	}
	
	@RequestMapping(value = "/json")
	@RequiresPermissions(value = "123")
	@ResponseBody
	public User json(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		
		return user;
	}
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		SecurityUtils.getSubject().login(new UsernamePasswordToken("admin", "123456"));
		return "success";
	}
	
	@RequestMapping(value = "/logout")
	@ResponseBody
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		SecurityUtils.getSubject().logout();
		return "success";
	}
}
