(function() {
    'use strict';

    angular
        .module('libApp')
        .controller('LibraryDetailController', LibraryDetailController);

    LibraryDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Library', 'Books'];

    function LibraryDetailController($scope, $rootScope, $stateParams, previousState, entity, Library, Books) {
        var vm = this;

        vm.library = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('libApp:libraryUpdate', function(event, result) {
            vm.library = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
