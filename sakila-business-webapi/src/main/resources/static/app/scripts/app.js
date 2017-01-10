'use strict';

/**
 * @ngdoc overview
 * @name sakilaWebapiFrontendApp
 * @description
 * # sakilaWebapiFrontendApp
 *
 * Main module of the application.
 */
angular
  .module('sakilaWebapiFrontendApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/ActorManagement', {
        templateUrl: 'views/actormanagemen.html',
        controller: 'ActorCtrl',
        controllerAs: 'Actor'
      })
      .when('/CategoryManagement', {
        templateUrl: 'views/categorymanagement.html',
        controller: 'CategoryCtrl',
        controllerAs: 'Category'
      })
      .when('/FilmManagement', {
        templateUrl: 'views/filmmanagement.html',
        controller: 'FilmCtrl',
        controllerAs: 'Film'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
