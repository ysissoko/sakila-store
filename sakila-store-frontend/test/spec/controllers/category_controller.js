'use strict';

describe('Controller: CategoryControllerCtrl', function () {

  // load the controller's module
  beforeEach(module('sakilaWebapiFrontendApp'));

  var CategoryControllerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CategoryControllerCtrl = $controller('CategoryControllerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(CategoryControllerCtrl.awesomeThings.length).toBe(3);
  });
});
