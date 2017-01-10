'use strict';

App.factory('CategoryService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllCategories: function() {
					return $http.get('http://localhost:8080/category/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching categories');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createCategory: function(category){
		    		console.log("Saving category ", category);
					return $http.post('http://localhost:8080/category/', category)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating category');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateCategory: function(category){
     	    	    console.log("Updating category ", category);
					return $http.post('http://localhost:8080/categoryUpdate/', category)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating category');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteCategory: function(categoryId){
					return $http.get('http://localhost:8080/categoryDelete/'+categoryId)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting category');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
