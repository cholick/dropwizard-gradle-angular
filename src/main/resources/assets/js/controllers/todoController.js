(function () {
    'use strict';

    angular.module('todoApp')
        .controller('TodoController', TodoController);

    function TodoController($scope, todoResource) {
        $scope.todos = [];

        todoResource.get({userId: 'matt@veryrealemail.com'}, function (data) {
            $scope.todos = data.data;
        });

        $scope.yo = function (item, id) {
            console.log('---------------------yo');
            console.log(item);
            console.log(id);
            console.log('---------------------yo');
        };

        $scope.updateItem = function (id, item) {
            var todo = _.find($scope.todos, {id: id});
        };

        $scope.save = function (id, todo) {
            todoResource.update({
                userId: 'matt@veryrealemail.com', id: id
            }, todo);
        };

        $scope.del = function (id) {
            _.remove($scope.todos, {id: id});
            todoResource.remove({
                userId: 'matt@veryrealemail.com', id: id
            });
        };

        $scope.$watch('todos', function (newVal, oldVal) {
            if (newVal && oldVal && oldVal.length) {
                var hash = {};
                _.map(oldVal, function (todo) {
                    hash[todo.id] = todo
                });
                _.each(newVal, function (todo) {
                    if(!angular.equals(todo, hash[todo.id])) {
                        console.log('vs', todo, hash[todo.id]);
                    }
                });
            }
        }, true);

    }

})();
