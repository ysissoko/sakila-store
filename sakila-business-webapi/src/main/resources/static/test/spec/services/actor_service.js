'use strict';

describe('Service: actorService', function () {

  // load the service's module
  beforeEach(module('sakilaWebapiFrontendApp'));

  // instantiate service
  var actorService;
  beforeEach(inject(function (_actorService_) {
    actorService = _actorService_;
  }));

  it('should do something', function () {
    expect(!!actorService).toBe(true);
  });

});
