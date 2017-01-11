'use strict';

/**
 * @ngdoc service
 * @name sakilaWebapiFrontendApp.actorService
 * @description
 * # actorService
 * Service in the sakilaWebapiFrontendApp.
 */
angular.module('sakilaWebapiFrontendApp')
  .service('InventoryService', ['$http', '$q', function ($http, $q) {
      var _self = this;
      _self.createInventoryFilm = function(filmId){
					return $http.post('http://localhost:8080/createInventoryFilm/', filmId)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while creating a film from inventory');
										return $q.reject(errResponse);
									}
							);
		    };

      _self.deleteInventoryFilm = function(filmId){
					return $http.get('http://localhost:8080/deleteInventoryFilm/'+filmId)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while deleting film from inventory');
										return $q.reject(errResponse);
									}
							);
			};
}]);
