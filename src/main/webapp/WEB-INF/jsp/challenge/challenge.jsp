<%--
  Created by IntelliJ IDEA.
  User: jenny
  Date: 2024-04-30
  Time: 오후 6:36
  To change this template use File | Settings | File Templates.
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Challenge</title>
    <style>
        .pc {
            display: block;
        }
        .mobile {
            display: none !important;
        }
        .content {
            width: 100%;
            text-align: center;
            overflow: hidden;
        }
        .search{
            position: relative;
            width: 934px;
            margin: 30px auto;
        }
        .search input{
            width: 100%;
            border: 2px solid #4ea0d8;
            background-color:white;
            border-radius: 8px;
            padding: 12px 15px;
            font-size: 18px;
        }
        .search img{
            position : absolute;
            width: 17px;
            top: 10px;
            right: 12px;
            margin: 0;
        }
        .map {
            width: 60%;
            text-align: center;
            margin: auto;
        }
        .top-list {
            width:934px;
            margin: 20px auto;
        }
        .list {
            display: flex;
            gap: 80px;
            border-bottom: 1px solid grey;
            padding: 20px 0;
            width:100%;
            align-items: center;
            justify-content: space-around;
        }
        .list p {
            font-size: 20px;
        }
        .img, .info, .button-wrap, .ch, .choose, .button-wrap{
            margin: 20px auto;
            width: 1000px;
            text-align: center;
        }
        .img .first {
            width: 100%;
        }
        .img .two {
            display: flex;
        }
        .img .two img {
            width: 200px;
        }
        .button-wrap {
            width: 100%;
            position: relative;
            justify-content:center;
            margin: 0 auto;
            margin-bottom: 200px;
        }
        .button-wrap .ye  {
            width: 200px;
            padding: 10px 20px;
            background: #4ea0d8;
            color: white;
            font-weight: 900;
            font-family: Gong Gothic OTF;
            font-size: 20px;
            position:absolute;
            line-height: 30px;
            bottom:-60px;
            right: calc(50% - 220px);
            border: 0;
        }
        .button-wrap .jjim {
            width: 200px;
            padding: 10px 20px;
            background: #4ea0d8;
            color: white;
            font-weight: 900;
            font-family: Gong Gothic OTF;
            font-size: 20px;
            position:absolute;
            line-height: 30px;
            bottom:-60px;
            left: calc(50% - 220px);
            border: 0;
        }
        .button-wrap .upload:hover {
            background-color: #385723 !important;
        }
        .button-wrap .cham {
            width: 200px;
            padding: 10px 20px;
            background: #4ea0d8;
            color: white;
            font-weight: 900;
            font-family: Gong Gothic OTF;
            font-size: 20px;
            position:absolute;
            line-height: 30px;
            bottom:-60px;
            left: calc(50% - 100px);
            border: 0;
        }
        .choose {
            display: flex;
            gap: 20px;
        }
        .choose .o{
            padding:5px 10px 10px 10px;
            border:1px solid #4ea0d8;
            border-radius: 10px;
            background-color: white;
        }
        .choose .x{
            padding:5px 10px 10px 10px;
            border:1px solid grey;
            border-radius: 10px;
            background-color: white;
        }
    </style>
</head>
<body>
<%@ include file="../common/Navibar.jsp" %>

<!-- Header-->
<header class="py-5" style="background-color: #BDCDD6">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Let's Go Record</h1>
            <p class="lead fw-normal text-white-50 mb-0">수영 기록 보기</p>
        </div>
    </div>
</header>

&nbsp;
&nbsp;

<h1 class="ch">CHELLENGE</h1>
<div class="choose">
    <h3>리그 선택</h3>
    <input type="button" value="여자" class="o">
    <input type="button" value="남자" class="x">
    <input type="button" value="전체" class="x">
</div>
<div class="top-list">
    <div class="list">
        <p>1등</p><p>somsom </p><p>500m</p><p>2min</p><p>W</p>
    </div>
    <div class="list">
        <p>2등</p><p>dndn </p><p>400m</p><p>3min</p><p>W</p>
    </div>
    <div class="list">
        <p>3등</p><p>efef </p><p>300m</p><p>2min</p><p>W</p>
    </div>
    <div class="list">
        <p>4등</p><p>sfef</p><p>200m</p><p>1min</p><p>W</p>
    </div>
</div>
<div class="button-wrap">
    <input type="button" value="참가하기" class="cham">
</div>

<!-- Footer-->
<footer class="py-5" style="background-color: #BDCDD6">
    <div class="container"><p class="m-0 text-center text-white">Software System &copy; 240105 marin-girls</p></div>
</footer>
</body>
</html>
