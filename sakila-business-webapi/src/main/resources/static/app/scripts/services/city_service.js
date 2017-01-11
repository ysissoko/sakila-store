'use strict';

/**
 * @ngdoc service
 * @name sakilaWebapiFrontendApp.cityService
 * @description
 * # cityService
 * Service in the sakilaWebapiFrontendApp.
 */
angular.module('sakilaWebapiFrontendApp')
  .service('CityService', ['$http', '$q', function ($http, $q ) {
    var _self = this;

    _self.fetchAllCities = function() {
					return $http.get('http://localhost:8080/city/')
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while fetching cities');
										return $q.reject(errResponse);
									}
							);
			};

      _self.createCity = function(city){
		    	console.log("Saving city ", city);
					return $http.post('http://localhost:8080/city/', city)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while creating city');
										return $q.reject(errResponse);
									}
							);
		    };

        _self.updateCity = function(city){
     	    	    console.log("Updating city ", city);
      					return $http.post('http://localhost:8080/cityUpdate/', city)
      							.then(
      									function(response){
      										return response.data;
      									},
      									function(errResponse){
      										console.error('Error while updating city');
      										return $q.reject(errResponse);
      									}
      					    );
			};

      _self.deleteCity = function(cityId){
					return $http.get('http://localhost:8080/cityDelete/'+cityId)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while deleting city');
										return $q.reject(errResponse);
									}
							);
			};
  }]);
