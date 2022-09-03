angular.module('market-front').controller('storeController', function ($scope, $http, $location, $localStorage) {


    const contextPath = 'http://localhost:8182/front/api/v1';



    $scope.loadProducts = function () {
        $http({
            url: contextPath + '/products',
            method: 'GET'
        }).then(function (response) {
            $scope.productData = response;

        })
    }

    $scope.deleteProduct = function (id) {
        $http.delete(contextPath + '/products/' + id)
            .then(function successCallback(response) {
                $scope.loadProducts();
            }, function failCallback(response) {
                alert(response.data.message)
            })
    };

    $scope.navToEditProductPage = function (productId) {
        $location.path('/edit_product/' + productId);
    }


    $scope.loadProducts();
});
