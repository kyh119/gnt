window.onload = () => {
  let summonerName = window.location.pathname;
  summonerName = summonerName.replace('/search/', '').replaceAll('+','%20');
  const url = `/api/get/summoner/by-name/${summonerName}`;
  fetch(url).then((response) => {
    return response.json();
  }).then((data) => {
    console.log(data);
    const profileIcon = $('#summonerIcon');
    profileIcon.css('background', `url(/images/profileicon/${data.profileIconId}.png)`);

    const summonerLevel = $('#summonerLevel');
    summonerLevel.html(`${data.level}`);

    const summonerName = $('#summonerName');
    summonerName.html(`${data.name}`);

    const soloRankImg = $('#soloRankImg');

    const tierAndRank = $('#tierAndRank');
    tierAndRank.html(`${data.leagueList[0].tier} ${data.leagueList[0].rank}`);

    const leaguePoints = $('#leaguePoint');
    leaguePoints.html(`${data.leagueList[0].leaguePoints} LP`);

    const soloWinsAndLosses = $('#soloWinsAndLosses');
    const soloWins = data.leagueList[0].wins;
    const soloLosses = data.leagueList[0].losses;
    const winRate = $('#winRate');
    let _winRate = soloWins*100/(soloWins+soloLosses);
    soloWinsAndLosses.html(`${soloWins}승 ${soloLosses}패`);
    _winRate = _winRate.toString().slice(0, 4);
    winRate.html(`${_winRate}`);

  });
}
