<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lets go Record</title>

    <style>
        body {
            text-align: center;
        }
        div.main {
            width: 60%;
            height: 80%;
            margin: auto;
        }
        .top-choose {
            width: 90%;
            margin: 50px auto 20px;
        }
        #left {
            text-align: left;
        }
        #right {
            text-align: right;
        }
        .btn {
            background-color: #6BBBD8;
            color: white;
        }
        div.list {
            margin-bottom: 30px;
        }

        .recTitle {
            width: 90%;
            padding: 5px 10px 5px 10px;
            margin: auto;
        }
        .records {
            width: 90%;
            padding: 5px 10px 5px 10px;
            margin: 10px auto;
        }
        .records:hover {
            background-color: lightgray;
            cursor: pointer;
        }

        a {
            text-decoration-line: none;
            color: inherit;
        }
        table {
            text-align: center;
            width: 100%;
        }
        .title {
            border-top: solid 2px;
            border-bottom: solid 1px;
            height: 35px;
        }
        .underline {
            margin: auto;
            width: 90%;
            border-bottom: solid 2px;
            height: 7px;
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

<div class='main'>
    <div class="top-choose">
        <table><tr>
            <td id="left"><button type="button" class="btn" onclick="location.href='/record/add'">기록 추가</button></td>
            <td id="right">
                <label>정렬</label>
                <label>
                    <select>
                        <option>기본</option>
                        <option>날짜</option>
                        <option>시간</option>
                        <option>거리</option>
                    </select>
                </label>
            </td>
        </tr></table>
    </div>
    <div class='recTitle'>
        <table class="title"><tr><td>날짜</td> <td>수영장 이름</td> <td>시간</td> <td>거리</td></tr></table></div>
    <div class="list">
        <div class='records'><a href="/record/update">
            <table><tr><td>날짜</td> <td>수영장 이름</td> <td>시간</td> <td>거리</td></tr></table></a></div>
        <div class='records'><a href="/record/update">
            <table><tr><td>날짜</td> <td>수영장 이름</td> <td>시간</td> <td>거리</td></tr></table></a></div>
        <div class='records'><a href="/record/update">
            <table><tr><td>날짜</td> <td>수영장 이름</td> <td>시간</td> <td>거리</td></tr></table></a></div>
        <div class='records'><a href="/record/update">
            <table><tr><td>날짜</td> <td>수영장 이름</td> <td>시간</td> <td>거리</td></tr></table></a></div>
        <div class='records'><a href="/record/update">
            <table><tr><td>날짜</td> <td>수영장 이름</td> <td>시간</td> <td>거리</td></tr></table></a></div>
        <div class='records'><a href="/record/update">
            <table><tr><td>날짜</td> <td>수영장 이름</td> <td>시간</td> <td>거리</td></tr></table></a></div>
        <div class='records'><a href="/record/update">
            <table><tr><td>날짜</td> <td>수영장 이름</td> <td>시간</td> <td>거리</td></tr></table></a></div>
        <div class='records'><a href="/record/update">
            <table><tr><td>날짜</td> <td>수영장 이름</td> <td>시간</td> <td>거리</td></tr></table></a></div>
        <div class='records'><a href="/record/update">
            <table><tr><td>날짜</td> <td>수영장 이름</td> <td>시간</td> <td>거리</td></tr></table></a></div>
        <div class='records'><a href="/record/update">
            <table><tr><td>날짜</td> <td>수영장 이름</td> <td>시간</td> <td>거리</td></tr></table></a></div>
        <div class="underline"><table><tr><td></td></tr></table></div>
    </div>
<%--    <div class="page">--%>
<%--        나중에 하자--%>
<%--    </div>--%>
</div>

<!-- Footer-->
<footer class="py-5" style="background-color: #BDCDD6">
    <div class="container"><p class="m-0 text-center text-white">Software System &copy; 240105 marin-girls</p></div>
</footer>
</body>
</html>
