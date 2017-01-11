'use strict';

/**
 * @ngdoc function
 * @name sakilaWebapiFrontendApp.controller:CountryControllerCtrl
 * @description
 * # CountryControllerCtrl
 * Controller of the sakilaWebapiFrontendApp
 */
angular.module('sakilaWebapiFrontendApp')
  .controller('CountryCtrl', ['$scope','CountryService', function ($scope, CountryService) {
        var self = this;
        self.country={countryId:null, country:''};
        self.countries=[];

        self.fetchAllCountries = function(){
        	CountryService.fetchAllCountries()
                .then(
                     function(countries) {
                        self.countries = countries;
                     },
                    function(errResponse){
                      console.error('Error while fetching Countries');
                    }
                 );
        };

        self.createCountry = function(country){
        	CountryService.createCountry(country)
                .then(
                    self.fetchAllCountries,
                    function(errResponse){
                       console.error('Error while creating Country.');
                    }
                );
        };

        self.updateCountry = function(country){
        	CountryService.updateCountry(country)
            .then(
                    self.fetchAllCountries,
                    function(errResponse){
                       console.error('Error while updating Country.');
                    }
                );
        };

        self.deleteCountry = function(countryId){
        	CountryService.deleteCountry(countryId)
                .then(
                    self.fetchAllCountries,
                    function(errResponse){
                       console.error('Error while deleting Country.');
                    }
                );
        };

        self.fetchAllCountries();

        self.submit = function() {
            if(self.country.countryId==null){
                console.log('Saving New Country', self.country);
                self.createCountry(self.country);
            }else{
                console.log('Country updating with id ', self.country.countryId);
                console.log('Country: ', self.country);
                self.updateCountry(self.country);
            }
            self.reset();
        };

        self.edit = function(countryId){
            console.log('id to be edited', countryId);
            for(var i = 0; i < self.countries.length; i++){
                if(self.countries[i].countryId == countryId) {
                   self.country = angular.copy(self.countries[i]);
                   break;
                }
            }
        };

        self.remove = function(countryId){
            console.log('id to be deleted', countryId);
            for(var i = 0; i < self.countries.length; i++){
                if(self.countries[i].countryId == countryId) {
                   self.reset();
                   break;
                }
            }
            self.deleteCountry(countryId);
        };


        self.reset = function(){
          self.country={countryId:null, country:''};
            $scope.myForm.$setPristine(); //reset Form
        };
  }]);
