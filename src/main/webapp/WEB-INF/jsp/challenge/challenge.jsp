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
    <title>Lets go Challenge</title>
    <style>
        div.choose {
            margin: 50px 0 10px 0;
        }
        div.list {
            margin-bottom: 50px;
        }
        table {
            margin: auto;
            width: 50%;
        }
        th.choose {
            text-align: left;
            font-size: x-large;
            width: 120px;
        }
        td.choose {
            text-align: left;
        }
        th.list {
            width: 50px;
        }
        td.list {
            text-align: center;
            height: 50px;
        }
        .btn {
            background-color: #6BBBD8;
            color: white;

        }
    </style>
</head>
<body>
<%@ include file="../common/Navibar.jsp" %>

<!-- Header-->
<header class="py-5" style="background-color: #BDCDD6">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Let's Go Challenge</h1>
            <p class="lead fw-normal text-white-50 mb-0">수영 기록 챌린지</p>
        </div>
    </div>
</header>

<div class="choose">
    <table>
        <tr>
            <th class="choose">리그 선택</th>
            <td class="choose">
                <input type="button" value="전체" class="btn">
                <input type="button" value="여자" class="btn">
                <input type="button" value="남자" class="btn">
            </td>
        </tr>
    </table>
</div>

<div class="list">
    <table>
        <tr>
            <th class="list">1th</th>
            <td class="list">Somsom</td>
            <td class="list">500m</td>
            <td class="list">2min</td>
            <td class="list">W</td>
        </tr>
        <tr>
            <th class="list">2nd</th>
            <td class="list">Katsuki</td>
            <td class="list">500m</td>
            <td class="list">3min</td>
            <td class="list">W</td>
        </tr>
        <tr>
            <th class="list">3rd</th>
            <td class="list">Killua</td>
            <td class="list">500m</td>
            <td class="list">4min</td>
            <td class="list">W</td>
        </tr>
        <tr>
            <th class="list">4th</th>
            <td class="list">Curapikt</td>
            <td class="list">500m</td>
            <td class="list">5min</td>
            <td class="list">W</td>
        </tr>
        <tr>
            <th class="list">5th</th>
            <td class="list">Illumi</td>
            <td class="list">500m</td>
            <td class="list">6min</td>
            <td class="list">W</td>
        </tr>
        <tr>
            <th class="list">6th</th>
            <td class="list">Sakura</td>
            <td class="list">500m</td>
            <td class="list">7min</td>
            <td class="list">W</td>
        </tr>
        <tr>
            <th class="list">7th</th>
            <td class="list">Shoto</td>
            <td class="list">500m</td>
            <td class="list">8min</td>
            <td class="list">W</td>
        </tr>
        <tr>
            <th class="list">8th</th>
            <td class="list">Dabi</td>
            <td class="list">500m</td>
            <td class="list">9min</td>
            <td class="list">W</td>
        </tr>
        <tr>
            <th class="list">9th</th>
            <td class="list">Zoldyck</td>
            <td class="list">500m</td>
            <td class="list">10min</td>
            <td class="list">W</td>
        </tr>
        <tr>
            <th class="list">10th</th>
            <td class="list">Hisoka</td>
            <td class="list">500m</td>
            <td class="list">11min</td>
            <td class="list">W</td>
        </tr>
    </table>
</div>

<!-- Footer-->
<footer class="py-5" style="background-color: #BDCDD6">
    <div class="container"><p class="m-0 text-center text-white">Software System &copy; 240105 marin-girls</p></div>
</footer>
</body>
</html>
