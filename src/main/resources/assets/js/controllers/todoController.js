(function () {
    'use strict';

    angular.module('todoApp')
        .controller('TodoController', TodoController);

    function TodoController($scope, $window, $location, todoResource) {
        $scope.todos = [];

        $scope.del = function (id) {
            _.remove($scope.todos, {id: id});
            todoResource.remove({
                userId: $scope.user, id: id
            });
        };

        $scope.add = function () {
            todoResource.save({
                userId: $scope.user
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
            todoResource.update({
                userId: $scope.user, id: todo.id
            }, todo);
        }

        function init() {
            $scope.user = $location.search().user;
            todoResource.get({userId: $scope.user}, function (data) {
                $scope.todos = data.data;
            });
        }

        $scope.$watch('todos', function (newVal, oldVal) {
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
