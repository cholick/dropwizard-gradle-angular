(function () {
    'use strict';

    angular.module('todoApp')
        .directive('cellEdit', cellEdit);

    var viewTemplate = '<span ng-bind="cellEditValue" ng-click="enableEdit()" class="editable"></span>';
    var editTemplate = '<input ng-model="cellEditValue" ng-blur="disableEdit()" ng-keypress="editKeypress($event)" class="form-control"/>';

    function cellEdit() {
        return {
            restrict: 'A',
            transclude: false,
            replace: false,
            scope: {
                cellEditValue: '='
            },
            template: viewTemplate,
            controller: function ($scope, $element, $compile) {
                $scope.enableEdit = function () {
                    $element.html($compile(editTemplate)($scope));
                    $element.find('input').focus();
                };

                $scope.disableEdit = function () {
                    $element.html($compile(viewTemplate)($scope));
                };

                $scope.editKeypress = function (keyEvent) {
                    if (keyEvent.which == 13) {
                        $scope.disableEdit();
                    }
                };
            }
        }
    }

})();
