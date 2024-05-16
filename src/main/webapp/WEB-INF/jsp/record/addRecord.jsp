<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>addRecord</title>

=======
<%--
  Created by IntelliJ IDEA.
  User: jenny
  Date: 2024-04-30
  Time: 오전 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddRecord</title>
>>>>>>> 1b9f4425984f60396887d6916882e133559ce45c
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
            border: 1px solid black;
            padding-bottom: 30px;
        }

        h1 {
            color: #5F8BD7;
        }

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
<<<<<<< HEAD

=======
>>>>>>> 1b9f4425984f60396887d6916882e133559ce45c
    </style>
</head>
<body bgcolor='#E7EEF9'>
<div class='main'>
    &nbsp;
    <h1>기록 추가</h1><hr color='#E7EEF9'>
    &nbsp;
    <div id=form><form action="viewRecord.jsp" method="get">
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
                <td colspan="2" class="sub"><input type="submit" value="기록 추가" class="btn"></td>
            </tr>
        </table>
    </form></div>
</div>
</body>
<<<<<<< HEAD
</html>
=======
</html>
>>>>>>> 1b9f4425984f60396887d6916882e133559ce45c
