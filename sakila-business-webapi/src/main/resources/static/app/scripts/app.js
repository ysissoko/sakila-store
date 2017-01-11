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
    'ui.router',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state({
        name: 'home',
        url: '/',
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .state({
        name: 'actors',
        url: '/ActorManagement',
        templateUrl: 'views/actormanagement.html',
        controller: 'ActorCtrl',
        controllerAs: 'ctrl'
      })
      .state({
        name: 'categories',
        url: '/CategoryManagement',
        templateUrl: 'views/categorymanagement.html',
        controller: 'CategoryCtrl',
        controllerAs: 'ctrl'
      })
      .state({
        name: 'films',
        url: '/FilmManagement',
        templateUrl: 'views/filmmanagement.html',
        controller: 'FilmCtrl',
        controllerAs: 'ctrl'
      })
    .state({
        name: 'languages',
        url: '/LanguageManagement',
        templateUrl: 'views/languagemanagement.html',
        controller: 'LanguageCtrl',
        controllerAs: 'ctrl'
      });

      $urlRouterProvider.otherwise('/');
  });
