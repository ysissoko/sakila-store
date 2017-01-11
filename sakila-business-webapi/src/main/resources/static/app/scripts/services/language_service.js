'use strict';

/**
 * @ngdoc service
 * @name sakilaWebapiFrontendApp.languageService
 * @description
 * # languageService
 * Service in the sakilaWebapiFrontendApp.
 */
angular.module('sakilaWebapiFrontendApp')
  .service('LanguageService', ['$http', '$q', function ($http, $q) {
    var _self = this;

    _self.fetchAllLanguages = function(){
      return $http.get('http://localhost:8080/language/')
            .then(
                function(response){
                  return response.data;
                },
                function(errResponse){
                  console.error('Error while fetching languages');
                  return $q.reject(errResponse);
                }
            );
    }

    _self.createLanguage = function(language){
      return $http.post('http://localhost:8080/language/', language)
            .then(
                function(response){
                  return response.data;
                },
                function(errResponse){
                  console.error('Error while creating language');
                  return $q.reject(errResponse);
                }
            );
    }

    _self.updateLanguage = function(language, languageId){
      console.log("Updating Language Id ", languageId);
					return $http.post('http://localhost:8080/languageUpdate/', language)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while updating language');
										return $q.reject(errResponse);
									}
							);
    }

    _self.deleteLanguage = function(languageId){
      return $http.get('http://localhost:8080/languageDelete/'+languageId)
            .then(
                function(response){
                  return response.data;
                },
                function(errResponse){
                  console.error('Error while deleting language');
                  return $q.reject(errResponse);
                }
            );
    }
  }]);
