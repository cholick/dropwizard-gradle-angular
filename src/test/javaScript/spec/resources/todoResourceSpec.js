(function () {
    'use strict';

    describe('todoResource', function () {

        var httpBackend;
        var todoResource;

        beforeEach(module('todoApp'));

        beforeEach(inject(function ($injector, $httpBackend) {
            httpBackend = $httpBackend;
            todoResource = $injector.get('todoResource');
        }));

        afterEach(function () {
            httpBackend.verifyNoOutstandingExpectation();
            httpBackend.verifyNoOutstandingRequest();
        });

        it('is defined', function () {
            expect(todoResource).toBeDefined();
        });

        it('get response', function () {
            httpBackend.expect('GET', '/api/todo').respond({data: [
                {}
            ]});
            var response = todoResource.get();
            httpBackend.flush();

            expect(response.data).toBeDefined();
        });

    });

})();
