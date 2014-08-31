(function () {
    'use strict';

    angular.module('todoApp')
        .controller('TodoController', TodoController);

    function TodoController($scope, todoResource) {
        $scope.todos = [];

        todoResource.get({userId: 'matt@veryrealemail.com'}, function (data) {
            $scope.todos = data.data;
        });

        $scope.yo = function(id) {
            console.log(id);
        };

        $scope.del = function(id) {
            console.log("--------------removing", id);
            $scope.todos = _.remove($scope.todos, {id: id});
//            todoResource.update({
//                userId: 'matt@veryrealemail.com', id: id
//            });
        };

        $scope.save = function (id, todo) {
            console.log(id);
            todoResource.update({
                userId: 'matt@veryrealemail.com', id: id
            }, todo);
        };

    }

})();
