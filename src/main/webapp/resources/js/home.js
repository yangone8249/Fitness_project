let programEvent = 0; // 새로고침 한번할때마다 한번만 작동되게 변수 선언
window.addEventListener('scroll', () => { //스크롤Y 300 진입 시 이벤트 진행 (Program 애니메이션 이벤트)
	
	if(window.scrollY >= 300 && programEvent == 0){
		document.getElementsByClassName('detail')[0].animate([
            { visibility: 'visible', top: '40%', opacity: '0.5'},
            { fill : 'forwards',top: '0%', opacity: '1'}
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 500
        });
        document.getElementsByClassName('detail')[1].animate([
            { visibility: 'visible', top: '40%', opacity: '0'},
            { top: '0%', opacity: '1'}
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 600
        });
        document.getElementsByClassName('detail')[2].animate([
            { visibility: 'visible', top: '40%', opacity: '0'},
            { top: '0%', opacity: '1'}
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 700
        });
        programEvent++;
        document.getElementsByClassName('detail')[0].style.visibility="visible";
        document.getElementsByClassName('detail')[1].style.visibility="visible";
        document.getElementsByClassName('detail')[2].style.visibility="visible";
	}
    
})

let slideCnt = 1;

function slideRight(){
    console.log("cnt : "+slideCnt);
    if(slideCnt == 1){ //1번째 슬라이드
        document.getElementsByClassName('upSlideBox')[0].animate([
            { transform: "translateX(200%)" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[1].animate([
            { transform: "translateX(-100%)" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[2].animate([
            { transform: "translateX(-100%)"}  
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[0].style.visibility = "hidden";
        setTimeout(()=>{
            document.getElementsByClassName('upSlideBox')[0].style.visibility = "visible";
        },800);
    }else if(slideCnt == 2){ //2번째 슬라이드
        document.getElementsByClassName('upSlideBox')[1].animate([
            { transform: "translateX(100%)" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[2].animate([
            { transform: "translateX(-200%)" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[0].animate([
            { transform: "translateX(100%)"}  
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[1].style.visibility = "hidden";
        setTimeout(()=>{
            document.getElementsByClassName('upSlideBox')[1].style.visibility = "visible";
        },800);
    }else{ //3번째 슬라이드
        document.getElementsByClassName('upSlideBox')[2].animate([
            { transform: "translateX(0%)" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[0].animate([
            { transform: "translateX(0%)" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[1].animate([
            { transform: "translateX(0%)"}  
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[2].style.visibility = "hidden";
        setTimeout(()=>{
            document.getElementsByClassName('upSlideBox')[2].style.visibility = "visible";
        },800);
    }
    
    
    
    slideCnt++;
    if(slideCnt==document.getElementsByClassName('upSlideBox').length+1){ //슬라이드를 마지막까지 도달하면 slideCnt 1로 초기화
        slideCnt = 1;
    }
    console.log("cnt : "+slideCnt);
}
function slideLeft(){
    console.log("cnt : "+slideCnt);
    if(slideCnt == 1){ //1번째 슬라이드
        document.getElementsByClassName('upSlideBox')[0].animate([
            { transform: "translateX(100%)" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[1].animate([
            { transform: "translateX(100%)" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[2].animate([
            { transform: "translateX(-200%)"}  
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[2].style.visibility = "hidden";
        setTimeout(()=>{
            document.getElementsByClassName('upSlideBox')[2].style.visibility = "visible";
        },800);
    }else if(slideCnt == 2){ //2번째 슬라이드
        document.getElementsByClassName('upSlideBox')[1].animate([
            { transform: "translateX(0%)" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[2].animate([
            { transform: "translateX(0%)" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[0].animate([
            { transform: "translateX(0%)"}  
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[0].style.visibility = "hidden";
        setTimeout(()=>{
            document.getElementsByClassName('upSlideBox')[0].style.visibility = "visible";
        },800);
    }else{ //3번째 슬라이드
        document.getElementsByClassName('upSlideBox')[2].animate([
            { transform: "translateX(-100%)" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[0].animate([
            { transform: "translateX(200%)" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[1].animate([
            { transform: "translateX(-100%)"}  
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 800
        });
        document.getElementsByClassName('upSlideBox')[1].style.visibility = "hidden";
        setTimeout(()=>{
            document.getElementsByClassName('upSlideBox')[1].style.visibility = "visible";
        },800);
    }
    
    
    
    slideCnt--;
    if(slideCnt==0){ //슬라이드를 처음 시작하면 slideCnt 1로 초기화
        slideCnt = 3;
    }
    console.log("cnt : "+slideCnt);
}