'use strict';

/**
 * @ngdoc function
 * @name sakilaWebapiFrontendApp.controller:InventoryControllerCtrl
 * @description
 * # InventoryControllerCtrl
 * Controller of the sakilaWebapiFrontendApp
 */
angular.module('sakilaWebapiFrontendApp')
  .controller('InventoryCtrl', ['$scope', 'InventoryService', 'FilmService', function ($scope, InventoryService, FilmService) {
       var self = this;
	   	self.film = {
	   			filmId:null,
	   			title:'',
	   			description:'',
	   			releaseYear:'',
	   			rentalDuration:'',
	   			rentalRate:'',
	   			lenght:'',
	   			language:null,
	   			features:''
	   		};
	   		self.inventory = {
	   			inventory_id: '',
	   			film_id: '',
	   			storeId: '',
	   			last_update:''
	   	};
   		self.inventories = [];
   		self.films= [];

        self.fetchAllFilms= function(){
            FilmService.fetchAllFilms()
                .then(
    					       function(films) {
    						        self.films = films;
    					       },
          					function(errResponse){
          						console.error('Error while fetching Languages');
          					}
    			       );
        };

       self.createInventory = function(inventory){
    	    var map = {filmId: inventory['filmId'], storeId: $cookieStore.get('store_id')};
       		InventoryService.createInventory(map).then(
       				self.setQuantity,
       				function(err){
       					console.log("Error: controlle failed to greate a inventory");
       				}
       		)
       };

      self.deleteInventory = function(inventoryId){
    	  InventoryService.deleteInventory(inventoryId)
	              .then(
			              self.fetchAllInventorys,
			              function(errResponse){
				               console.error('Error while deleting Inventory.');
			              }
               );
       };

   	self.fetchAllFilms();

  }]);
