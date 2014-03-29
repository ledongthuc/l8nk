/**
 * @author Thuc
 */
var l8nkApp = angular.module('l8nkApp', []);

l8nkApp.controller('LinkListController', function($scope, $http) {
    
    $http.get("app/links.json").success(function(data) {
        $scope.phones = data;
    });
    
    $scope.generateShortLink = function() {
        jQuery("#longLinkInput").attr("disabled", "true");
        jQuery("#longLinkButton").button('loading');
        
        $http.get("")
        
        jQuery("#longLinkInput").removeAttr("disabled");
        jQuery("#longLinkButton").button('reset');
        
    };
    
    
});
