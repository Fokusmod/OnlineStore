angular.module('market-front').controller('registrationController', function ($scope, $http, $location) {

    const contextPath = 'http://localhost:8181/market/api/v1';

    $scope.regRequest = function () {
        $http.post(contextPath + '/registration', $scope.new_user)
            .then(function successCallback(response) {
                $scope.new_user = null;
                alert(response.data.messages)
                $location.path('/');
            }, function failCallback(response) {
                console.log(response.data.messages)
                alert(response.data.messages)
            })
    };

    $scope.tryToRegistration = function () {
        if ($scope.new_user.username == null || $scope.new_user.password == null || $scope.new_user.email == null) {
            alert("Поля обязательны для заполнения")
        } else {
            $scope.regRequest();
        }
    }


});
