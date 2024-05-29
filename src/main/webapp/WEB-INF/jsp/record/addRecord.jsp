<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>addRecord</title>
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
            /*border: 1px solid black;*/
            padding-bottom: 30px;
        }

        /*h1 {*/
        /*    color: #5F8BD7;*/
        /*}*/

        hr {
            width: 90%;
        }

        #form {
            display: inline-block;
        }

        th, td {
            height: 50px;
            text-align: left;
        }
        th {
            width: 100px;
        }
        td {
            width: 200px;
        }
        td.sub {
            text-align: center;
        }

        .btn {
            background-color: #6BBBD8;
            color: white;

        }
    </style>

    <script>
        function addRecord() {
            window.alert('기록이 추가되었습니다.');
            window.location.href = "/record/view";
        }
    </script>
</head>
<body>
<%@ include file="../common/Navibar.jsp" %>

<!-- Header-->
<header class="py-5" style="background-color: #BDCDD6">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Let's Go Record</h1>
            <p class="lead fw-normal text-white-50 mb-0">수영 기록 추가</p>
        </div>
    </div>
</header>

&nbsp;
&nbsp;

<div class='main'>
    &nbsp;
    &nbsp;
    <div id=form><form action="/record/view" method="get">
        <table>
            <tr>
                <th>날짜</th>
                <td><input type="date" max="2050-12-31" min="2000-01-01"></td>
            </tr>
            <tr>
                <th>수영장 이름</th>
                <td><input type="text"></td>
            </tr>
            <tr>
                <th>시간</th>
                <td><input type="time"></td>
            </tr>
            <tr>
                <th>거리</th>
                <td><input type="text" size=1>KM</td>
            </tr>
            <tr>
                <td colspan="2" class="sub">
                    <input type="submit" value="기록 추가" onclick="addRecord()" class="btn"></td>
            </tr>
        </table>
    </form></div>
</div>

<!-- Footer-->
<footer class="py-5" style="background-color: #BDCDD6">
    <div class="container"><p class="m-0 text-center text-white">Software System &copy; 240105 marin-girls</p></div>
</footer>
</body>
</html>
