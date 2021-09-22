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
    soloRankImg.css('background', `url(/images/emblem/${data.soloLeague.tier}.png)`).css('background-size','cover');

    const tierAndRank = $('#tierAndRank');
    tierAndRank.html(`${data.soloLeague.tier} ${data.soloLeague.rank}`);

    const leaguePoints = $('#leaguePoint');
    leaguePoints.html(`${data.soloLeague.leaguePoints} LP`);

    const soloWinsAndLosses = $('#soloWinsAndLosses');
    const soloWins = data.soloLeague.wins;
    const soloLosses = data.soloLeague.losses;
    const winRate = $('#winRate');
    let _winRate = soloWins*100/(soloWins+soloLosses);
    soloWinsAndLosses.html(`${soloWins}승 ${soloLosses}패`);
    _winRate = _winRate.toString().slice(0, 4);
    winRate.html(`${_winRate}`);

  });
}
