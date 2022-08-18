angular.module('market-front').controller('cartController', function ($scope, $http, $location) {

    const contextPath = 'http://localhost:8181/market/api/v1';


    $scope.loadProductFromCart = function () {
        $http.get(contextPath + '/cart')
            .then(function (response){
                $scope.products = response.data;
                console.log(response)
            })
    }

    $scope.loadProductFromCart();

});