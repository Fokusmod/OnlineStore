angular.module('market-front').controller('storeController', function ($scope, $http, $location) {

    const contextPath = 'http://localhost:8181/market/api/v1';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.productData = response.data;
            })
    }

    $scope.addToCart = function (id) {
        $http.post(contextPath + '/product/' + id)
            .then(function successCallback(response) {
                alert("Товар успешно добавлен в корзину")
            }, function failCallback(response) {
                console.log(response);
            })

    }


    $scope.loadProducts();
});