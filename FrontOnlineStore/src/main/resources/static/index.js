(function () {
    angular
        .module('market-front', ['ngRoute', 'ngStorage'])
        .config(config);


    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'mainPage/mainPage.html',
                controller: 'mainPageController'
            })
            .when('/store', {
                templateUrl: 'store/store.html',
                controller: 'storeController'
            })
            .when('/create', {
                templateUrl: 'create/create.html',
                controller: 'createController'
            })
            .when('/edit_product/:productId', {
                templateUrl: 'edit_product/edit_product.html',
                controller: 'editProductController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }
})();


angular.module('market-front').controller('indexController', function ($rootScope, $scope, $http,$localStorage) {

    const contextPath = 'http://localhost:8181/market/api/v1';



});
