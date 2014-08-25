(function () {
    'use strict';

//    asdf;

    angular.module('todoApp', ['ngRoute', 'ngResource'])
        .config(function ($routeProvider) {

            console.log('--------------hey');

            $routeProvider.when('/', {
                controller: 'TodoController',
                templateUrl: 'js/templates/test.html'
            });

        });

})();
