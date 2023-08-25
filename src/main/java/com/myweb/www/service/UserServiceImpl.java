package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.myweb.www.domain.UserVO;
import com.myweb.www.mail.MailHandler;
import com.myweb.www.mail.TempKey;
import com.myweb.www.repository.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO udao;
	
    @Autowired
    JavaMailSender mailSender;
    
    @Override
    public void insertMember(UserVO uvo) throws Exception {
        //랜덤 문자열을 생성해서 mail_key 컬럼에 넣어주기
        String mail_key = new TempKey().getKey(30,false); //랜덤키 길이 설정
        uvo.setMailKey(mail_key);

        //회원가입
        udao.insertMember(uvo);
        udao.updateMailKey(uvo);

        //회원가입 완료하면 인증을 위한 이메일 발송
        MailHandler sendMail = new MailHandler(mailSender);
        sendMail.setSubject("[RunninGo 인증메일 입니다.]"); //메일제목
        sendMail.setText(
                "<h1>RunninGo 메일인증</h1>" +
                "<br>RunninGo에 오신것을 환영합니다!" +
                "<br>아래 [이메일 인증 확인]을 눌러주세요." +
                "<br><a href='http://localhost:8080/join/registerEmail?email=" + uvo.getUserEmail() +
                "&mail_key=" + mail_key +
                "' target='_blank'>이메일 인증 확인</a>");
        sendMail.setFrom("보내는사람@이메일", "러닝고");
        sendMail.setTo(uvo.getUserEmail());
        sendMail.send();
    }
    
	@Override
	public int updateMailKey(UserVO uvo) throws Exception {
	    return udao.updateMailKey(uvo);
	}

	@Override
	public int updateMailAuth(UserVO uvo) throws Exception {
	    return udao.updateMailAuth(uvo);
	}

	@Override
	public int emailAuthFail(String id) throws Exception {
	    return udao.emailAuthFail(id);
	}
	
	
	
}

