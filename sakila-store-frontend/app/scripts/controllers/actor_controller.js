'use strict';

/**
 * @ngdoc function
 * @name sakilaWebapiFrontendApp.controller:ActorControllerCtrl
 * @description
 * # ActorControllerCtrl
 * Controller of the sakilaWebapiFrontendApp
 */
angular.module('sakilaWebapiFrontendApp')
  .controller('ActorCtrl',['$scope', 'ActorService', function ($scope, ActorService) {
    $scope.actor={actorId:null,lastName:'',firstName:''};
    $scope.actors=[];

    var fetchAllActors = function(){
    ActorService.fetchAllActors()
            .then(
                 function(actors) {
                    $scope.actors = actors;
                 },
                function(errResponse){
                  console.error('Error while fetching Actors');
                }
             );
    };

    var createActor = function(actor){
        ActorService.createActor(actor)
            .then(
                fetchAllActors,
                function(errResponse){
                   console.error('Error while creating Actor.');
                }
            );
    };

    var updateActor = function(actor){
        ActorService.updateActor(actor)
        .then(
                fetchAllActors,
                function(errResponse){
                   console.error('Error while updating Actor.');
                }
            );
    };

    var deleteActor = function(actorId){
        ActorService.deleteActor(actorId)
            .then(
                fetchAllActors,
                function(errResponse){
                   console.error('Error while deleting Actor.');
                }
            );
    };

    fetchAllActors();

    $scope.submit = function() {
        if($scope.actor.actorId==null){
            console.log('Saving New Actor', $scope.actor);
            createActor($scope.actor);
        }else{
            console.log('Actor updating with id ', $scope.actor.actorId);
            console.log('Actor: ', $scope.actor);
            updateActor($scope.actor);
        }
        $scope.reset();
    };

    $scope.edit = function(actorId){
        console.log('id to be edited', actorId);
        for(var i = 0; i < $scope.actors.length; i++){
            if($scope.actors[i].actorId == actorId) {
               $scope.actor = angular.copy($scope.actors[i]);
               break;
            }
        }
    };

    $scope.remove = function(actorId){
        console.log('id to be deleted', actorId);
        for(var i = 0; i < $scope.actors.length; i++){
            if($scope.actors[i].actorId == actorId) {
               $scope.reset();
               break;
            }
        }
        deleteActor(actorId);
    };


    $scope.reset = function(){
        $scope.actor={actorId:null,lastName:'',firstName:''};
        $scope.myForm.$setPristine(); //reset Form
    };
  }]);
