(function () {
    'use strict';

    describe('LoginController', function () {

        var scope, location, pathSpy, httpBackend, controller;

        beforeEach(module('todoApp'));

        beforeEach(inject(function ($rootScope, $httpBackend, $controller) {
            httpBackend = $httpBackend;
            scope = $rootScope.$new();

            pathSpy = jasmine.createSpy('path');
            location = jasmine.createSpyObj('search', ['search']);
            location.search.and.returnValue({
                path: pathSpy
            });

            controller = $controller('LoginController', {
                $scope: scope,
                $location: location
            });

            scope.$digest();
        }));

        afterEach(function () {
            httpBackend.verifyNoOutstandingExpectation();
            httpBackend.verifyNoOutstandingRequest();
        });

        it('is defined', function () {
            expect(controller).toBeDefined();
        });

        it('login navigates to list', function () {
            scope.user = 'asdf@asdf.com';
            scope.login();

            expect(location.search).toHaveBeenCalledWith('user', 'asdf@asdf.com');
            expect(pathSpy).toHaveBeenCalledWith('/list')
        });

    });

})();
