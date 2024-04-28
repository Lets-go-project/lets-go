    // 페이지가 로드된 후 실행될 JavaScript 코드
    document.addEventListener("DOMContentLoaded", function () {
        // "Add to cart" 버튼들을 가져옵니다.
        var addToCartButtons = document.querySelectorAll('.btn-outline-dark');

        // 각 버튼에 클릭 이벤트를 추가합니다.
        addToCartButtons.forEach(function (button) {
            button.addEventListener('click', function () {
                // 현재 카트 수를 가져옵니다.
                var cartCount = parseInt(document.querySelector('.badge').innerText);

                // 카트 수를 1 증가시킵니다.
                cartCount++;

                // 증가된 카트 수를 화면에 업데이트합니다.
                document.querySelector('.badge').innerText = cartCount;
            });
        });
    });

    // 카트에 담긴 상품 목록을 저장하는 배열
    var cartItems = [];

    // 카트 버튼 클릭 시 모달에 카트에 담긴 상품 목록을 표시하는 함수
    document.addEventListener("DOMContentLoaded", function() {
        // 카트 버튼을 클릭했을 때 모달 창을 열도록 설정
        document.getElementById('cartButton').addEventListener('click', function() {
            var modalBody = document.getElementById('cartModalBody');
            modalBody.innerHTML = ''; // 기존 목록을 초기화

            // 카트에 담긴 상품 목록을 모달 창에 추가
            if (cartItems.length > 0) {
                cartItems.forEach(function(item) {
                    var listItem = document.createElement('div');
                    listItem.textContent = item;
                    modalBody.appendChild(listItem);
                });
            } else {
                // 카트가 비어있을 경우 메시지 표시
                var emptyCartMessage = document.createElement('div');
                emptyCartMessage.textContent = '카트에 담긴 상품이 없습니다.';
                modalBody.appendChild(emptyCartMessage);
            }
        });
    });

    // 상품을 카트에 추가하는 함수
    function addToCart(productId, productName) {
        cartItems.push(productName); // 상품을 배열에 추가

        // 카트 수 업데이트
        var cartCount = parseInt(document.querySelector('.badge').innerText);
        cartCount++;
        document.querySelector('.badge').innerText = cartCount;
    }