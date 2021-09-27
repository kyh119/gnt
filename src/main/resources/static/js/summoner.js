const displayRankInfo = (league) => {
  const leagueName = league
  const soloRankImg = $('.solorank-img');
  soloRankImg.css('background', `url(/images/emblem/${league.tier}.png)`).css('background-size','cover');

  const soloRankTextDiv = $('.solorank-text');
  soloRankTextDiv.append($(`<h2>${league.tier} ${league.rank}</h2>`));
  soloRankTextDiv.append($(`<p>${league.leaguePoints} LP</p>`));
  const soloWins = league.wins;
  const soloLosses = league.losses;
  let _winRate = soloWins*100/(soloWins+soloLosses);
  _winRate = _winRate.toString().slice(0, 4);
  soloRankTextDiv.append($(`<p>${soloWins}승 ${soloLosses}패 (${_winRate}%)</p>`));
}


window.onload = () => {
  let summonerName = window.location.pathname.replace('/search/', '').replaceAll('+','%20');
  const url = `/api/get/summoner/by-name/${summonerName}`;
  fetch(url).then((response) => {
    return response.json();
  }).then((summonerData) => {
    console.log(summonerData);
    const summonerIcon = $('.summoner-icon');
    summonerIcon.css('background', `url(/images/profileicon/${summonerData.profileIconId}.png)`).css('background-size','cover');

    const summonerLevel = $(`<p>Lv <span>${summonerData.level}</span></p>`)
    summonerIcon.append(summonerLevel);

    const summonerInfoTextDiv = $('.summoner-info-text');
    summonerInfoTextDiv.append($(`<h2>${summonerData.name}</h2>`));
    summonerInfoTextDiv.append($(`<p>${summonerData.soloLeague.tier} ${summonerData.soloLeague.rank}</p>`));
    summonerInfoTextDiv.append($(`<p>랭킹 <span>111,111위</span> (상위 <span>22%</span>위)</p>`));
    
    if (summonerData.soloLeague !== null)
      displayRankInfo(summonerData.soloLeague);

    if (summonerData.teamLeague !== null)
      displayRankInfo(summonerData.teamLeague);

  });
}
