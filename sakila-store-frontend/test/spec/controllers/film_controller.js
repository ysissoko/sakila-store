'use strict';

describe('Controller: FilmControllerCtrl', function () {

  // load the controller's module
  beforeEach(module('sakilaWebapiFrontendApp'));

  var FilmControllerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FilmControllerCtrl = $controller('FilmControllerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(FilmControllerCtrl.awesomeThings.length).toBe(3);
  });
});
