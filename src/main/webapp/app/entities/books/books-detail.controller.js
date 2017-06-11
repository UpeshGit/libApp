(function() {
    'use strict';

    angular
        .module('libApp')
        .controller('BooksDetailController', BooksDetailController);

    BooksDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Books', 'Library'];

    function BooksDetailController($scope, $rootScope, $stateParams, previousState, entity, Books, Library) {
        var vm = this;

        vm.books = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('libApp:booksUpdate', function(event, result) {
            vm.books = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
