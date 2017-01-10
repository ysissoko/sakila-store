'use strict';

describe('Controller: ActorCtrl', function () {

  // load the controller's module
  beforeEach(module('sakilaWebapiFrontendApp'));

  var ActorCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ActorCtrl = $controller('ActorCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ActorCtrl.awesomeThings.length).toBe(3);
  });
});
