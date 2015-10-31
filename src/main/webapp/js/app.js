'use strict';

/* App Module */

var brewApp = angular.module('brewApp', [
  'ngRoute',
  'brewControllers'
]);

brewApp.config(['$routeProvider',
  function ($routeProvider) {
    $routeProvider.
        when('/brew', {
          templateUrl: 'main.html',
          controller: 'TopBrewListCtrl'
        }).
        otherwise({
          redirectTo: '/brew'
        });
  }]);
