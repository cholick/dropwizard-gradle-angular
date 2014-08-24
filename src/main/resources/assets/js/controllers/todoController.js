(function () {
    'use strict';

    angular.module('todoApp')
        .controller('TodoController', TodoController);

    function TodoController() {
        console.log('--------------------------todo controller');
    }

})();
