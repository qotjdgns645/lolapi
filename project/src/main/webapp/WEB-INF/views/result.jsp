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
<style>
.header {
	/* border: solid blue; */
	width: 1080px;
	height: 100% px;
	font-family: Helvetica, "Malgun Gothic", "Apple SD Gothic Neo",
		AppleGothic, Dotum, Arial, Tahoma;
}
/* 이미지 프로필 영역 시작 */
.IconLayout {
	float: left;
	width: 180px;
	height: 180px;
	border: solid red;
	display: flex;
	justify-content: center;
	align-items: center;
}

.summonerIcon {
	position: relative;
	border: solid red;
	width: calc(100% - 60px);
	height: calc(100% - 60px);
}

.level {
	margin-top: 120px;
	position: absolute;
	display: block;
	color: #eabd56;
	text-align: center;
	width: 44px;
	height: 24px;
	background: url("/resources/bg-levelbox.png");
	border: solid red;
}
/* 이미지 프로필 영역 끝 */
.profile>.name {
	margin-top: 40px;
/* 	border: solid purple; */
	font-size: 20px;
	font-weight: bold;
}

.profile>.rank {
	font-size: 11px;
	color: #555e5e;
}
.panel{
	border: solid red;
	position:relative;
	margin-left:180px;
	margin-bottom:50px;
	width:200px;
	background: #F2F2F2;
	text-align: left;
}
.rankprofile>.soloRank{
/* 	border: solid red; */
	position: relative;
	width : 80%;
	float: right;
}
.rankprofile>.flexRank{
/* 	border: solid red; */
	position: relative;
	width : 80%;
	float: right;
}
.winrate{
	display: block;
	font-size: 15px;
	font-weight: 600;
}
</style>
<script type="text/javascript">
	
	window.onload = function LeagueEntryDTO() {
		fetch('/tier',{
		      headers : { 
		          'Content-Type': 'application/json',
		          'Accept': 'application/json'
		         }
		        })
		        .then(response => response.json())
		        .then(data => {
		        	console.log(data);
		        	//soleRank
		        	document.getElementById('solotier').innerHTML=data[0].tier;
// 		        	document.getElementById('solotier').
		        	document.getElementById('sololeaguePoint').innerHTML=data[0].leaguePoints + ' LP';
		        	document.getElementById('solowins').innerHTML=data[0].wins + '승';
		        	document.getElementById('sololosses').innerHTML=data[0].losses + '패';
		        	document.getElementById('solowinrate').innerHTML='승률 ' + (data[0].wins / (data[0].losses+data[0].wins) * 100).toFixed(2) + '%';
		        	
		        	
		        	//flexRank
		        	document.getElementById('flextier').innerHTML=data[1].tier;
		        	document.getElementById('flexleaguePoint').innerHTML=data[1].leaguePoints + 'LP';
		        	document.getElementById('flexwins').innerHTML=data[1].wins + '승';
		        	document.getElementById('flexlosses').innerHTML=data[1].losses + '패';
		        	document.getElementById('flexwinrate').innerHTML='승률 ' + (data[1].wins / (data[1].losses+data[1].wins) * 100).toFixed(2) + '%';
		        });
		
	}

</script>
<body>
	<div class="data">
		<div>AccountId : ${SummonerDTO.accountId}</div>
		<!-- https://ddragon.leagueoflegends.com/api/versions.json 버전 리스트 -->
		<div>profileIconId : ${SummonerDTO.profileIconId}</div>
		<div>revisionDate : ${SummonerDTO.revisionDate}</div>
		<div>name : ${SummonerDTO.name}</div>
		<div>id : ${SummonerDTO.id}</div>
		<div>puuid : ${SummonerDTO.puuid}</div>
		<div>summonerLevel : ${SummonerDTO.summonerLevel}</div>
	</div>
	<hr>
	<div class="header">
		<div class="IconLayout">
			<img class="summonerIcon"
				src="http://ddragon.leagueoflegends.com/cdn/11.10.1/img/profileicon/${SummonerDTO.profileIconId}.png">
			<span class="level">${SummonerDTO.summonerLevel}</span>
		</div>
		<div class="profile">
			<div class="name">
				<span>${SummonerDTO.name}</span>
			</div>
			<div class="rankprofile">
			
				<div class="panel">
					<div class="solorank">
						<p>솔로랭크</p>
						<p id='solotier'></p>
						<span id='sololeaguePoint'></span> <span id='solowins'></span> <span
							id='sololosses'></span>
						<span id='solowinrate' class='winrate'></span>
					</div>
				</div>
				<div class="panel">
					<div class="flexrank">
						<p>자유 5:5 랭크</p>
						<p id='flextier'></p>
						<span id='flexleaguePoint'></span> <span id='flexwins'></span> <span
							id='flexlosses'></span>
						<span id='flexwinrate' class='winrate'></span>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>



