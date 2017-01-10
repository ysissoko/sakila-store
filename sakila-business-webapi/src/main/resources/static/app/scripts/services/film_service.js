'use strict';

/**
 * @ngdoc service
 * @name sakilaWebapiFrontendApp.filmService
 * @description
 * # filmService
 * Service in the sakilaWebapiFrontendApp.
 */
angular.module('sakilaWebapiFrontendApp')
  .service('FilmService', ['$http', '$q', function ($http, $q) {
    var _self = this;

    _self.fetchAllFilms = function(){
      return $http.get('http://localhost:8080/film/')
            .then(
                function(response){
                  return response.data;
                },
                function(errResponse){
                  console.error('Error while fetching films');
                  return $q.reject(errResponse);
                }
            );
    }

    _self.createFilm = function(film){
      return $http.post('http://localhost:8080/film/', film)
            .then(
                function(response){
                  return response.data;
                },
                function(errResponse){
                  console.error('Error while creating film');
                  return $q.reject(errResponse);
                }
            );
    }

    _self.updateFilm = function(film, filmId){
      console.log("Updating Film Id ", filmId);
					return $http.post('http://localhost:8080/filmUpdate/', film)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while updating film');
										return $q.reject(errResponse);
									}
							);
    }

    _self.deleteFilm = function(filmId){
      return $http.get('http://localhost:8080/filmDelete/'+filmId)
            .then(
                function(response){
                  return response.data;
                },
                function(errResponse){
                  console.error('Error while deleting film');
                  return $q.reject(errResponse);
                }
            );
    }
  }]);
