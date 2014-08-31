(function () {
    'use strict';

    angular.module('todoApp', ['ngRoute', 'ngResource'])
        .config(function ($routeProvider) {

            $routeProvider.when('/', {
                controller: 'TodoController',
                templateUrl: 'js/templates/list.html'
            });

        });

})();
