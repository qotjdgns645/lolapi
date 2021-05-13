<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language='java' contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet" href="../../resources/style.css">
</head>
<body>
<div class="Face">
	<div class="ProfileIcon">
			<div class="borderImage" style="background-image: url(//opgg-static.akamaized.net/images/borders2/gold.png);"></div>
			<img src="//opgg-static.akamaized.net/images/profile_icons/profileIcon539.jpg?image=q_auto:best&amp;v=1518361200" class="ProfileImage">
	<span class="Level tip" title="레벨">${result.getSummonerLevel}</span>
	</div>
</div>

<div class="Profile">
	<div class="Information">
				<span class="Name">${result.getName}</span>
		<a class="FavoriteButton" href="#" id="FavoriteButton" onclick="$.OP.GG.common.SummonerHistory.Favorite.toggle(${result.getName}); return false;">
			<span class="deactive __spSite __spSite-101" style=""></span>
			<span class="active __spSite __spSite-102" style="display: none;"></span>
			즐겨찾기		</a>

		<div class="Rank">
		<div class="LadderRank">
			<a href="/ranking/ladder/summonerName=TUBASB" class="tip Link tpd-delegation-uid-1" title="" target="_blank">
				래더 랭킹 <span class="ranking">1</span>위 (상위 100%)
			</a>
		</div>
		</div>
		
</div>
</body>
</html>



