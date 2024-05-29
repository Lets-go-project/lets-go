<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ViewRecord</title>

    <style>
        body {
            text-align: center;
        }

        div.main {
            background-color: white;
            width: 80%;
            height: 80%;
            margin-left: auto;
            margin-right: auto;
            padding-bottom: 30px;
        }

        hr {
            width: 90%;
        }

        #left {
            margin-left: 50px;
            display: inline-block;
            float: left;
        }
        #right {
            margin-right: 50px;
            display: inline-block;
            float: right;
        }

        .btn {
            background-color: #6BBBD8;
            color: white;

        }

        .records {
            padding: 5px 10px 5px 10px;
            margin-top: 10px;
            margin-top: 10px;
        }
        .records:hover {
            background-color: lightgray;
            cursor: pointer;
        }

        a {
            text-decoration-line: none;
            color: inherit;
        }
    </style>

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

<div class='main'>
    &nbsp;
    &nbsp;
    <div id="left"><span><button type="button" class="btn" onclick="location.href='/record/add'">기록 추가</button></span></div>
    <div style="display:inline-block;">&nbsp;</div>
    <div id="right"><span>
	<label>정렬</label>
	<select>
		<option>기본</option>
		<option>날짜</option>
		<option>시간</option>
		<option>거리</option>
	</select>
</span></div>
    <div class='records'><a href="/record/update">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="/record/update">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="/record/update">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="/record/update">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="/record/update">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="/record/update">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="/record/update">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="/record/update">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="/record/update">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="/record/update">날짜 | 수영장 이름 | 시간 | 거리</a></div>
</div>

<!-- Footer-->
<footer class="py-5" style="background-color: #BDCDD6">
    <div class="container"><p class="m-0 text-center text-white">Software System &copy; 240105 marin-girls</p></div>
</footer>
</body>
</html>
