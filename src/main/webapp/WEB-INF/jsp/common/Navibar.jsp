<%@ page pageEncoding="utf-8" %>
<head>
    <title>Lets go</title>
</head>
<style>
    @font-face {
        font-family: 'Pretendard-Regular';
        src: url('https://fastly.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
        font-weight: 400;
        font-style: normal;
    }
    * {
        font-family: 'Pretendard-Regular', 'sans-serif';
    }
</style>
<body>
<nav class="navbar navbar-expand-lg" style="background-color: #93BFCF">
    <div class="container px-4 px-lg-5">
         <a class="navbar-brand" href="/letsGo">Lets go</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link" href="/record/view">기록</a></li>
                <li class="nav-item"><a class="nav-link" href="/challenge/all">챌린지</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="/market/list" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">마켓</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/market/list">All Products</a></li>
                        <li>
                            <hr class="dropdown-divider"/>
                        </li>
                        <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                    </ul>
                </li>
                <!--<li class="nav-item"><a class="nav-link" href="#">Button</a></li>-->
            </ul>
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="mypage/mypage">마이페이지</a></li>
                <li class="nav-item"><a class="nav-link" href="signin/signin">로그인</a></li>
                <li class="nav-item"><a class="nav-link" href="signup/signup">회원가입</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>