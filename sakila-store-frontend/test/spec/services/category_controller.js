'use strict';

describe('Service: categoryController', function () {

  // load the service's module
  beforeEach(module('sakilaWebapiFrontendApp'));

  // instantiate service
  var categoryController;
  beforeEach(inject(function (_categoryController_) {
    categoryController = _categoryController_;
  }));

  it('should do something', function () {
    expect(!!categoryController).toBe(true);
  });

});
