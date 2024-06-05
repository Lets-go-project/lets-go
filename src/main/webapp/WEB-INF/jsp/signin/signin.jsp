<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        * {margin: 0; padding: 0; box-sizing: border-box;}
        body{
            display: flex;
            justify-content:center;
            align-items:center;
            height: 50vh;
            background:#BDCDD6;
            background-size: cover;
        }
        .login-form{position:relative;z-index:2;}
        .login-form h1{
            font-size:32px;color:#6096B4;
            text-align: center;
            margin-bottom:50px;
        }
        .input{width:400px; position:relative;}
        .input input {
            width : 100%;
            padding : 20px 10px 10px;
            font-size : 18px; color : #15273E;
        }
        .input label{
            position : absolute; left:10px; top:15px;
            font-size : 18px; color : #15273E;
        }
        .input input:focus + label,
        .input input:valid + label{
            top:0;
            font-size: 13px;
        }
        .btn {
            margin-top:30px;
        }
        .btn button{
            width:100%; height:50px;
            background:	#EEE9DA;
            color :#fff;
            font-size:20px;
            border:none;
            border-radius:25px;
        }
    </style>
</head>
<body>
<section class="login-form">
    <h1>DIA-LOG</h1>
    <form action="login_ok.jsp" method="post">
        <div class="input">
            <input type="text" name="ID" id="ID"> <label for="ID">ID</label>
        </div>
        <div class="input">
            <input type="password" name="password" id="password"> <label for="password">PASSWORD</label>
        </div>
        <div class="btn">
            <button type="submit">LOGIN</button>
        </div>
    </form>
</section>
</body>