<%@ taglib prefix="background" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>form</title>
    <script>
        function populateYears() {
            var yearDropdown = document.getElementById("year");
            var currentYear = new Date().getFullYear();
            for (var i = currentYear; i >= 1950; i--) {
                var option = document.createElement("option");
                option.text = i;
                option.value = i;
                yearDropdown.add(option);
            }
        }

        function populateDays() {
            var monthDropdown = document.getElementById("month");
            var dayDropdown = document.getElementById("day");
            var selectedMonth = monthDropdown.value;
            dayDropdown.innerHTML = "";
            var daysInMonth = new Date(
                parseInt(document.getElementById("year").value),
                parseInt(selectedMonth),
                0
            ).getDate();
            for (var i = 1; i <= daysInMonth; i++) {
                var option = document.createElement("option");
                option.text = i;
                option.value = i;
                dayDropdown.add(option);
            }
        }
    </script>
    <style>
        *{
            margin: 0px;
            padding:0;
        }
        body{
            background:#EEE9DA;
        }
        .wrap h1{
            font-size:32px;color:#6096B4;
            text-align: center;
            margin-bottom:50px;
        }
        .wrap{
            width:750px;
            margin:0 auto;
            padding:50px;
            box-sizing:border-box;
            background:#fff;

        }
        .wrap h1{
            padding-bottom:12px;
            border-bottom:3px solid#E5EEFA;
            font-size:32px;
            letter-spacing:-2px;
        }
        .wrap form {
            margin-top: 30px;
        }
        .wrap input[type="text"],
        .wrap input[type="password"],
        .wrap input[type="email"]{
            padding:10px;
        }
        .wrap input[type="submit"]{
            width:100%; height:50px;
            background:#BDCDD6;
            color :#fff;
            font-size:20px;
            border:none;
            border-radius:25px;
            margin-top:35px;
        }
        .wrap input[type="button"]{
            padding:6px 10px;
            border: none;
            border-radius:25px;
            background:#4BBDDC;
            font-weight: 600;
            color:#fff;
            cursor:pointer;
        }
        .wrap dt,
        .wrap dd {
            display: inline-block;
            font-size:14px;
            vertical-align:middle;
        }
        .wrap dl{
            margin-top:10px;
            font-size: 0;
        }
        .wrap dt {
            width: 20%;
        }
        .wrap dd{
            width: 80%;
        }
    </style>
</head>
<body onload="populateYears(); populateDays()">
<div class="wrap">
    <h1>회원가입</h1>
    <form action="FormAction.jsp" method="post">
        <dl>
            <dt>이름</dt>
            <dd><input type="text" name="name" placeholder="이름 입력"></dd>
        </dl>
        <dl>
            <dt>성별</dt>
            <dd>
                <input type="radio" name="gender" id="male" value="남자">
                <label for="male">남자</label>
                <input type="radio" name="gender" id="female" value="여자">
                <label for="female">여자</label>
            </dd>
        </dl>
        <dl>
            <dt>아이디</dt>
            <dd><input type="text" name="id" placeholder="아이디 입력"></dd>
        </dl>
        <dl>
            <dt>비밀번호</dt>
            <dd><input type="password" name="password" placeholder="비밀번호 입력"></dd>
        </dl>
        <dl>
            <dt>이메일</dt>
            <dd>
                <input type="email" name="email" placeholder="이메일 입력">
            </dd>
        </dl>
        <dl>
            <dt>주소</dt>
            <dd><input type="text" name="address" placeholder="아이디 입력"></dd>
        </dl>
        <dl>
            <dt>생년월일</dt>
            <dd>
                <select id="year" name="year" onchange="populateDays()">
                    <option value="">년</option>
                    <%
                        for (int i = 1950; i <= 2024; i++) {
                            out.println("<option value=\"" + i + "\">" + i + "</option>");
                        }
                    %>
                </select>
                <select id="month" name="month" onchange="populateDays()">
                    <option value="">월</option>
                    <%
                        for (int i = 1; i <= 12; i++) {
                            out.println("<option value=\"" + i + "\">" + i + "</option>");
                        }
                    %>
                </select>
                <select id="day" name="day">
                    <option value="">일</option>
                </select>
            </dd>
        </dl>
        <input type="submit" value="회원가입">
    </form>
</div>
</body>
</html>