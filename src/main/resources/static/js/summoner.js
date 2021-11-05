

const displayRankInfo = (league, name) => {
  const rankImg = $(`.${name}rank-img`);
  rankImg.css('background', `url(/images/emblem/${league.tier}.png)`).css('background-size','cover');

  const rankTextDiv = $(`.${name}rank-text`);
  rankTextDiv.append($(`<h2>${league.tier} ${league.rank}</h2>`));
  rankTextDiv.append($(`<p>${league.leaguePoints} LP</p>`));
  const wins = league.wins;
  const losses = league.losses;
  let _winRate = wins*100/(wins+losses);
  _winRate = _winRate.toString().slice(0, 4);
  rankTextDiv.append($(`<p>${wins}승 ${losses}패 (${_winRate}%)</p>`));
}

window.onload = () => {
  let v,l,cdn;
  fetch("http://ddragon.leagueoflegends.com/realms/kr.json").then((response) => {
    return response.json();
  }).then((realmData) => {
    console.log(realmData)
    v = realmData.v;
    l = realmData.l;
    cdn = realmData.cdn;
  });

  let summonerName = window.location.pathname.replace('/search/', '').replaceAll('+','%20');
  const url = `/api/summoner/v1/by-name/${summonerName}`;
  fetch(url).then((response) => {
    return response.json();
  }).then((summonerData) => {
    console.log(summonerData);
    const summonerIcon = $('.summoner-icon');
    summonerIcon.css('background', `url(${cdn}/${v}/img/profileicon/${summonerData.profileIconId}.png)`).css('background-size','cover');

    const summonerLevel = $(`<p>Lv <span>${summonerData.summonerLevel}</span></p>`)
    summonerIcon.append(summonerLevel);

    const summonerInfoTextDiv = $('.summoner-info-text');
    summonerInfoTextDiv.append($(`<h2>${summonerData.name}</h2>`));
    summonerInfoTextDiv.append($(`<p>${summonerData.soloLeague.tier} ${summonerData.soloLeague.rank}</p>`));
    summonerInfoTextDiv.append($(`<p>랭킹 <span>111,111위</span> (상위 <span>22%</span>위)</p>`));
    
    if (summonerData.soloLeague !== null)
      displayRankInfo(summonerData.soloLeague,'solo');
    else
      $('.solorank-img').css('background', `url(/images/emblem/unranked.png)`).css('background-size','cover');

    if (summonerData.teamLeague !== null)
      displayRankInfo(summonerData.teamLeague,'free');
    else
      $('.freerank-img').css('background', `url(/images/emblem/unranked.png)`).css('background-size','cover');
  });
}
