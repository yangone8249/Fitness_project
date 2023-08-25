package com.myweb.www.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.repository.BoardDAO;
import com.myweb.www.repository.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO udao;
	
}
