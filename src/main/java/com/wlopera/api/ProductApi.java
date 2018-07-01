/**
 * La clase que va a ser nuestro servicio Web, con m�todos. 
 * �nicamente hay que poner las anotaciones espec�ficas de JAX-RS para que el contenedor de aplicaciones lo convierta en servicio web 
 * cuando arranque. Las anotaciones son las siguientes:
 *   @Path para indicar el path en la url donde estar� nuestro servicio web
 *   @Produces para indicar el formato en el que el servicio web nos devuelve el resultado. Son habituales "application/xml" y "application/json".
 *   @Consumes para indicar el formato en el que nuestro servicio web admite los datos. Igual que @Produces, son habituales "application/xml" y "application/json".
 * El protocolo http define varios m�todos para las peticiones http. En los web services son habituales las cuatro siguientes:
 *   @GET Cuando queremos pedir datos al servicio web. Por ejemplo, 
 *        una petici�n @GET a http://localhost:8080/ExampleRestFull/resources/service/grow => devolver la lista de productos cultivados y una llamada a 
 *        http://localhost:8080/ExampleRestFull/resources/service/grow/23 podr�a devolver los datos del cultivo cuyo identificador es 23.
 *   @POST Cuando enviamos datos al servicio web para que el servicio web haga con ellos lo que considere oportuno. 
 *   Por ejemplo, una llamada @POST a http://localhost:8080/ExampleRestFull/resources/service/agregar_cultivos
 *   pasando los datos de un cultivo, puede crear el empleo en base de datos.
 *   @PUT Cuando queremos guardar datos en una url espec�fica. Si esos datos no existen en esa URL, se crean. 
 *   	Si ya existen, deben modificarse para que sean lo que nosotros hemos pasado. 
 *   	Por ejemplo, una llamada @PUT a http://localhost:8080/ExampleRestFull/resources/service/agregar_cultivo/23 pas�ndole datos de un cultivo, 
 *   	modificar�a los datos del producto cultivado cuyo identificador es el 23 para que sean los que nosotros pasamos. 
 *   	Si no hay ning�n producto con identificador 23, deber�a crearse un nuevo rubro de ese producto y asignarle un identificador.
 *   @DELETE Para borrar los datos de una url espec�fica. Por ejemplo, una llamada @DELETE a 
 *   http://localhost:8080/ExampleRestFull/resources/service/grow/delete/23 deber�a eliminar el producto de identificador 23.
 */
package com.wlopera.api;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wlopera.model.ProductDTO;

@RestController
public class ProductApi {

	 @RequestMapping(value="/grow", method=RequestMethod.GET)
	 public  List<ProductDTO> getProductosCultivados() {
		
		System.out.println("##=> Conectado /service/cultivar/");
		
		List<ProductDTO> result = new LinkedList<ProductDTO>();
		result.add(new ProductDTO(1, "Tomate", 50.0));
		result.add(new ProductDTO(2, "Papa", 20.0));
		result.add(new ProductDTO(3, "Cebolla", 30.0));
		result.add(new ProductDTO(4, "Pimeton", 40.0));
		result.add(new ProductDTO(5, "Ajo", 25.0));
		
		System.out.println(result.toString());
		return result;
	}

	 @RequestMapping(value="/import", method=RequestMethod.GET)
	 public List<ProductDTO> getProductDTOImportados() {
		System.out.println("##=> Conectado /service/importar/");
		
		List<ProductDTO> result = new LinkedList<ProductDTO>();
		result.add(new ProductDTO(1, "Tomate", 5.0)); 
		result.add(new ProductDTO(2, "Papa", 12.0));
		result.add(new ProductDTO(3, "Cebolla", 4.0));
		result.add(new ProductDTO(4, "Pimeton", 6.0));
		result.add(new ProductDTO(5, "Ajo", 3.0));
		
		System.out.println(result.toString());
		return result;
	}
	
	 @RequestMapping(value="/create", method=RequestMethod.POST)
	 public String save(@RequestBody ProductDTO product){
		 System.out.println(product.toString()+ " almacenar en BD");
		 return product.toString()+ " almacenar en BD";
	 }
	 
	// TODO: Falta servicios. POST - PUT - DElETE - otros GET

}