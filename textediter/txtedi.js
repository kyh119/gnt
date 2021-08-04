// 폰트스타일 셀렉트룰  눌러서 textarea 전체 글꼴 변경
// 폰트사이즈 셀렉트를 눌러서 글자전체 사이즈 변경
// - 변수저장(폰트스타일클래스가져옴)
// - 변수저장(textarea가져옴)
// - 폰트스타일.이벤트리스너 체인지 로 가져온 값을 텍스트 에리어의 폰트패밀리로 설정한다.

// 텍스트 데코레이션 내의 버튼을 눌러서 텍스트 데코 변경
// -텍스트데코레이션 클래스 가져와 변수로 저장
//-클릭이벤트처리
//글자색 배경색 바꾸기
//-color안의 input를 변수로 져장
//-체인지 이벤트 처리
//-
// 정렬버튼 눌러서 정렬
//-text-align클래스를 변수로 저장
//-clickEvent함수에 추가

// 줌레이트 을  let로 저장해 

// 줌아웃 
// if( 줌아웃값 >=50 ){
// 줌아웃값 = 줌레이트 - 10 
//줌레이트 = 줌아웃값}
// 줌 인
// if ( 줌인값 <=150){
// 줌인값 = 줌레이트 + 10 
// 줌레이트 = 줌아웃값}

const fontSelect= document.querySelector('.font-style');
const textArea = document.querySelector('.text-area');
const textDecoration = document.querySelector('.text-decoration');
const color = document.querySelector('.color');
const textAlign = document.querySelector('.text-align');
const zoomOut = document.querySelector('#zoom-out');
const zoomIn = document.querySelector('#zoom-in');

let zoomRate = Number(document.querySelector('.zoom-rate').innerHTML);

const clickEvent = (e) =>{
  switch(e.target.id){
    case 'bold' :
      if( textArea.style.fontWeight === 'normal' ){
        textArea.style.fontWeight = e.target.value;
      }else{
        textArea.style.fontWeight = 'normal';
      }
      break;
    case 'underline' :
      if( textArea.style.textDecoration !== 'underline' ){
        textArea.style.textDecoration = e.target.value;
      }else{
        textArea.style.textDecoration = 'none';
      }
      break;
    case 'italic' :
      if( textArea.style.fontStyle === 'normal' ){
        textArea.style.fontStyle = e.target.value;
      }else{
        textArea.style.fontStyle = 'normal';
      }
      break;
    case 'line-through' :
      if( textArea.style.textDecoration !== 'line-through' ){
        textArea.style.textDecoration = e.target.value;
      }else{
        textArea.style.textDecoration = 'none';
      }
      break;
    case 'left' :
      textArea.style.textAlign = e.target.value;
      break;
    case 'center' :
      textArea.style.textAlign = e.target.value;
      break; 
    case 'right' :
      textArea.style.textAlign = e.target.value;
      break; 
    
  }
  if( e.target.id === 'zoom-out'){
    if( zoomRate >= 50 ){
      zoomRate = zoomRate - 10;
      textArea.style.fontSize = 16*zoomRate/100+'px';
      document.querySelector('.zoom-rate').innerHTML = zoomRate;
    }
  }
  if( e.target.id === 'zoom-in'){
    if( zoomRate <= 150 ){
      zoomRate = zoomRate + 10;
      textArea.style.fontSize = 16*zoomRate/100+'px';
      document.querySelector('.zoom-rate').innerHTML = zoomRate;
    }
  }
  


//   줌아웃 
// if( 줌아웃값 >=50 ){
// 줌아웃값 = 줌레이트 - 10 
// 줌레이트 = 줌아웃값}

  
}
const changeEvent = (e) =>{
  if( e.target.id === 'font' ){
    textArea.style.fontFamily = e.target.value;
  }else if( e.target.id === 'font-size' ){
    textArea.style.fontSize = e.target.value;
  }else if( e.target.id === 'text-color'){
    textArea.style.color = e.target.value;
  }else if( e.target.id === 'background-color'){
    textArea.style.backgroundColor = e.target.value;
  }
} 


const init = () =>{
  fontSelect.addEventListener('change', changeEvent);
  textDecoration.addEventListener('click', clickEvent);
  textAlign.addEventListener('click', clickEvent);
  color.addEventListener('change', changeEvent);
  zoomOut.addEventListener('click', clickEvent);
  zoomIn.addEventListener('click', clickEvent);
}
init()