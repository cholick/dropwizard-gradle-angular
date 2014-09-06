(function () {
    'use strict';

    describe('TodoController', function () {

        var scope, location, httpBackend, controller;

        beforeEach(module('todoApp'));

        beforeEach(inject(function ($rootScope, $controller, $httpBackend) {
            httpBackend = $httpBackend;
            scope = $rootScope.$new();

            httpBackend.whenGET('/api/todo/asdf@asdf.com').respond(
                {data: [
                    {id: 4, item: 'Buy milk', completed: false},
                    {id: 5, item: 'Mail check', completed: true}
                ]}
            );

            location = jasmine.createSpyObj('search', ['search']);
            location.search.and.returnValue({user: 'asdf@asdf.com'});

            controller = $controller('TodoController', {
                $scope: scope,
                $location: location
            });

            httpBackend.flush();
            scope.$digest();
        }));

        afterEach(function () {
            httpBackend.verifyNoOutstandingExpectation();
            httpBackend.verifyNoOutstandingRequest();
        });

        it('is defined', function () {
            expect(controller).toBeDefined();
        });

        it('puts user param in scope', function() {
            expect(scope.user).toEqual('asdf@asdf.com');
        });

        it('puts todo resources into scope', function () {
            expect(scope.todos).toBeDefined();
            expect(scope.todos).toEqual([
                {id: 4, item: 'Buy milk', completed: false},
                {id: 5, item: 'Mail check', completed: true}
            ]);
        });

        it('del removes item', function () {
            httpBackend.expectDELETE('/api/todo/asdf@asdf.com/5').respond({});

            scope.del(5);
            httpBackend.flush();

            expect(scope.todos).toEqual([
                {id: 4, item: 'Buy milk', completed: false}
            ]);
        });

        it('add saves resource', function () {
            expect(scope.todos.length).toEqual(2);

            scope.newItem = 'Fill car with gas';

            httpBackend.expectPOST('/api/todo/asdf@asdf.com').respond(
                {item: 'Fill car with gas. Server.', completed: false}
            );

            scope.add();

            httpBackend.flush();
            scope.$digest();

            expect(scope.newItem).toBeUndefined();
            expect(scope.todos.length).toEqual(3);
            expect(scope.todos[2].item).toEqual('Fill car with gas. Server.');
        });

        it('change for todos in scope triggers save', function () {
            scope.todos[1].item = 'Mail mortgage check';

            httpBackend.expectPUT('/api/todo/asdf@asdf.com/5',
                {id: 5, item: 'Mail mortgage check', completed: true}
            ).respond({});

            httpBackend.flush();
            scope.$digest();

            expect(scope.todos[1].item).toEqual('Mail mortgage check');
        });

    });

})();
