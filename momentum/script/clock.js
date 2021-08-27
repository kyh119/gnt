const clockElem = document.querySelector('#clock');

const getClock = () =>{
  const date = new Date();
  const hh = String( date.getHours()).padStart(2, '0');
  const mm = String( date.getMinutes()).padStart(2, '0');
  const ss = String( date.getSeconds()).padStart(2, '0');
  clockElem.innerText = `${hh} : ${mm} : ${ss}`
  
}
getClock();
setInterval( getClock , 1000 );

