'use strict';

describe('Service: filmController', function () {

  // load the service's module
  beforeEach(module('sakilaWebapiFrontendApp'));

  // instantiate service
  var filmController;
  beforeEach(inject(function (_filmController_) {
    filmController = _filmController_;
  }));

  it('should do something', function () {
    expect(!!filmController).toBe(true);
  });

});
