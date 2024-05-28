<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Let's Go Market</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <style>
        .card-img-top {
            width: auto;
            height: 200px;
        }

        .cart {
            padding: 10px;
            position: fixed;
            right: 10px;
            bottom: 10px;
            z-index: 1000;
        }
    </style>
</head>
<body>
    <div th:replace="~{common/Navibar :: body}"></div>

    <!-- 장바구니 -->
    <form class="cart" action="market/cart">
        <button class="cart-detail btn btn-outline-dark bg-white" type="submit">
            <i class="bi-cart-fill me-1"></i>
            장바구니
            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
        </button>
    </form>

    <!-- Header -->
    <header class="py-5" style="background-color: #BDCDD6">
        <div class="container px-4 px-lg-5 my-5">
            <div class="text-center text-white">
                <h1 class="display-4 fw-bolder">Let's Go Market</h1>
                <p class="lead fw-normal text-white-50 mb-0">수영 물품 중고 마켓</p>
            </div>
        </div>
    </header>

    <!-- Section -->
    <section class="py-5">
        <div class="container px-4 px-lg-5 mt-5">
            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                <div class="col mb-5" th:each="product: ${productList}">
                    <div class="card h-100">
                        <img class="card-img-top" th:src="@{product.productImg}" alt="..."/>
                        <div class="card-body p-4">
                            <div class="text-center">
                                <h5 class="fw-bolder" th:text="${product.productName}">Product Name</h5>
                                <span th:text="${product.productSellPrice}">Product Price</span>
                            </div>
                        </div>
<%--
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center"><a class="btn btn-outline-dark mt-auto" th:href="@{/market/detail(id=${product.productId})}">상세 페이지</a></div>
                        </div>
--%>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="py-5" style="background-color: #BDCDD6">
        <div class="container"><p class="m-0 text-center text-white">Software System &copy; 240105 marin-girls</p></div>
    </footer>
</body>
</html>
