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
import com.myweb.www.service.BoardService;
import com.myweb.www.service.MailSendService;
import com.myweb.www.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class boardController {
	
	@Inject
	private BoardService bsv;
	
	@GetMapping("QnA")
	public String QnA() {
		log.info("QnA진입");
		
		return "/board/QnA";
	}

	@GetMapping("insert")
	public String insert() {
		log.info("insert진입");
		
		return "/board/insert";
	}

}
