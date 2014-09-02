(function () {
    'use strict';

    angular.module('todoApp')
        .controller('TodoController', TodoController);

    function TodoController($scope, todoResource) {
        $scope.todos = [];

        $scope.del = function (id) {
            _.remove($scope.todos, {id: id});
            todoResource.remove({
                userId: 'matt@veryrealemail.com', id: id
            });
        };

        $scope.add = function () {
            console.log('-------------adding');
            todoResource.save({
                userId: 'matt@veryrealemail.com'
            }, {
                item: $scope.newItem
            }, function (data) {
                $scope.todos.push(data);
            });
            delete $scope.newItem;
        };

        $scope.addKeypress = function (keyEvent) {
            if (keyEvent.which == 13) {
                $scope.add();
            }
        };

        function save(todo) {
            console.log('----------- Saving', todo);
            todoResource.update({
                userId: 'matt@veryrealemail.com', id: todo.id
            }, todo);
        }

        function init() {
            todoResource.get({userId: 'matt@veryrealemail.com'}, function (data) {
                $scope.todos = data.data;
            });
        }

        $scope.$watch('todos', function (newVal, oldVal) {
            //todo: creating a new todo with length
            if (newVal && oldVal && oldVal.length) {
                var hash = {};
                _.map(oldVal, function (todo) {
                    hash[todo.id] = todo
                });
                _.each(newVal, function (todo) {
                    if (todo.id && hash[todo.id] && !angular.equals(todo, hash[todo.id])) {
                        save(todo);
                    }
                });
            }
        }, true);

        init();

    }

})();
