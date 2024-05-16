<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>viewRecord</title>

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
</head>
<body bgcolor='#E7EEF9'>
<div class='main'>
    &nbsp;
    <h1>기록 보기</h1><hr color='#E7EEF9'>
    &nbsp;
    <div id="left"><span><button type="button" class="btn" onclick="location.href='addRecord.jsp'">기록 추가</button></span></div>
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
    <div class='records'><a href="updateRecord.jsp">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="updateRecord.jsp">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="updateRecord.jsp">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="updateRecord.jsp">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="updateRecord.jsp">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="updateRecord.jsp">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="updateRecord.jsp">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="updateRecord.jsp">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="updateRecord.jsp">날짜 | 수영장 이름 | 시간 | 거리</a></div>
    <div class='records'><a href="updateRecord.jsp">날짜 | 수영장 이름 | 시간 | 거리</a></div>
</div>
</body>
</html>