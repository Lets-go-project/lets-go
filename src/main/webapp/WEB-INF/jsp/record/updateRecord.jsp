<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>updateRecord</title>
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
    </style>
    <script src="deleteRecord.js"></script>
</head>
<body bgcolor='#E7EEF9'>
<div class='main'>
    &nbsp;
    <h1>기록 수정</h1><hr color='#E7EEF9'>
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
                <td colspan="2" class="sub"><input type="submit" value="기록 수정" class="btn">
                    <input type="button" value="기록 삭제" onclick="deleteRecord()" class="btn"></td>
            </tr>
        </table>
    </form></div>
</div>
</body>
</html>