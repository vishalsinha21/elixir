'use strict';

/* Controllers */

var brewControllers = angular.module('brewControllers', []);

brewControllers.controller('TopBrewListCtrl', ['$scope', '$http', function ($scope, $http) {

  $http.get('brew/best').success(function (data) {
    $scope.brews = data;
  });

  $http.get('brew/recent').success(function (data) {
    $scope.reviews = data;
  });
  
}]);

