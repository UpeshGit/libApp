(function() {
    'use strict';

    angular
        .module('libApp')
        .controller('LibraryDialogController', LibraryDialogController);

    LibraryDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Library', 'Books'];

    function LibraryDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Library, Books) {
        var vm = this;

        vm.library = entity;
        vm.clear = clear;
        vm.save = save;
        vm.books = Books.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.library.id !== null) {
                Library.update(vm.library, onSaveSuccess, onSaveError);
            } else {
                Library.save(vm.library, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('libApp:libraryUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
