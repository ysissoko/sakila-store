'use strict';

describe('Service: actorController', function () {

  // load the service's module
  beforeEach(module('sakilaWebapiFrontendApp'));

  // instantiate service
  var actorController;
  beforeEach(inject(function (_actorController_) {
    actorController = _actorController_;
  }));

  it('should do something', function () {
    expect(!!actorController).toBe(true);
  });

});
