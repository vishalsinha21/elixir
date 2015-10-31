'use strict';

/* Controllers */

var brewApp = angular.module('brewApp', []);

brewApp.controller('TopBrewListCtrl', ['$scope', '$http', function($scope, $http) {

  $http.get('brew/best').success(function(data) {
    $scope.brews = data;
  });

}]);
