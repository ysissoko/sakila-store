'use strict';

describe('Controller: ActorControllerCtrl', function () {

  // load the controller's module
  beforeEach(module('sakilaWebapiFrontendApp'));

  var ActorControllerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ActorControllerCtrl = $controller('ActorControllerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ActorControllerCtrl.awesomeThings.length).toBe(3);
  });
});
