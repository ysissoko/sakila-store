'use strict';

/**
 * @ngdoc service
 * @name sakilaWebapiFrontendApp.actorService
 * @description
 * # actorService
 * Service in the sakilaWebapiFrontendApp.
 */
angular.module('sakilaWebapiFrontendApp')
  .service('ActorService', ['$http', '$q', function ($http, $q) {
    var _self = this;
    _self.fetchAllActors = function() {
					return $http.get('http://localhost:8080/actor/')
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while fetching actors');
										return $q.reject(errResponse);
									}
							);
			};

      _self.createActor = function(actor){
					return $http.post('http://localhost:8080/actor/', actor)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while creating actor');
										return $q.reject(errResponse);
									}
							);
		    };

        _self.updateActor = function(actor, actorId){
     	    	    console.log("XXX", actor);
					return $http.post('http://localhost:8080/actorUpdate/', actor)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while updating actor');
										return $q.reject(errResponse);
									}
							);
			};

      _self.deleteActor = function(actorId){
					return $http.get('http://localhost:8080/actorDelete/'+actorId)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while deleting actor');
										return $q.reject(errResponse);
									}
							);
			};
}]);
