(function() {
    'use strict';

    angular
        .module('libApp')
        .controller('BooksController', BooksController);

    BooksController.$inject = ['Books'];

    function BooksController(Books) {

        var vm = this;

        vm.books = [];

        loadAll();

        function loadAll() {
            Books.query(function(result) {
                vm.books = result;
                vm.searchQuery = null;
            });
        }
    }
})();
