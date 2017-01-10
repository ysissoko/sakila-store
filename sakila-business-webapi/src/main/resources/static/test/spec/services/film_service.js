'use strict';

describe('Service: filmService', function () {

  // load the service's module
  beforeEach(module('sakilaWebapiFrontendApp'));

  // instantiate service
  var filmService;
  beforeEach(inject(function (_filmService_) {
    filmService = _filmService_;
  }));

  it('should do something', function () {
    expect(!!filmService).toBe(true);
  });

});
