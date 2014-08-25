(function () {
    'use strict';

    describe('TodoController', function () {

        var scope, controller;

        beforeEach(module('todoApp'));

        beforeEach(inject(function ($rootScope, $controller) {
            scope = $rootScope.$new();

            controller = $controller('TodoController', {
                $scope: scope
            });
            scope.$digest();
        }));

        it('is defined', function () {
            expect(controller).toBeDefined();
        });

    });

})();
