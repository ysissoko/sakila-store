'use strict';

/**
 * @ngdoc function
 * @name sakilaWebapiFrontendApp.controller:CityControllerCtrl
 * @description
 * # CityControllerCtrl
 * Controller of the sakilaWebapiFrontendApp
 */
angular.module('sakilaWebapiFrontendApp')
  .controller('CityCtrl', ['$scope','CityService','CountryService', function ($scope, CityService, CountryService) {
        var self = this;
        self.city={cityId:null, city:'', countryId:null};
        self.cities=[];
        $scope.countries = [];

        CountryService.fetchAllCountries().then(function(countries){
          $scope.countries = countries;
        }, function(errResponse){
          console.error("Error while fetching countries");
        });

        self.fetchAllCities = function(){
        	CityService.fetchAllCities()
                .then(
                     function(cities) {
                        self.cities = cities;
                     },
                    function(errResponse){
                      console.error('Error while fetching Cities');
                    }
                 );
        };

        self.createCity = function(city){
        	CityService.createCity(city)
                .then(
                    self.fetchAllCities,
                    function(errResponse){
                       console.error('Error while creating City.');
                    }
                );
        };

        self.updateCity = function(city){
        	CityService.updateCity(city)
            .then(
                    self.fetchAllCities,
                    function(errResponse){
                       console.error('Error while updating City.');
                    }
                );
        };

        self.deleteCity = function(cityId){
        	CityService.deleteCity(cityId)
                .then(
                    self.fetchAllCities,
                    function(errResponse){
                       console.error('Error while deleting City.');
                    }
                );
        };

        self.fetchAllCities();

        self.submit = function() {
            if(self.city.cityId==null){
                console.log('Saving New City', self.city);
                self.createCity(self.city);
            }else{
                console.log('City updating with id ', self.city.cityId);
                console.log('City: ', self.city);
                self.updateCity(self.city);
            }
            self.reset();
        };

        self.edit = function(cityId){
            console.log('id to be edited', cityId);
            for(var i = 0; i < self.cities.length; i++){
                if(self.cities[i].cityId == cityId) {
                   self.city = angular.copy(self.cities[i]);
                   break;
                }
            }
        };

        self.remove = function(cityId){
            console.log('id to be deleted', cityId);
            for(var i = 0; i < self.cities.length; i++){
                if(self.cities[i].cityId == cityId) {
                   self.reset();
                   break;
                }
            }
            self.deleteCity(cityId);
        };


        self.reset = function(){
          self.city={cityId:null, city:'', countryId:null};
            $scope.myForm.$setPristine(); //reset Form
        };
  }]);
