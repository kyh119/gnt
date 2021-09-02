const success = (position) => {
  console.log(position);
  const lat = position.coords.latitude;
  const lon = position.coords.longitude;
  const API_KEY = 'cdae6f6e0f0ea44b1e4c7cf708a01ffb';
  const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${API_KEY}&units=metric`;
  console.log(url);
  fetch(url).then( (response)=>{
    return response.json();
  }).then( (data) => {
    console.log(data.name);
    console.log(data.weather[0].main);
    console.log(data.main.temp);//현재온도
  });
}
const error = () => {
  alert('당신의 위치 정보를 알아 올 수 없습니다.');
}
navigator.geolocation.getCurrentPosition(success, error);
