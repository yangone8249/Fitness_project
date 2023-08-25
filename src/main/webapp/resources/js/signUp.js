document.getElementsByClassName('input')[0].addEventListener('keydown',()=>{ // 이메일 정규식 테스트 함수
    let emailCheck; //이메일 참,거짓 체크
    let emailRegex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
    
    // console.log('input : '+document.getElementsByClassName('input')[0].value);
    // console.log(emailRegex.test(document.getElementsByClassName('input')[0].value));
    emailCheck = emailRegex.test(document.getElementsByClassName('input')[0].value);

    // console.log(emailCheck);
    if(emailCheck){ // 정규식 맞으면 경고문 숨기기, 아니면 경고문 노출
        //정규식이 맞다면 이메일 인증번호 버튼도 disabled 해제
        document.getElementsByClassName('emailCheckBtn')[0].disabled = false;
        document.getElementsByClassName('emailCheckBtn')[0].style.color = "white";
        document.getElementsByClassName('emailCheckBtn')[0].style.backgroundColor = "#b3b3b3";

        document.getElementById('emailCheck').style.visibility = "hidden";
    }else{
        document.getElementsByClassName('emailCheckBtn')[0].disabled = true;
        document.getElementsByClassName('emailCheckBtn')[0].style.color = "black";
        document.getElementsByClassName('emailCheckBtn')[0].style.backgroundColor = "#e8f3f1";

        document.getElementById('emailCheck').style.visibility = "visible";
    }
});



document.getElementsByClassName('emailCheckBtn')[0].addEventListener('click', ()=>{ // 이메일 본인인증 클릭시 함수 진행
	try{
    const email = document.getElementsByClassName('input')[0].value; // 이메일 주소값 얻어오기!
        
    document.getElementById('emailNum').style.visibility = "visible";
	// console.log('완성된 이메일 : ' + email); // 이메일 오는지 확인

		$.ajax({ // 비동기 처리, post로 데이터 전달 (userController로 이동함.)
			type : 'post',
			url : '/user/emailCheck',
            data : email,
            contentType:"application/json; charset=utf-8",
			success : function (data) {
				// console.log("data : " +  data);
				code =data;
                document.getElementsByClassName('btn')[0].style.display = "block";
                alert('인증번호가 전송되었습니다.');
			}			
		});

    }catch(err){
        console.log(err);
    }       
    
});
document.getElementsByClassName('btn')[0].addEventListener('click', ()=>{
    const inputCode = document.getElementById('emailNum').value;

    if(inputCode === code){
        alert('이메일 인증되었습니다.');
        location.href = "/";
    }else{
        alert('인증번호가 불일치 합니다. 다시 확인해주세요!');

    }
});