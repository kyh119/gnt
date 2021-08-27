const todoFormElem = document.querySelector('#todoForm');
const todoInput = todoFormElem.querySelector('input');
const todoUl = document.querySelector('#todoList');


const deleteBtnEvent = (event) =>{ 
  const delObj = event.target.parentElement;
  delObj.remove();
}
const addTodoList = () =>{
  const value = todoInput.value;
  todoInput.value = "";
  const li = document.createElement("li");
  const span = document.createElement("span");
  span.innerText = value;
  const btn = document.createElement("button");
  btn.innerText = '❌';
  li.appendChild(btn);
  li.appendChild(span);
  todoUl.appendChild(li);

  btn.addEventListener('click', deleteBtnEvent );
}

const todoSubmitEvent = (event) =>{
  event.preventDefault();
  // console.log('submit event');
  addTodoList();
}

todoFormElem.addEventListener('submit', todoSubmitEvent );