restoApp.factory('restoService', ['$resource', 'apiUrl', function ($resource, apiUrl) {
    return $resource(
        apiUrl + 'api/restaurants/nearby',
        null,
        {
            'query': {
                method: 'GET',
                isArray: true
            }
        })
}]);