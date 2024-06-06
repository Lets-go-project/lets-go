<%@ page pageEncoding="utf-8" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Lets go Pool</title>
    <style>
        .map {width: 80%; margin:20px auto; height: 500px; display: block;}
        .main {
            background-color: white;
            width: 80%;
            margin-left: auto;
            margin-right: auto;
            /*border: 1px solid black;*/
        }
        .search {
            position: relative;
            width: 300px;
            margin: 0 auto;
            padding-top: 5px;
        }
        .search input{
            width: 100%;
            border: 1px solid #bbb;
            border-radius: 20px;
            padding: 10px 16px;
            font-size: 15px;
            opacity: 0.5;
            outline: none;
        }
        .search img{
            position : absolute;
            width: 17px;
            top: 15px;
            right: 12px;
            margin: 0;
        }

        .filter-bar {
            margin-top: 20px;
        }
        .select-box, .button-box {
            display: inline-block;
        }
        .select-box select, .button-box button {
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            box-shadow: none;
            border: 1px solid #d9e0e6;
            border-radius: 20px;
            display: flex;
            font-size: 14px;
            text-align: center;
            margin-left: 5px;
            padding: 0 15px;
            line-height: 32px;
            height: 32px;
            position: relative;
            cursor: pointer;
            background-color: transparent;
            outline: none;
            transition: border-color 0.3s ease;
        }
        .select-box select:valid,
        .view-scrap-button.clicked{
            border: 1px solid #6BBBD8;
        }

    </style>
</head>
<body>
<!-- Header-->
<header class="py-5" style="background-color: #BDCDD6">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Let's Go POOL !</h1>
            <div class="search">
                <input type="text" placeholder="지역 또는 수영장을 검색하세요">
                <img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
            </div>
        </div>
    </div>
</header>

<div class='main'>
    <div class="filter-bar">
        <div class="select-box">
            <form id="myForm" action="" method="post">
            <select name="area1" required>
                <option value="">전국</option>
                <option value="서울">서울</option>
                <option value="경기">경기</option>
                <option value="인천">인천</option>
                <option value="강원">강원</option>
                <option value="충북">충북</option>
                <option value="충남">충남</option>
                <option value="대전">대전</option>
                <option value="대구">대구</option>
                <option value="경북">경북</option>
                <option value="부산">부산</option>
                <option value="울산">울산</option>
                <option value="경남">경남</option>
                <option value="광주">광주</option>
                <option value="전남">전남</option>
                <option value="전북">전북</option>
                <option value="제주">제주</option>
            </select>
            </form>
        </div>
        <div class="button-box">
            <button class="view-scrap-button" onclick="changeBorderColor(this)">스크랩 보기</button>
        </div>
    </div>
</div>
<div id="map" class="map"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7ce4fc9ac0a312eaf303f311cb97413a"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<!-- Footer-->
<footer class="py-5" style="background-color: #BDCDD6">
    <div class="container"><p class="m-0 text-center text-white">Software System &copy; 240105 marin-girls</p></div>
</footer>
</body>
<script>
    function changeBorderColor(button) {
        button.classList.toggle('clicked');
    }


    var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
    var options = { //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
        level: 3 //지도의 레벨(확대, 축소 정도)
    };

    var map = new kakao.maps.Map(container, options);
</script>
</html>