(function () {
    'use strict';

    angular.module('todoApp', ['ngRoute', 'ngResource'])
        .config(function ($routeProvider) {

            $routeProvider.when('/', {
                controller: 'LoginController',
                templateUrl: 'js/templates/login.html'
            });

            $routeProvider.when('/list', {
                controller: 'TodoController',
                templateUrl: 'js/templates/list.html'
            });

        });

})();
