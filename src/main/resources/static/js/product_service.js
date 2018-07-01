// ProductService: Permite consumir los servicios REST del Backend
// scope: Alcance de variables 
// hhtp: libreria HTPP consulta de servicios REST

'use strict';
 
angular.module('ProductApp').factory('ProductService', ['$http', '$q', function($http, $q){
    	
	var factory = {
        growProduct: growProduct,
        importProduct: importProduct,
        createProduct:createProduct
    };
	 
	return factory;
	
	// Permite consultar cantidad de productos cultivados - protocolo HTTP - GET
	function growProduct() {
        var deferred = $q.defer();
        $http.get("/grow")
            .then(function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error consultando servicio REST - cultivar productos');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
	
	// Permite consultar cantidad de productos importados - protocolo HTTP - GET
	function importProduct() {
        var deferred = $q.defer();
        $http.get("/import")
            .then(function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error consultando servicio REST - importar productos');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

	// Permite enviar formulario productos cultivados - protocolo HTTP - POST
	function createProduct(data) {
        var deferred = $q.defer();
        $http.post("/create", data)
            .then(function (response) {
            	alert(response);
                deferred.resolve(response.data);
            },
            function(errResponse){
            	alert(errResponse);
                console.error('Error consumiendo servicio REST - crear producto');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);