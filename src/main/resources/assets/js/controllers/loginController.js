(function () {
    'use strict';

    angular.module('todoApp')
        .controller('LoginController', LoginController);

    function LoginController($scope, $location) {

        $scope.login = function () {
            $location.search('user', $scope.user).path('/list');
        }

    }

})();
