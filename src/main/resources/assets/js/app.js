(function () {
    'use strict';

    angular.module('todoApp', ['ngRoute'])
        .config(function ($routeProvider) {

            console.log('--------------hey');

            $routeProvider.when('/', {
                controller: 'TodoController',
                templateUrl: 'js/templates/test.html'
            });

        });

})();
