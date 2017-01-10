'use strict';

App.controller('FilmController', ['$scope', 'FilmService', function($scope, FilmService) {
          var self = this;
          self.film={filmId:null,title:'',description:'',releaseYear: new Date(), languageId: null, originalLanguageId: null, rentalDuration: 0, rentalRate: 0.0, length: 0, replacementCost: 0.0, rating: 0.0, specialFeatures: '', lastUpdate: new Date(), actors: [], categories: [], inventories: [] };
          self.films=[];
              
          self.fetchAllFilms = function(){
              FilmService.fetchAllFilms()
                  .then(
      					       function(films) {
      						        self.films = films;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Films');
            					}
      			       );
          };
           
          self.createFilm = function(film){
              FilmService.createFilm(film)
		              .then(
                      self.fetchAllFilms, 
				              function(errResponse){
					               console.error('Error while creating Film.');
				              }	
                  );
          };

         self.updateFilm = function(film){
              FilmService.updateFilm(film)
              .then(
                      self.fetchAllFilms, 
				              function(errResponse){
					               console.error('Error while updating Film.');
				              }	
                  );
          };

         self.deleteFilm = function(filmId){
              FilmService.deleteFilm(filmId)
		              .then(
				              self.fetchAllFilms, 
				              function(errResponse){
					               console.error('Error while deleting Film.');
				              }	
                  );
          };

          self.fetchAllFilms();

          self.submit = function() {
              if(self.film.filmId==null){
                  console.log('Saving New Film', self.film);    
                  self.createFilm(self.film);
              }else{
                  console.log('Film updating with id ', self.film.filmId);
                  console.log('Film: ', self.film);
                  self.updateFilm(self.film);
              }
              self.reset();
          };
              
          self.edit = function(filmId){
              console.log('id to be edited', filmId);
              for(var i = 0; i < self.films.length; i++){
                  if(self.films[i].filmId == filmId) {
                     self.film = angular.copy(self.films[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(filmId){
              console.log('id to be deleted', filmId);
              for(var i = 0; i < self.films.length; i++){
                  if(self.films[i].filmId == filmId) {
                     self.reset();
                     break;
                  }
              }
              self.deleteFilm(filmId);
          };

          
          self.reset = function(){
              self.film={filmId:null,title:'',description:'',releaseYear: new Date(), languageId: null, originalLanguageId: null, rentalDuration: 0, rentalRate: 0.0, length: 0, replacementCost: 0.0, rating: 0.0, specialFeatures: '', lastUpdate: new Date(), actors: [], categories: [], inventories: [] };
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
