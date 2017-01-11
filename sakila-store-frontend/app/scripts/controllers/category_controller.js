'use strict';

/**
 * @ngdoc function
 * @name sakilaWebapiFrontendApp.controller:CategoryControllerCtrl
 * @description
 * # CategoryControllerCtrl
 * Controller of the sakilaWebapiFrontendApp
 */
angular.module('sakilaWebapiFrontendApp')
  .controller('CategoryCtrl', ['$scope','CategoryService', function ($scope, CategoryService) {
        var self = this;
        self.category={categoryId:null, name:''};
        self.categories=[];

        self.fetchAllCategories = function(){
            CategoryService.fetchAllCategories()
                .then(
                     function(categories) {
                        self.categories = categories;
                     },
                    function(errResponse){
                      console.error('Error while fetching Categories');
                    }
                 );
        };

        self.createCategory = function(category){
            CategoryService.createCategory(category)
                .then(
                    self.fetchAllCategories,
                    function(errResponse){
                       console.error('Error while creating Category.');
                    }
                );
        };

        self.updateCategory = function(category){
         CategoryService.updateCategory(category)
            .then(
                    self.fetchAllCategories,
                    function(errResponse){
                       console.error('Error while updating Category.');
                    }
                );
        };

        self.deleteCategory = function(categoryId){
            CategoryService.deleteCategory(categoryId)
                .then(
                    self.fetchAllCategories,
                    function(errResponse){
                       console.error('Error while deleting Category.');
                    }
                );
        };

        self.fetchAllCategories();

        self.submit = function() {
            if(self.category.categoryId==null){
                console.log('Saving New Category', self.category);
                self.createCategory(self.category);
            }else{
                console.log('Category updating with id ', self.category.categoryId);
                console.log('Category: ', self.category);
                self.updateCategory(self.category);
            }
            self.reset();
        };

        self.edit = function(categoryId){
            console.log('id to be edited', categoryId);
            for(var i = 0; i < self.categories.length; i++){
                if(self.categories[i].categoryId == categoryId) {
                   self.category = angular.copy(self.categories[i]);
                   break;
                }
            }
        };

        self.remove = function(categoryId){
            console.log('id to be deleted', categoryId);
            for(var i = 0; i < self.categories.length; i++){
                if(self.categories[i].categoryId == categoryId) {
                   self.reset();
                   break;
                }
            }
            self.deleteCategory(categoryId);
        };


        self.reset = function(){
          self.category={categoryId:null, name:''};
            $scope.myForm.$setPristine(); //reset Form
        };
  }]);
