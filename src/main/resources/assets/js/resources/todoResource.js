(function () {
    'use strict';

    angular.module('todoApp')
        .factory('todoResource', todoResource);

    function todoResource($resource) {
        return $resource('/api/todo/:userId/:id', null, {
            'update': {
                method: 'PUT'
            }
        });
    }

})();
