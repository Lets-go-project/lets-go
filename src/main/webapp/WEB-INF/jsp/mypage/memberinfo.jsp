<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>form</title>
    <style>
        *{
            margin: 0px;
            padding:0;
        }
        body{
            background:#EEE9DA;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .wrap h1{
            font-size:32px;color:#4B89DC;
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
        .wrap input[type="tel"],
        .wrap input[type="email"]{
            padding:10px;
        }
        .wrap input[type="submit"]{
            width:100%; height:50px;
            background:#FCF8EC   ;
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
            background:#6096B4;
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
        div {
            width: 500px;
            float: left;
            border: 1px solid;
        }
    </style>

</head>
<div class="wrap">
    <h1>MYPAGE</h1>
    <img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20150301_3%2Fsalesclub_1425214359787MF16i_JPEG%2F755d87adb77a56db8a97590853cd331b.jpg&type=a340" alt="프로필 사진">
    <input type="button" value="삭제">
    <input type="button" value="변경">
    <form>
                <dl>
                    <dt>아이디</dt>
                    <dd><input type="text" placeholder="아이디">
                        <input type="button" value="edit">
                    </dd>
                </dl>
                <dl>
                    <dt>비밀번호</dt>
                    <dd><input type="password" placeholder="비밀번호">
                        <input type="button" value="edit"></dd>
                </dl>
                <dl>
                    <dd>
                        <a href="/letsGo" style="background-color: #93BFCF; height: 60px; display: inline-block; padding: 15px 20px; border-radius: 25px; color: #fff; text-decoration: none; text-align: center;">메인페이지</a>
                    </dd>
                </dl>
            </dl>
    </form>
</div>
</body>

</html>