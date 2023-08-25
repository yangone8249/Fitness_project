package com.myweb.www.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myweb.www.domain.UserVO;
import com.myweb.www.service.MailSendService;
import com.myweb.www.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/user/*")
public class UserController {
	
	@Inject
	private UserService usv;
	@Autowired
	private MailSendService mailService;
	
	
	@GetMapping("/signUp")
	public String signUp() {
		
		return "/user/signUp";
	}
	
	@RequestMapping(value = "emailCheck", method = RequestMethod.POST)
	@ResponseBody
	public String emailCheck(@RequestBody String email, HttpServletRequest request, UserVO uvo) throws Exception {
		System.out.println("이메일 인증 요청이 들어옴!");
		System.out.println("이메일 인증 이메일 : " + email);
		uvo.setUserEmail(email);
		
		return mailService.joinEmail(email);
	}

}
