restoApp.controller('restoController', ['$scope', 'restoService', 'cordovaReady', function ($scope, restoService, cordovaReady) {

    $scope.restaurants = [];
    $scope.loading = true;
    $scope.unableToGetPosition = false;
    $scope.unableToGetRestaurants = false;

    $scope.loadRestaurantsFromPosition = function (position) {
        $scope.unableToGetPosition = false;
        restoService.query({
            latitude: position.coords.latitude,
            longitude: position.coords.longitude
        }).$promise.then(
            function (result) {
                $scope.loading = false;
                $scope.unableToGetRestaurants = false;
                $scope.restaurants = result;
            },
            function () {
                $scope.loading = false;
                $scope.unableToGetRestaurants = true;
            });
    };

    $scope.handleErrorWhileGettingPosition = function () {
        $scope.loading = false;
        $scope.unableToGetPosition = true
    };

    $scope.loadRestaurants = function () {
        $scope.restaurants = [];
        $scope.loading = true;
        navigator.geolocation.getCurrentPosition($scope.loadRestaurantsFromPosition, $scope.handleErrorWhileGettingPosition);
    };

    $scope.getBackgroundCardStyle = function (restaurant) {
        if (restaurant.photoReference !== undefined
            && restaurant.photoReference !== null
            && restaurant.photoReference !== "") {
            return "background-image: url('data:" + restaurant.photoType + ";base64," + restaurant.photo + "');";
        } else {
            return "";
        }
    };

    $scope.getIconCardStyle = function (restaurant) {
        return "background-image: url('" + restaurant.icon + "')";
    };

    cordovaReady($scope.loadRestaurants());

}]);