window.onload = () => {
  let summonerName = window.location.pathname;
  summonerName = summonerName.replace('/search/', '');
  summonerName = decodeURI(summonerName)
  const url = `/api/get/summoner/by-name/${summonerName}`;
  fetch(url).then((response) => {
    return response.json();
  }).then((data) => {
    console.log(data);
  });
}
