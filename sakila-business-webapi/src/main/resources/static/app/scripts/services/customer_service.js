/**
 * 
 */

App.factory('CustomerService', ['$http', '$q', function($http, $q){
	return {
		getCustomer: function(){
			return $http.get('http://localhost:8080/Customers/').then(
					function(response){
						console.log("Success du service: getCustomer.");
						return response.data;
					}, function(err){
						console.log("Erreur du service createCustomer.");
						return $q.reject(err);
					}
			)
		},
		createCustomer: function(customer){
			return $http.post('http://localhost:8080/createCustomer/', customer).then(
					function(response){
						return response.data;
					}, function(err){
						console.log("Erreur du service createCustomer.");
						return $q.reject(err);
					}
			)
		},
		updateCustomer: function(customer){
			return $http.post('http://localhost:8080/updateCustomer/', customer).then(
					function(response){
						return response.data;
					}, function(err){
						console.log("Erreur du service updateCustomer.");
						return $q.reject(err);
					}
			)
		}
	}
	
}]);