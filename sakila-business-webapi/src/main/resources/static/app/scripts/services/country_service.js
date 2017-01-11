'use strict';

/**
 * @ngdoc service
 * @name sakilaWebapiFrontendApp.countryService
 * @description
 * # countryService
 * Service in the sakilaWebapiFrontendApp.
 */
angular.module('sakilaWebapiFrontendApp')
  .service('CountryService', ['$http', '$q', function ($http, $q ) {
    var _self = this;

    _self.fetchAllCountries = function() {
					return $http.get('http://localhost:8080/country/')
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while fetching countries');
										return $q.reject(errResponse);
									}
							);
			};

      _self.createCountry = function(country){
		    	console.log("Saving country ", country);
					return $http.post('http://localhost:8080/country/', country)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while creating country');
										return $q.reject(errResponse);
									}
							);
		    };

        _self.updateCountry = function(country){
     	    	    console.log("Updating country ", country);
      					return $http.post('http://localhost:8080/countryUpdate/', country)
      							.then(
      									function(response){
      										return response.data;
      									},
      									function(errResponse){
      										console.error('Error while updating country');
      										return $q.reject(errResponse);
      									}
      					    );
			};

      _self.deleteCountry = function(countryId){
					return $http.get('http://localhost:8080/countryDelete/'+countryId)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while deleting country');
										return $q.reject(errResponse);
									}
							);
			};
  }]);
