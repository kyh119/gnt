const inputElem = document.querySelector('input');
const loginForm = document.querySelector('#loginForm');
const pElem = document.querySelector('p');
const USERNAME_KEY = 'username';


const saveUserName = (strInput) =>{
  // 로컬스토리지에 저장
  localStorage.setItem('username', strInput );
  
}
const loadUserName = () =>{
  return localStorage.getItem(USERNAME_KEY);
}
const printUserName = (userName) =>{
  pElem.classList.remove('hidden');
  pElem.innerText = `Hello ${userName}`;
  loginForm.classList.add('hidden');
}
const submitEvent = (event) =>{
  event.preventDefault();
  const userName = inputElem.value;
  //로그인 폼을 안보이게
  
  //텍스트를 보여주고
  printUserName(userName);
  
  //로컬스토리지에 저장
  saveUserName( userName );
}

const init = () =>{
  const username = loadUserName();
  if( username ){
    printUserName(username);
  }else{
    loginForm.addEventListener('submit', submitEvent );
  }

}
init();