window.addEventListener('scroll', ()=>{ //스크롤 시 해더 배경색상 투명도 설정 이벤트

    console.log('스크롤 위치 : '+window.scrollY);
    if(window.scrollY != 0){
        console.log('if문 진입');
        document.getElementById('headerDiv').animate([
            { backgroundColor: "#00000082" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 1000
        });
    }else{
        console.log('else문 진입');
        document.getElementById('headerDiv').animate([
            { backgroundColor: "#000" }
        ],{
            fill : 'forwards',
            easing : 'ease-in-out',
            duration : 500
        });
    }

});