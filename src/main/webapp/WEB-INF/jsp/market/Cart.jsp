<%@ page pageEncoding="utf-8" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<style type="text/css">
    body {
        font-size: 13pt;
        width: 100%;
    }

    #frame {
        width: 80%;
        margin: 0 auto;
        background-color: #fff;
    }

    #frame2 {
        border-bottom: solid 1px #e0e0eb;
        padding-bottom: 10px;
    }

    .home {
        float: right;
    }

    table.calculation1 {
        clear: both;
        border: solid 1px #e0e0eb;
        border-collapse: collapse;
        background-color: #f5f5f0;
        width: 100%;
        font-size: 10pt;
    }

    table.calculation2 {
        border: solid 1px #e0e0eb;
        border-collapse: collapse;
        background-color: #f5f5f0;
        width: 100%;
        font-size: 10pt;
    }

    table.calculation1 th {
        border: solid 1px #e0e0eb;
        padding: 10px 0;
    }

    table.calculation1 td, table.calculation2 td {
        border: solid 1px #e0e0eb;
        text-align: center;
    }

    table.calculation2 th {
        border: solid 1px #e0e0eb;
    }

    .price {
        font-size: 20pt;
        font-weight: bold;
    }

    .li font {
        font-size: 10pt;
        color: gray;
    }

    .btn {
        border: none;
        color: white;
        padding: 5px 10px;
        font-size: 13px;
        cursor: pointer;
        border-radius: 5px;
    }

    .default {
        background-color: #fff;
        border: solid 1px gray;
        color: black;
    }

    .default:hover {
        background: #ddd;
    }

    .backBtn {
        background: #fff;
        border: solid 1px gray;
    }

    .btnfloat {
        float: left;
    }

    .btnfloat2 {
        float: right;
    }

    .clearboth {
        clear: both;
    }

    .footerbtn {
        float: right; font-weight: bolder;
        font-size: 12pt; border-radius: 3px;
    }

    #allProduct, #productClear, #footerbtn {
        padding: 11px 25px;
    }

    #allProduct {
        margin-left: 140px; background-color: #263d73; color: #fff;
        font-weight: bold; font-size: 12pt;
    }

    #productClear {
        background-color: gray;
        color: #fff;
        font-weight: bold;
        font-size: 12pt;
    }

    aa:hover {
        cursor: pointer;
    }
</style>
<body>
    <%@ include file="../common/Navibar.jsp" %>
    <div id="frame">
        <form>
            <div id="frame2">
                <span style="font-size: 16pt; font-weight: bold;">장바구니</span>
                <span class="home">홈 > 장바구니</span>
                <span></span>
            </div>
            <br/>

            <div>
                <table class="calculation1">
                    <tr>
                        <th class="aa">구매 상품</th>
                        <th class="aa">해외 상품</th>
                        <th style="width: 700px;"></th>
                    </tr>
                </table>
            </div>
            <br/>

            <%--상품 정보 테이블--%>
            <div>
                <table class="calcultation1">
                    <thead>
                    <tr>
                        <th colspan="10" style="text-align: left; padding-left: 10px;">
                            일반 상품(1)
                        </th>
                    </tr>
                    <tr>
                        <th><input type="checkbox" name="checkbox" id="check" /></th>
                        <th><span>이미지</span></th>
                        <th style="width: 550px;"><span>상품 정보</span></th>
                        <th>판매가</th>
                        <th>수량</th>
                        <th>적립금</th>
                        <th>배송 구분</th>
                        <th>배송비</th>
                        <th>합계</th>
                        <th>선택</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr style="height: 90px; background-color: #fff;">
                            <td style="text-align: center; border-right: none;">
                                <input type="checkbox" name="checkbox" />
                            </td>
                            <td style="border-left: none; border-right: none;"><img style="width: 80%" src=""> </td>
                            <td style="text-align: left; padding-left: 10px; border-left: none; font-weight: bold;">JOYMENT</td>
                            <td><span style="padding-left: 10px;">0</span>원</td>
                            <td style="width: 80px;">
                                <input type="number" style="text-align: right; margin-bottom: 5px; width: 43px;">
                                <button class="btn default" style="border-radius: 3px; size: 10px;">변경</button>
                            </td>

                            <td>-</td>
                            <td>기본 배송</td>
                            <td>2,500원<<br/>고정</td>
                            <td><span>0</span>원</td>

                            <td>
                                <button class="btn default" style="border-radius: 3px; width: 90px; margin-bottom: 3px; font-size: 11px; background-color: #e0e0eb">주문하기</button>
                                <button class="btn default" style="border-radius: 3px; width: 90px; margin-bottom: 3px; font-size: 11px;">관심 상품 등록</button>
                                <button class="btn default" style="border-radius: 3px; width: 90px; margin-bottom: 3px; font-size: 11px;">X 삭제</button>
                            </td>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr style="height: 60px;">
                            <td colspan="5" style="border-right: none; text-align: left; padding-left: 10px;"><span>[기본배송]</span></td>
                            <td colspan="5" style="border-left: none; text-align: right; padding-right: 10px;">
                                상품 금액 <span>0</span> + <span>배송비 2,500 = 합계</span>&nbsp;
                                <span style="font-weight: bold; font-size: 15pt;">0</span>
                            </td>
                        </tr>
                    </tfoot>
                </table>
                <div style="border: solid 1px #e0e0eb; padding: 15px 0;" >
                    <img src="" style="margin-left: 5px; position: relative; top: 4.5px;">
                    <span style="font-size: 10pt; color:gray;">할인 적용 금액은 주문서 작성의 결제 예정 금액에서 확인 가능합니다.</span>
                </div>
            </div>
            <div style="margin: 10px 0;">
                <span style="margin: 0 10px;" class="btnfloat">선택 상품을</span>
                <button class="btn default btnfloat" style="background-color: gray; color: #fff">X 삭제하기</button>&nbsp;
<%--                <button class="btn default btnfloat">해외배송 장바구니로 이동</button>--%>
                <button class="btn default btnfloat2">장바구니 비우기</button>
                <span class="clearboth"></span>
            </div>
            <br/><br/>

            <table class="calculation2">
                <tr>
                    <th>총 상품금액</th>
                    <th>총 배송비</th>
                    <th style="width: 750px; padding: 22px 0;"><span>결제 예정 금액</span></th>
                </tr>
                <tr style="background-color: #fff;">
                    <td style="padding: 22px 0"><span class="price">0</span>원</td>
                    <td>+<span class="price">0</span>원</td>
                    <td>=<span class="price">0</span>원</td>
                </tr>
            </table>
            <br/><br/>

            <div align="center">
                <button class="btn default" id="allProduct">전체 상품 주문</button>
                <button class="btn default backBtn" id="productClear">선택 상품 주문</button>
                <button class="btn default footerbtn" id="footerbtn">쇼핑 계속하기</button>
                <span class="clearboth"></span>
            </div>
        </form>
    </div>
</body>
</html>
