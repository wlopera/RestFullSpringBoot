// ProductService: Permite consumir los servicios REST del Backend
// scope: Alcance de variables 
// hhtp: libreria HTPP consulta de servicios REST

'use strict';
 
angular.module('ProductApp').controller('ProductController', ['$scope', 'ProductService', function($scope, ProductService) {
	var self = this;
	self.mostrar = false; 		// Variable para mostrar resultados
	self.acionProducto = ""; 	// Variable para mostrar tipo de producto cultivado/importado
	self.productos = {};     	// Productos encontrados en la consulta
	self.message = "";

	// Permite consultar cantidad de productos cultivados
	self.growProduct = function() {
		ProductService.growProduct()
            .then(function (response) {
            	self.mostrar = true;
            	self.acionProducto = "Cultivadas";
            	self.productos=response;
        	    console.log("##=> Productos cultivados: ", response);
            },
            function(errResponse){
                console.error('Error consultando servicio - cultivar productos: ' + errResponse);
                self.mostrar = false;
            }
        );
    }
	
	// Permite consultar cantidad de productos importados
	self.importProduct = function() {
		ProductService.importProduct()
            .then(function (response) {
            	self.mostrar = true;
            	self.acionProducto = "Importadas";
            	self.productos=response;
          	    console.log("##=> Productos importados: ", response);
            },
            function(errResponse){
                console.error('Error consultando servicio - importar productos: ' + errResponse);
                self.mostrar = false;
            }
        );
    }

	// Permite enviar formulario productos cultivados - protocolo HTTP - POST
	self.createProduct = function() {
		var data = JSON.stringify({id:10,nombre:"Tomate",cantidad:100.0});
		self.mostrar = false;
		ProductService.createProduct(data)
            .then(function (response) {
            	self.message = JSON.stringify(response);
                console.log("##=> Productos cultivados a almacenar: ");              	
            },
            function(errResponse){
            	self.message = JSON.stringify(errResponse);
                console.error('Error consumiendo servicio - crear producto: ' + errResponse);                
            }
        );
    }

}]);